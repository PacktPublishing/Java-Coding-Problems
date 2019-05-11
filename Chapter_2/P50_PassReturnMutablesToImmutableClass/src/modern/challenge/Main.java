package modern.challenge;

public class Main {

    public static void main(String[] args) {

        Radius r = new Radius();
        r.setStart(0);
        r.setEnd(120);

        Point p = new Point(1.23, 4.12, r);

        System.out.println("Radius start: " + p.getRadius().getStart());
        r.setStart(5);
        p.getRadius().setStart(5);
        System.out.println("Radius start: " + p.getRadius().getStart());
    }

}
