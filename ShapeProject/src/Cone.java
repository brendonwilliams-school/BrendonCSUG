public class Cone extends Shape {

    private double radius;
    private double height;

    // Constructor
    public Cone(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    // Surface Area
    @Override
    public double surface_area() {

        double slantHeight =
                Math.sqrt((radius * radius) + (height * height));

        return Math.PI * radius *
               (radius + slantHeight);
    }

    // Volume
    @Override
    public double volume() {
        return (1.0 / 3.0) *
               Math.PI *
               radius * radius * height;
    }

    // toString
    @Override
    public String toString() {
        return "Cone\n" +
               "Radius: " + radius +
               "\nHeight: " + height +
               "\nSurface Area: " + surface_area() +
               "\nVolume: " + volume() + "\n";
    }
}