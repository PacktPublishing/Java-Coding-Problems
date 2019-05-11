package modern.challenge;

public final class Point {

    private final double x;
    private final double y;
    private final Radius radius;

    public Point(double x, double y, Radius radius) {
        this.x = x;
        this.y = y;
        
        Radius clone = new Radius();
        clone.setStart(radius.getStart());
        clone.setEnd(radius.getEnd());
        
        this.radius = clone;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Radius getRadius() {
        
        Radius clone  = new Radius();
        clone.setStart(this.radius.getStart());
        clone.setEnd(this.radius.getEnd());
        
        return clone;
    }        
}
