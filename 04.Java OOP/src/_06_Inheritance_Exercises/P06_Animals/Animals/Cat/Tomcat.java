package _06_Inheritance_Exercises.P06_Animals.Animals.Cat;

public class Tomcat extends Cat {

    public Tomcat(String name, int age) {
        super(name, age, "Male");
    }

    public String produceSound() {
        return "MEOW";
    }
}
