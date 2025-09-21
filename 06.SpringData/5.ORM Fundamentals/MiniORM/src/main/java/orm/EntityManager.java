package orm;

import orm.annotations.Column;
import orm.annotations.Entity;
import orm.annotations.Id;
import orm.exeptions.ORMException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

public class EntityManager<E> implements DbContext<E> {
    private static final String INSERT_QUERY = "INSERT INTO %s (%s) VALUES (%s)";
    private static final String SELECT_QUERY_WITH_WHERE_LIMIT = "SELECT * FROM %s %s %s";
    private static final String UPDATE_QUERY = "UPDATE %s SET %s WHERE %s = %s";


    private final Connection connection;

    public EntityManager(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean persist(E entity) throws IllegalAccessException, SQLException {
        //todo check if this is @Entity class
        Field idField = getIdField(entity);
        int id = getIdFieldValue(entity, idField);

        if (id == 0) {
            return doInsert(entity);
        }

        return doUpdate(entity);
    }

    private boolean doUpdate(E entity) throws IllegalAccessException, SQLException {
        String tableName = getTableName(entity.getClass());
        String fieldListWithValues = getFieldsWithValues(entity);
        Field idColumn = getIdField(entity);
        int idValue = getIdFieldValue(entity, idColumn);

        String sql = String.format(UPDATE_QUERY, tableName, fieldListWithValues, idColumn.getName(), idValue);

        return this.connection.prepareStatement(sql).executeUpdate() > 0;
    }

    private String getFieldsWithValues(E entity) {
        List<String> columnName = getColumnNamesWithoutId(entity);
        List<String> values = getValuesWithoutId(entity);

        List<String> result = new ArrayList<>();
        for (int i = 0; i < columnName.size(); i++) {
            result.add(columnName.get(i) + "=" + values.get(i));
        }

//        return IntStream.range(0, columnName.size())
//                .boxed()
//                .map(i -> columnName.get(i) + "=" + values.get(i))
//                .collect(Collectors.joining(","));

        return String.join(",", result);
    }

    private boolean doInsert(E entity) throws SQLException {
        String tableName = getTableName(entity.getClass());
        List<String> columnName = getColumnNamesWithoutId(entity);
        List<String> values = getValuesWithoutId(entity);

        String sql = String.format(INSERT_QUERY, tableName, String.join(",", columnName), String.join(",", values));
        return this.connection.prepareStatement(sql).executeUpdate() > 0;
    }

    private List<String> getValuesWithoutId(E entity) {
        return Arrays.stream(entity
                        .getClass()
                        .getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Column.class))
                .filter(field -> !field.isAnnotationPresent(Id.class))
                .map(field -> {
                    try {
                        field.setAccessible(true);
                        return field.get(entity);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                })
                .map(Object::toString)
                .map(s -> "'" + s + "'")
                .toList();
    }

    private List<String> getColumnNamesWithoutId(E entity) {
        return Arrays.stream(entity
                        .getClass()
                        .getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Column.class))
                .filter(field -> !field.isAnnotationPresent(Id.class))
                .map(field -> field.getAnnotation(Column.class).name())
                .toList();
    }

    private String getTableName(Class<?> clazz) {
        Entity annotation = clazz
                .getAnnotation(Entity.class);

        if (annotation == null) {
            throw new ORMException("Class must have @Entity annotation");
        }

        return annotation.name();
    }

    private int getIdFieldValue(E entity, Field idField) throws IllegalAccessException {
        idField.setAccessible(true);
        Object value = idField.get(entity);

        return Integer.parseInt(value.toString());
    }

    private Field getIdField(E entity) {
        Optional<Field> idField = Arrays.stream(entity
                        .getClass()
                        .getDeclaredFields())
                .filter(f -> f.isAnnotationPresent(Id.class))
                .findFirst();

        if (idField.isEmpty()) {
            throw new ORMException("Entity without @Id field");
        }

        return idField.get();
    }

    @Override
    public Iterable<E> find(Class<E> clazz) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return find(clazz, null);
    }

    @Override
    public Iterable<E> find(Class<E> clazz, String where) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return baseFind(clazz, where, null);
    }

    private Iterable<E> baseFind(Class<E> clazz, String where, Integer limit) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String tableName = getTableName(clazz);
        String computedWhere = where == null ? "" : "WHERE " + where;
        String computedLimit = limit == null ? "" : "LIMIT " + limit;

        String sql = String.format(SELECT_QUERY_WITH_WHERE_LIMIT, tableName, computedWhere, computedLimit);

        ResultSet result = connection.prepareStatement(sql).executeQuery();

        List<E> iterable = new ArrayList<>();
        while (result.next()) {
            E nextItem = fillEntity(result, clazz);

            iterable.add(nextItem);
        }

        return iterable;
    }

    @Override
    public E findFirst(Class<E> clazz) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return findFirst(clazz, null);
    }

    @Override
    public E findFirst(Class<E> clazz, String where) throws SQLException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Iterable<E> items = baseFind(clazz, where, 1);

        Iterator<E> iterator = items.iterator();

        if (!iterator.hasNext()) {
            return null;
        }

        return iterator.next();
    }

    private E fillEntity(ResultSet result, Class<E> clazz) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        E resultEntity = clazz.getDeclaredConstructor().newInstance();

        Arrays.stream(clazz.getDeclaredFields())
                .filter(f -> f.isAnnotationPresent(Column.class))
                .forEach(f -> {
                    try {
                        fillField(resultEntity, result, f);
                    } catch (SQLException | IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                });

        return resultEntity;
    }

    private void fillField(E entity, ResultSet result, Field field) throws SQLException, IllegalAccessException {
        String columnName = field.getAnnotation(Column.class).name();

        String fieldValue = result.getString(columnName);
        Object value = getValueWithCorrectType(fieldValue, field.getType());

        field.setAccessible(true);
        field.set(entity, value);
    }

    private Object getValueWithCorrectType(String fieldValue, Class<?> type) {
        if (type == int.class || type == Integer.class) {
            return Integer.parseInt(fieldValue);
        } else if (type == String.class || type == char.class || type == Character.class) {
            return fieldValue;
        } else if (type == LocalDate.class) {
            return LocalDate.parse(fieldValue);
        } else if (type == double.class || type == Double.class) {
            return Double.parseDouble(fieldValue);
        }

        throw new ORMException("Unsupported data type " + type);
    }
}