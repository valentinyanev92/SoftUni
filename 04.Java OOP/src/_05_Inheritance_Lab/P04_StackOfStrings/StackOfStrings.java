package _05_Inheritance_Lab.P04_StackOfStrings;

import java.util.ArrayList;
import java.util.Stack;

public class StackOfStrings extends Stack<String> {

    private ArrayList<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public String push(String item) {
        this.data.add(item);
        return item;
    }

    public String pop() {
        return this.data.remove(this.data.size() - 1);
    }

    public String peek() {
        return this.data.get(this.data.size() - 1);
    }

    public boolean isEmpty() {
        return this.data.isEmpty();
    }

}
