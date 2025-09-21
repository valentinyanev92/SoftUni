package _12_ObjectAndClasses_MoreExercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CompanyRoster {
    static class Employee {
        String name;
        double salary;
        String position;
        String department;
        String email = "n/a";
        int age = -1;

        Employee() {
        }

        public String getDepartment() {
            return department;
        }

        public String getName() {
            return name;
        }

        public double getSalary() {
            return salary;
        }


        public void setName(String name) {
            this.name = name;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    static class Department {
        String name;
        double salary;
        String department;
        String email = "n/a";
        int age = -1;

        Department() {
        }

        public double getSalary() {
            return salary;
        }

        public String getDepartment() {
            return department;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setAge(int age) {
            this.age = age;
        }

        String print() {
            return String.format("%s %.2f %s %d", name, salary, email, age);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfEmployee = Integer.parseInt(scanner.nextLine());

        List<Employee> employeeList = new ArrayList<>();
        List<Department> departmentList = new ArrayList<>();

        String input;
        for (int i = 0; i < numberOfEmployee; i++) {
            input = scanner.nextLine();
            String[] inputArr = input.split(" ");

            Employee employee = getEmployee(inputArr);
            employeeList.add(employee);

            Department department = getDepartment(inputArr);
            departmentList.add(department);
        }

        List<String> departmentSale = new ArrayList<>();
        for (int i = 0; i < employeeList.size(); i++) {
            String get = employeeList.get(i).getDepartment() + " " + employeeList.get(i).getSalary();
            departmentSale.add(get);
        }

        double midSale = 0;
        String midDepartment = "";
        double bestSale = 0;
        String bestDepartment = "";
        int bestCount = 1;
        int midCount = 0;

        Collections.sort(departmentSale);
        for (int i = 0; i < departmentSale.size() - 1; i++) {
            String[] midArr = departmentSale.get(i).split(" ");
            midDepartment = midArr[0];
            midSale += Double.parseDouble(midArr[1]);
            midCount++;
            String[] nextArr = departmentSale.get(i + 1).split(" ");

            if (midSale / midCount - 1 > bestSale / bestCount) {
                bestDepartment = midDepartment;
                bestSale = midSale;
                bestCount = midCount;
            }

            if (!midDepartment.equals(nextArr[0])) {
                midSale = 0;
                midCount = 0;
            }

            if (i == departmentSale.size() - 1) {
                if (!midDepartment.equals(nextArr[0])) {
                    if (Double.parseDouble(nextArr[1]) > bestSale) {
                        bestDepartment = nextArr[0];
                        bestSale = Double.parseDouble(nextArr[1]);
                        bestCount = 1;
                    }
                }
            }
        }

        departmentList.sort((n1, n2) -> Double.compare(n2.getSalary(), n1.getSalary()));
        System.out.println("Highest Average Salary: " + bestDepartment);
        for (int i = 0; i < departmentList.size(); i++) {
            if (departmentList.get(i).getDepartment().equals(bestDepartment)) {
                System.out.println(departmentList.get(i).print());
            }
        }
    }

    private static Employee getEmployee(String[] inputArr) {
        Employee employee = new Employee();
        for (int j = 0; j < inputArr.length; j++) {
            switch (j) {
                case 0:
                    employee.setName(inputArr[0]);
                    break;
                case 1:
                    employee.setSalary(Double.parseDouble(inputArr[1]));
                    break;
                case 2:
                    employee.setPosition(inputArr[2]);
                    break;
                case 3:
                    employee.setDepartment(inputArr[3]);
                    break;
                case 4:
                    if (isNumeric(inputArr[4])) {
                        employee.setAge(Integer.parseInt(inputArr[4]));
                        break;
                    } else {
                        employee.setEmail(inputArr[4]);
                        break;
                    }
                case 5:
                    employee.setAge(Integer.parseInt(inputArr[5]));
                    break;
            }
        }
        return employee;
    }

    private static Department getDepartment(String[] inputArr) {
        Department department = new Department();
        for (int j = 0; j < inputArr.length; j++) {
            switch (j) {
                case 0:
                    department.setName(inputArr[0]);
                    break;
                case 1:
                    department.setSalary(Double.parseDouble(inputArr[1]));
                    break;
                case 2:
                    break;
                case 3:
                    department.setDepartment(inputArr[3]);
                    break;
                case 4:
                    if (isNumeric(inputArr[4])) {
                        department.setAge(Integer.parseInt(inputArr[4]));
                        break;
                    } else {
                        department.setEmail(inputArr[4]);
                        break;
                    }
                case 5:
                    department.setAge(Integer.parseInt(inputArr[5]));
                    break;
            }
        }
        return department;
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}