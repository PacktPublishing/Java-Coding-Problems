package modern.challenge.deep.copy.cloning;

public class Point {

    private double x;
    private double y;
    private Radius radius;

    public Point(double x, double y, Radius radius) {
        this.x = x;
        this.y = y;               
        this.radius = radius;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Radius getRadius() {
        return radius;
    }

    public void setRadius(Radius radius) {
        this.radius = radius;
    }   
}
