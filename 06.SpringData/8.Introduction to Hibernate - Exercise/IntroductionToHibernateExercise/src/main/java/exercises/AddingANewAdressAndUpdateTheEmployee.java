package exercises;

import entities.Address;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class AddingANewAdressAndUpdateTheEmployee {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        Address address = new Address();
        address.setText("Vitoshka 15");
        em.persist(address);

        em.getTransaction().begin();
        List<Employee> employees = em.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
        String lastName = input.nextLine();

        employees.forEach(employee -> {
            if (employee.getLastName().equals(lastName)) {
                employee.setAddress(address);
                em.persist(employee);
            }else {
                em.detach(employee);
            }
        });
        em.getTransaction().commit();
    }
}