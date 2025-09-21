package _14_Reflection_Exercises.P02_BlackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);

        Constructor<BlackBoxInt> constructor = BlackBoxInt.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt blackBoxInt = constructor.newInstance();

        Method[] methods = BlackBoxInt.class.getDeclaredMethods();

        Field innerValue = blackBoxInt.getClass().getDeclaredField("innerValue");
        innerValue.setAccessible(true);

        String input = scanner.nextLine();
        while (!input.equals("END")) {

            String command = input.split("_")[0];
            int value = Integer.parseInt(input.split("_")[1]);

            Method currentMethod = Arrays.stream(methods)
                    .filter(method -> method.getName().equals(command))
                    .findFirst().orElse(null);

            if (currentMethod != null) {
                currentMethod.setAccessible(true);
                currentMethod.invoke(blackBoxInt, value);

                System.out.println(innerValue.get(blackBoxInt));
            }

            input = scanner.nextLine();
        }
    }
}