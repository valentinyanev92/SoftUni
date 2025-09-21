package exercises;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class EmployeeWithSalaryOver50000 {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        List<Employee> employees = em.createQuery("SELECT e FROM Employee e where salary >= 50000").getResultList();

//        List<Employee> employees = em.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
//        for (Employee employee : employees) {
//            BigDecimal salary = employee.getSalary();
//            if (salary.compareTo(BigDecimal.valueOf(50000)) > 0) {
//                System.out.println(employee.getFirstName());
//            }
//        }
        for (Employee employee : employees) {
            System.out.println(employee.getFirstName());
        }
    }
}