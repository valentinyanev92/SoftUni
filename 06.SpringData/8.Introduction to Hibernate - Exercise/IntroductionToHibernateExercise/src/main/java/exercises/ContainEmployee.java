package exercises;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.Scanner;

public class ContainEmployee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        System.out.print("Enter employee name: ");
        String[] input = scanner.nextLine().split("\\s+");
        String firstName = input[0];
        String lastName = input[1];

        TypedQuery<Employee> query = em.createQuery("select e from Employee e where e.firstName = :firstName and e.lastName = :lastName", Employee.class);
        query.setParameter("firstName", firstName);
        query.setParameter("lastName", lastName);

        try {
            Employee employee = query.getSingleResult();
            System.out.println("Yes");
        } catch (Exception e) {
            System.out.println("No");
        }

        em.close();
    }
}
