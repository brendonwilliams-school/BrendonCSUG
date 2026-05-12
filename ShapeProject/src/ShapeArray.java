public class ShapeArray {

    public static void main(String[] args) {

        // Create objects
        Sphere sphere = new Sphere(5);

        Cylinder cylinder = new Cylinder(4, 10);

        Cone cone = new Cone(3, 7);

        // Store in array
        Shape[] shapeArray = {
                sphere,
                cylinder,
                cone
        };

        // Loop through array
        for (Shape shape : shapeArray) {
            System.out.println(shape.toString());
        }
    }
}