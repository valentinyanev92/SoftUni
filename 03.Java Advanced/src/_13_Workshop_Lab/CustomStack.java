package _13_Workshop_Lab;

import java.util.Arrays;
import java.util.function.Consumer;

public class CustomStack {
    private static final int INITIAL_CAPACITY = 4;

    private int[] data;
    private int size;
    private int capacity;

    CustomStack() {
        data = new int[INITIAL_CAPACITY];
        size = 0;
        capacity = INITIAL_CAPACITY;
    }

    public void push(int element) {
        data[size] = element;
        size++;
        if (size == capacity) {
            data = Arrays.copyOf(data, capacity * 2);
            capacity *= 2;
        }
    }

    public int pop() {
        int element = data[size - 1];
        data[size - 1] = 0;
        size--;
        if (capacity % size > 1) {
            data = Arrays.copyOf(data, capacity / 2);
            capacity /= 2;
        }

        return element;
    }

    public int peek() {
        int element = data[size - 1];

        return element;
    }

    public void forEach(Consumer<? super Integer> consumer) {
        for (int i = 0; i < size; i++) {
            consumer.accept(data[i]);
        }
    }

}
