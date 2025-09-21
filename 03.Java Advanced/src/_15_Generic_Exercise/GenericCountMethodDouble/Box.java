package _15_Generic_Exercise.GenericCountMethodDouble;

public class Box<T extends Comparable<T>>  {
    private T value;

    public Box(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.getClass().getName() + ": " + value;
    }

    public T getValue() {
        return value;
    }
}