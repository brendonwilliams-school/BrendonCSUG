
public class Sphere extends Shape {

    private double radius;

    // Constructor
    public Sphere(double radius) {
        this.radius = radius;
    }

    // Surface Area
    @Override
    public double surface_area() {
        return 4 * Math.PI * radius * radius;
    }

    // Volume
    @Override
    public double volume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    // toString
    @Override
    public String toString() {
        return "Sphere\n" +
               "Radius: " + radius +
               "\nSurface Area: " + surface_area() +
               "\nVolume: " + volume() + "\n";
    }
}