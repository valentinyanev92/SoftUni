package _09_Polymorphism_Lab.P02_Shapes;

public abstract class Shape {
    private double perimeter;
    private double area;

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public final double getPerimeter() {
        return perimeter;
    }

    public final double getArea() {
        return area;
    }

    public abstract double calculatePerimeter();
    public abstract double calculateArea();
}
