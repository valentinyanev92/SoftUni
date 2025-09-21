package exercises;

import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.Comparator;
import java.util.Scanner;

public class GetEmployeeWithProject {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        System.out.print("Enter the id of the employee you want to search: ");
        int employeeId = Integer.parseInt(scanner.nextLine());
        ;

        TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e WHERE e.id = :employeeId", Employee.class);
        query.setParameter("employeeId", employeeId);


        Employee employee = query.getSingleResult();
        System.out.printf("%s %s - %s%n", employee.getFirstName(), employee.getLastName(), employee.getDepartment().getName());
        for (Project project : employee.getProjects().stream().sorted(Comparator.comparing(Project::getName)).toArray(Project[]::new)) {
            System.out.println(project.getName());
        }

//        Set<Project> projects = employee.getProjects();
//        for (Project project : projects) {
//            System.out.println("\t" + project.getName());
//        }
    }
}