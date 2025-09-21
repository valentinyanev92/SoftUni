package _13_Reflection_Lab.P03_HighQualityMistakes;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class reflection = Reflection.class;

        Field[] declaredFields = reflection.getDeclaredFields();

        for (Field declaredField : declaredFields) {
            if (!Modifier.isPrivate(declaredField.getModifiers())) {
                System.out.println("For Fields: " + declaredField.getName() + " must be private!");
            }
        }

        Method[] declaredMethods = reflection.getDeclaredMethods();
        Arrays.stream(declaredMethods).filter(declaredMethod -> declaredMethod.getName().startsWith("get")).forEach(declaredMethod -> {
            if (!Modifier.isPublic(declaredMethod.getModifiers())) {
                System.out.println("For Getters: " + declaredMethod.getName() + " must be public!");
            }
        });

        Arrays.stream(declaredMethods).filter(declaredMethod -> declaredMethod.getName().startsWith("set")).forEach(declaredMethod -> {
           if (!Modifier.isPrivate(declaredMethod.getModifiers())) {
               System.out.println("For Setters: " + declaredMethod.getName() + " must be private!");
           }
        });
    }
}
