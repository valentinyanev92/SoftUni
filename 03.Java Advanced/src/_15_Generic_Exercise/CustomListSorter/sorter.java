package _15_Generic_Exercise.CustomListSorter;

import java.util.Collections;

public class sorter {
    public static <T extends Comparable<T>> void sort(CustomList<T> customList) {
        Collections.sort(customList.getList());
    }
}
