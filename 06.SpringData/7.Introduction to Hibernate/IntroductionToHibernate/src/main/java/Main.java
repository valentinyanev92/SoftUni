import entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure();

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();

//        Student test = new Student();
//        test.setName("Jack");
//
//        session.save(test);

        Student find = session.get(Student.class, 1);
        System.out.println(find.getName());
        session.delete(find);


        session.getTransaction().commit();
        session.close();
    }

}