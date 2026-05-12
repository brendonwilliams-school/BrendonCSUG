public class Cylinder extends Shape {

    private double radius;
    private double height;

    // Constructor
    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    // Surface Area
    @Override
    public double surface_area() {
        return 2 * Math.PI * radius * radius +
               2 * Math.PI * radius * height;
    }

    // Volume
    @Override
    public double volume() {
        return Math.PI * radius * radius * height;
    }

    // toString
    @Override
    public String toString() {
        return "Cylinder\n" +
               "Radius: " + radius +
               "\nHeight: " + height +
               "\nSurface Area: " + surface_area() +
               "\nVolume: " + volume() + "\n";
    }
}