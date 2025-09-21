package _14_Generics_Lab.GenericArrayCreator;

import java.lang.reflect.Array;

public class ArrayCreator{



    public static <T> T[] create(int length, T item) {
        @SuppressWarnings("unchecked")
        T[] array = (T[]) Array.newInstance(item.getClass(), length);

        for (int i = 0; i < length; i++) {
            array[i] = item;
        }

        return array;
    }

    public static <T> T[] create(Class<T> clazz, int length, T item) {
        @SuppressWarnings("unchecked")
        T[] array = (T[]) Array.newInstance(clazz, length);

        for (int i = 0; i < length; i++) {
            array[i] = item;
        }

        return array;
    }
}
