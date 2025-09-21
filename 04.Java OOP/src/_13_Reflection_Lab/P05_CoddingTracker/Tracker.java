package _13_Reflection_Lab.P05_CoddingTracker;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class Tracker {

    private List<String> methods;

    @Author(name = "Peter")
    public static void printMethodsByAuthor(Class<?> cl){
        Method[] declaredMethods = cl.getDeclaredMethods();
        Arrays.stream(declaredMethods).filter(method -> method.isAnnotationPresent(Author.class)).
                forEach(method -> {
                    Author author = method.getAnnotation(Author.class);
                    System.out.printf("%s: %s()",author.name(), method.getName());
                    System.out.println();
                });

    }
}
