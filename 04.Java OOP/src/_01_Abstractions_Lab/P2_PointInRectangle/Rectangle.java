package _01_Abstractions_Lab.P2_PointInRectangle;

public class Rectangle {

    private Point topRight;
    private Point bottomLeft;

    public Rectangle(Point topRight, Point bottomLeft) {
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
    }

    public Point getBottomLeft() {
        return bottomLeft;
    }

    public Point getTopRight() {
        return topRight;
    }

    public boolean contains(Point point) {

        boolean isXInside = point.getX() >= bottomLeft.getX() &&
                point.getX() <= topRight.getX();

        boolean isYInside = point.getY() >= bottomLeft.getY() &&
                point.getY() <= topRight.getY();

        return isXInside && isYInside;
    }
}
