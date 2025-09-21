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

        User user = new User("bankin", 20, LocalDate.now());
        Order order = new Order(20, LocalDate.now());

        MyConnector.createConnection("root", "root", "mini_orm");
        Connection connection = MyConnector.getConnection();

        EntityManager<User> userEntityManager = new EntityManager<>(connection);
//        EntityManager<Order> orderEntityManager = new EntityManager<>(connection);

//        userEntityManager.persist(user);
//        orderEntityManager.persist(order);

        User fromDb = userEntityManager.findFirst(User.class, "id = 2");
//        User fromDb2 = userEntityManager.findFirst(User.class);

//        System.out.println(fromDb2.getName());
//        System.out.println(orderFromDb.getUsername());

//        Order first = orderEntityManager.findFirst(Order.class);
//        System.out.println(first.getOrderId());

//        Iterable<User> users = userEntityManager.find(User.class);
//
//        users.forEach(u -> System.out.println(u.getName()));

        fromDb.setName("edited");
        userEntityManager.persist(fromDb);
    }
}
