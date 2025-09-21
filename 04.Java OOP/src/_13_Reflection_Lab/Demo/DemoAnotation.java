package _13_Reflection_Lab.Demo;

public class DemoAnotation {

    public static void main(String[] args) {

        Employee employee = new Employee("sasho", "plovdiv");

        Company annotation = employee.getClass().getAnnotation(Company.class);
        System.out.println(annotation.name());
    }
}
