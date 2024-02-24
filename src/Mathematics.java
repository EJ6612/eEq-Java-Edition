import java.math.MathContext;
public class Mathematics {
    //Circle
    public double circleArea(double radius) {
        return Math.PI * (radius * radius);
    }
    public double circleCircumference(double diameter) {
        return Math.PI * diameter;
    }

    //Triangle
    public double triangleArea (double triBase, double triHeight) {
        return (0.5 * triBase) * triHeight;
    }

    //Trapezoid
    public double trapezoidArea (double trapBase, double trapTop, double trapHeight) {
        return (0.5 * (trapBase * trapTop) * trapHeight);
    }

    //Rectangle
    public double rectangleArea (double width, double height) {
        return width * height;
    }
    public double rectanglePerimeter (double width, double height) {
        return (width * 2) + (height * 2);
    }

    public double QUADRATIC (double a, double b, double c, boolean POS) {
        double ac4 = 4 * a * c;
        double sqRoot = (b * b) - ac4;
        double a2 = 2 * a;

        if (POS) {
            double topP = (-b + Math.sqrt(sqRoot));
            double x1 = topP / a2;

            return x1;
        }
        else {
            double topP = (-b - Math.sqrt(sqRoot));
            double x2 = topP / a2;

            return x2;
        }
    }

}
