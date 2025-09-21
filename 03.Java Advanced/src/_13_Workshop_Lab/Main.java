package _13_Workshop_Lab;

public class Main {

    public static void main(String[] args) {

        CustomStack stack = new CustomStack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);
        stack.push(70);
        stack.push(80);
        stack.push(90);


        stack.forEach(System.out::println);

    }
}
