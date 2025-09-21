package _09_Polymorphism_Lab.P03_Animals;

public class Dog extends Animal {

    public Dog(String name, String favoriteFood) {
        super(name, favoriteFood);
    }

    @Override
    public String explainSelf(){
        return super.explainSelf() + "DJAAF";
    }
}
