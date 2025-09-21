package _13_Reflection_Lab.Demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

public class Demo {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Employee employee = new Employee("Sasho", "Plovdiv");

        //access class
        Class<Employee> employeeClass1 = Employee.class;
        Class<Employee> employeeClass2 = (Class<Employee>) Class.forName("_13_Reflection_Lab.Demo.Employee");
        Class<? extends Employee> employeeClass3 = employee.getClass();

        //get parent class
        Class<? super Employee> superclass = employeeClass1.getSuperclass();
        //get interface
        Class<?>[] interfaces = employeeClass1.getInterfaces();

        //access fields
        Field[] declaredFields = employeeClass1.getDeclaredFields(); //return all fields
        Field[] publicFields = employeeClass1.getFields(); //return public fields

        //iterate over all fields
        for (Field field : declaredFields) {
            System.out.println(field.getName());
            System.out.println(Modifier.toString(field.getModifiers()));
            System.out.println(Modifier.isPrivate(field.getModifiers()));
            System.out.println();
        }

        //access constructors
        Constructor<Employee> allArgConstructor = employeeClass1.getDeclaredConstructor(String.class, String.class);
        Constructor<Employee> noArgConstructor = employeeClass1.getDeclaredConstructor();

        //create instance of a class using reflection
        Employee sasho = allArgConstructor.newInstance("sasho", "plovdiv");

        noArgConstructor.setAccessible(true); // set accessible
        Employee noName = noArgConstructor.newInstance();



        System.out.println();


    }
}
