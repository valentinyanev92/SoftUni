package _05_Inheritance_Lab.P03_RandomArrayList;

public class Main {

    public static void main(String[] args) {
        RandomArrayList randomArrayList = new RandomArrayList();
        randomArrayList.add("a");
        randomArrayList.add("b");
        randomArrayList.add("c");
        randomArrayList.add("d");

        String random = randomArrayList.getRandomElement();
        System.out.println(random);
    }
}
