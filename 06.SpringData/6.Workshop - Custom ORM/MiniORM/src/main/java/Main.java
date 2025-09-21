import entities.Order;
import entities.User;
import orm.EntityManager;
import orm.MyConnector;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws SQLException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {
        MyConnector.createConnection("root", "root", "mini_orm");
        Connection connection = MyConnector.getConnection();

        EntityManager<User> userEM = new EntityManager<>(connection);
        userEM.createTable(User.class);

        EntityManager<Order> orderEM = new EntityManager<>(connection);
        orderEM.createTable(Order.class);

        User user = new User("bankin", 20, LocalDate.now());
        Order order = new Order(20, LocalDate.now());

        userEM.persist(user);
        orderEM.persist(order);
    }
}