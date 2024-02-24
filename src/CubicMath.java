//in Java, extends is the equivalent to ':' in C# & Kotlin
public class CubicMath extends Mathematics {

    public double BoxVolume (double width, double height, double length) {
        return width * height * length;
    }
    public double BoxSurfaceArea (double width, double height, double length) {
        double wh = rectangleArea(width, height);
        double wl = rectangleArea(width, length);
        double hl = rectangleArea(height, length);

        return 2 * (wh + wl + hl);
    }

    public double SphereVolume (double radius) {
        return (double)4/3 * Math.PI * (radius * radius * radius);
    }

    public double SphereSurfaceArea (float radius) {
        return 4 * Math.PI * (radius * radius);
    }

    public double ConeVolume (double radius, double height) {
        return ((double) 1/3 * Math.PI * (radius * radius)) * height;
    }

    public double ConeSurfaceArea(double radius, double height)
    {
        //A = pi r (r+ sqr(h*h + r*r))

        double hSq = height * height;
        double rSq = radius * radius;

        double theSQR = Math.sqrt(hSq + rSq);
        double piR = Math.PI * radius;

        return piR * ((radius) + theSQR);
    }

}
