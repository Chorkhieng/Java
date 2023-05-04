public class Point2D {

    // The coordinates of the point
    private double x;
    private double y;

    public Point2D() {
        this.x = 0.0;
        this.y = 0.0;
    }

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // getters

    double getX() {
        return x;
    }

    double getY() {
        return y;
    }

    // setters

    void setX(double newX) {
        this.x = newX;
    }

    void setY(double newY) {
        this.y = newY;
    }

    @Override
    public String toString() {
        return String.format("(%.2f,%.2f)", x, y);
    }

    public static void foo(int n, Point2D pt) {
        n = 100;
        pt.setX(42);
    }

    public static void main(String[] args) {
        int n = 1;
        Point2D pt1 = new Point2D(1,1);
        foo(n, pt1);
        System.out.printf("%d %s\n", n, pt1);
    }
}
