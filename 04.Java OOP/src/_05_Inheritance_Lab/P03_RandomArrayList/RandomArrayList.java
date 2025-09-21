package _05_Inheritance_Lab.P03_RandomArrayList;

import java.util.ArrayList;

public class RandomArrayList extends ArrayList {
    private String[] data;
    private int size;

    public RandomArrayList() {
        this.data = new String[10];
        this.size = 0;
    }

    public String getRandomElement(){
        int index = (int) (Math.random() * size);
        String temp = (String) super.get(index);
        super.remove(index);
        this.size--;
        return temp;
    }

}
