package _09_Polymorphism_Lab.P02_Shapes;

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public final double getRadius() {
        return radius;
    }


    @Override
    public double calculatePerimeter() {
        super.setPerimeter((2*radius)*Math.PI);
        return (2*radius)*Math.PI;
    }

    @Override
    public double calculateArea() {
        super.setArea((radius*radius)*Math.PI);
        return Math.PI * radius * radius;
    }
}
