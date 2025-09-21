package _15_Generic_Exercise.CustomListSorter;

import java.util.ArrayList;
import java.util.List;

public class CustomList<T extends Comparable<T>>{
    private List<T> list;

    public CustomList() {
        this.list = new ArrayList<>();
    }

    public void add(T element) {
        list.add(element);
    }

    public T remove(int index) {
        if (index >= 0 && index < list.size()) {
            return list.remove(index);
        }
        return null;  // Invalid index
    }

    public boolean contains(T element) {
        return list.contains(element);
    }

    public void swap(int index1, int index2) {
        if (index1 >= 0 && index1 < list.size() && index2 >= 0 && index2 < list.size()) {
            T temp = list.get(index1);
            list.set(index1, list.get(index2));
            list.set(index2, temp);
        }
    }

    public int countGreaterThan(T element) {
        int count = 0;
        for (T e : list) {
            if (e.compareTo(element) > 0) {
                count++;
            }
        }
        return count;
    }

    public T getMax() {
        if (list.isEmpty()) {
            return null;
        }
        T max = list.get(0);
        for (T e : list) {
            if (e.compareTo(max) > 0) {
                max = e;
            }
        }
        return max;
    }

    public T getMin() {
        if (list.isEmpty()) {
            return null;
        }
        T min = list.get(0);
        for (T e : list) {
            if (e.compareTo(min) < 0) {
                min = e;
            }
        }
        return min;
    }

    public void print() {
        for (T element : list) {
            System.out.println(element);
        }
    }

    public List<T> getList() {
        return list;
    }
}
