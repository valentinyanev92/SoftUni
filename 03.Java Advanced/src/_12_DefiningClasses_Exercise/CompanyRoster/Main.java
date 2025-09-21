package _12_DefiningClasses_Exercise.CompanyRoster;

import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int employeeCount = Integer.parseInt(scanner.nextLine());
        List<Employee> employees = new ArrayList<Employee>();

        for (int i = 0; i < employeeCount; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];
            String email;
            int age;

            if (tokens.length == 6) {
                email = tokens[4];
                age = Integer.parseInt(tokens[5]);
                Employee employee = new Employee(name, salary, position, department, email, age);
                employees.add(employee);
            }else if (tokens.length == 5) {
                try {
                    age = Integer.parseInt(tokens[4]);
                    Employee employee = new Employee(name, salary, position, department, age);
                    employees.add(employee);
                } catch (Exception e) {
                    email = tokens[4];
                    Employee employee = new Employee(name, salary, position, department, email);
                    employees.add(employee);
                }
            } else {
                Employee employee = new Employee(name, salary, position, department);
                employees.add(employee);
            }
        }

        Map<String, Double> departmentsAverage = new HashMap<>();
        employees.forEach(employee -> {
            Employee currentEmployee = employee;
            String departmentName = employee.getDepartment();
            Double currentEmployeeSalary = currentEmployee.getSalary();
            if (departmentsAverage.containsKey(departmentName)) {
                departmentsAverage.put(departmentName, (departmentsAverage.get(departmentName) + currentEmployeeSalary)/2);
            }else {
                departmentsAverage.put(departmentName, currentEmployeeSalary);
            }
        });

        String bestDepartment = "";
        double bestSalary = 0;
        for (Map.Entry<String, Double> entry : departmentsAverage.entrySet()) {
            if (entry.getValue() > bestSalary) {
                bestDepartment = entry.getKey();
                bestSalary = entry.getValue();
            }
        }

        Map<Employee, Double> employeesAverage = new HashMap<>();
        String finalBestDepartment = bestDepartment;
        employees.forEach(employee -> {
           if (finalBestDepartment.equals(employee.getDepartment())){
               employeesAverage.put(employee, employee.getSalary());
           }
        });

        System.out.println("Highest Average Salary: " + bestDepartment);
        Stream<Map.Entry<Employee,Double>> sorted =
                employeesAverage.entrySet().stream()
                        .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()));

        sorted.forEach( (employee) -> {
            Employee currentEmployee = employee.getKey();
            System.out.println(currentEmployee.toString());
        });
    }
}
