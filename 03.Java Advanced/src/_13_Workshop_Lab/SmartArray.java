package _13_Workshop_Lab;

import java.util.Arrays;
import java.util.function.Consumer;

public class SmartArray {
    private static final int INITIAL_CAPACITY = 4;

    private int[] data;
    private int size;
    private int capacity;

    public SmartArray() {
        data = new int[INITIAL_CAPACITY];
        capacity = INITIAL_CAPACITY;
    }

    public void add(int element) {
        data[size] = element;
        size++;
        if (size == capacity) {
            data = Arrays.copyOf(data, capacity * 2);
            capacity = data.length;
        }
    }

    public int get(int index) {
        return data[index];
    }

    public int remove(int index) {
        int removed = get(index);
        int temp;
        for (int i = index; i < data.length - 1; i++) {
            temp = data[i + 1];
            data[i] = temp;
        }
        size--;

        if (capacity % size > 1) {
            data = Arrays.copyOf(data, capacity / 2);
            capacity = data.length;
        }
        return removed;
    }

    public boolean contain(int element) {
        for (int i = 0; i < size; i++) {
            if (data[i] == element) {
                return true;
            }
        }
        return false;
    }

    public void add(int firstIndex, int element) {
        int temp = data[firstIndex];
        data[firstIndex] = element;
        size++;

        if (size == capacity) {
            data = Arrays.copyOf(data, capacity * 2);
            capacity = data.length;
        }

        for (int i = firstIndex + 1; i < size; i++) {
            data[i] = temp;
            temp = data[i + 1];
        }
    }

    public void forEach(Consumer<Integer> action) {
        for (int i = 0; i < size; i++) {
            action.accept(data[i]);
        }
    }

}
