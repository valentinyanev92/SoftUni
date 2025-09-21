package _09_Polymorphism_Lab.P02_Shapes;

public class Rectangle extends Shape {
    private double height;
    private double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public final double getHeight() {
        return height;
    }

    public final double getWidth() {
        return width;
    }

    @Override
    public double calculatePerimeter() {
        super.setPerimeter(2*getHeight() + 2*getWidth());
        return 2*getHeight() + 2*getWidth();
    }

    @Override
    public double calculateArea() {
        super.setArea(getHeight() * getWidth());
        return getHeight()*getWidth();
    }
}
