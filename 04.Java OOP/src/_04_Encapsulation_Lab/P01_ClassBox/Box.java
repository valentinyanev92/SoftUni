package _04_Encapsulation_Lab.P01_ClassBox;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
        this.height = height;
    }

    public double calculateSurfaceArea() {
        return 2 * (getLength() * getWidth() + getWidth() * getHeight() + getHeight() * getLength());
    }

    public double calculateLateralSurfaceArea() {
        return 2 * (this.getLength() * this.getHeight()) +
                2 * (this.getWidth() * this.getHeight());
    }

    public double calculateVolume() {
        return this.getLength() * this.getWidth() * this.getHeight();
    }
}
