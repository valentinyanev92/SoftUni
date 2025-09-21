package _13_Reflection_Lab.P05_CoddingTracker;

public class Main {

    @Author(name = "George")
    public static void main(String[] args){

        Tracker.printMethodsByAuthor(Main.class);
        Tracker.printMethodsByAuthor(Tracker.class);
    }

    @Author(name = "George")
    public void test(){}
}
