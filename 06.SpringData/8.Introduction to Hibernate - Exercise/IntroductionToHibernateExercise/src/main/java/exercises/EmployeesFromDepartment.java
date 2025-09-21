package exercises;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class EmployeesFromDepartment {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();


        String searchedDepartmentName = "Research and Development";
//        TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e " +
//                "JOIN e.department d " +
//                "where d.name = :searchedDepartment " +
//                "order by e.salary, e.id ", Employee.class);
        TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e where e.department.name = :searchedDepartment", Employee.class);
        query.setParameter("searchedDepartment", searchedDepartmentName);

        List<Employee> employees = query.getResultList();
        for (Employee employee : employees) {
            System.out.println(employee.getFirstName() + " " + employee.getLastName() + " from " + employee.getDepartment().getName() + " - $" + employee.getSalary());
        }
    }
}
