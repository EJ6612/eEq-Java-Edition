import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        boolean alive = true;
        int userSelection;
        Scanner scanner = new Scanner(System.in);

        while (alive) {

            println("Welcome to easEquations (Java Edition)");
            println("What math would you like to do today? \n0. Quit \n1. 2D Shapes \n2. Basic Functions \n3. 3D Objects");
            userSelection = scanner.nextInt();
            //println(userSelection);

            //it's switch in Java as well (as C#)!!!!
            switch (userSelection) {
                case 0:
                    alive = false;
                    break;
                case 1:
                    println("2D Shapes");
                    shapes2D();
                    break;
                case 2:
                    println("Basic Functions");
                    basicFunctions();
                    break;
                case 3:
                    println("3D Objects");
                    objects3D();
                    break;
                case 4:
                    //Scanner scanner = new Scanner(System.in);
                    //int testNum = scanner.nextInt();
                    //double testDouble = scanner.nextDouble();
                    //String testme = scanner.nextLine();
                    println("${testNum} may or not be {testDouble}");

                default:
                    break;
            }

        }

    }

    static void shapes2D() throws IOException {
        Mathematics maths = new Mathematics();
        // Because System.in.read() only reads a single Char, use Scanner. Scanner reads entire lines of input
        // Gemini AI response: https://g.co/gemini/share/d72ccfe8c2d0
        Scanner scanner = new Scanner(System.in);

        println("What shape do you have? \n 1. Circle (Area or Circumference \n 2. Triangle (Area) \n 3. Trapezoid (Area) \n 4. Rectangle (Area or Perimeter)");
        int userSelection = scanner.nextInt();

        switch (userSelection) {
            case 1: {
                println("Would like to solve for \n 1. Area \n 2. Circumference");
                userSelection = scanner.nextInt();

                switch (userSelection) {
                    case 1:
                        System.out.print("What is the radius? ");
                        double radius = scanner.nextDouble();
                        double area = maths.circleArea(radius);

                        println(DF(area) + " units²\n");
                        break;

                    case 2:
                        System.out.print("What is the diameter? ");
                        double diameter = scanner.nextDouble();
                        double circum = maths.circleCircumference(diameter);

                        println(DF(circum) + " units\n");
                        break;
                }
                break;
            }

            case 2: {
                System.out.print("What is the base length? ");
                double base = scanner.nextDouble();

                System.out.print("What is the height? ");
                double height = scanner.nextDouble();

                double area = maths.triangleArea(base, height);
                println(DF(area) + " units²\n");
                break;
            }

            case 3: {
                System.out.print("What is the base length? ");
                double base = scanner.nextDouble();

                System.out.print("What is the height? ");
                double height = scanner.nextDouble();

                System.out.print("What is the top length? ");
                double top = scanner.nextDouble();

                double area = maths.trapezoidArea(base, top, height);

                println(DF(area) + " units²\n");
                break;
            }
            case 4: {
                System.out.print("What is the width? ");
                double width = scanner.nextDouble();

                System.out.print("What is the height? ");
                double height = scanner.nextDouble();

                println("Would like to solve for \n 1. Area \n 2. Perimeter");
                userSelection = scanner.nextInt();

                switch(userSelection) {
                    case 1:
                        double area = maths.rectangleArea(width, height);
                        println(DF(area) + " units²\n");
                        break;

                    case 2:
                        double perim = maths.rectanglePerimeter(width, height);
                        println(DF(perim) + " units²\n");
                        break;
                }
                break;
            }
            default:
                return;
        }
    }

    static void basicFunctions() throws IOException {
        Mathematics maths = new Mathematics();
        Scanner scanner = new Scanner(System.in);

        println("Pick a math thing: \n 1. Slope Intercept \n 2. Quadratic Equation \n 3. Percentages ");
        int userSelection = scanner.nextInt();

        switch (userSelection) {
            case 1:
                break;
            case 2: {
                System.out.print("What is a? (cannot be 0) ");
                double quadA = scanner.nextDouble();

                System.out.print("What is b? (b² ≥ 4ac) ");
                double quadB = scanner.nextDouble();

                System.out.print("What is c? ");
                double quadC = scanner.nextDouble();

                println(("\n(-b ± √b²-4ac) / 2a"));
                String spellItOut = String.format("(-%.1f ± √%.1f²-4(%.1f)(%.1f)) / 2(%.1f)", quadB, quadB, quadA, quadC, quadA);
                println(spellItOut);
                println("(decimal points are set to 1 for reading convenience)\n");

                double x1 = maths.QUADRATIC(quadA, quadB, quadC, true);
                double x2 = maths.QUADRATIC(quadA, quadB, quadC, false);

                println("x= " +DF(x1) +", " +DF(x2));

                break;
            }
            case 3:
                break;
            default:
                return;
        }

    }

    static void objects3D() throws IOException {
        CubicMath maths = new CubicMath();
        Scanner scanner = new Scanner(System.in);

        println("What shape do you have? \n 1. Box \n 2. Sphere \n 3. Cone \n 4. Cylinder \n 5. Square Pyramid");
        int userSelection = scanner.nextInt();

        switch (userSelection) {
            case 1: {
                println("Would like to solve for \n 1. Area \n 2. Surface Area ");
                userSelection = scanner.nextInt();

                println("What is the width? ");
                double width = scanner.nextDouble();
                println("What is the height? ");
                double height = scanner.nextDouble();
                println("What is the length? ");
                double length = scanner.nextDouble();

                switch (userSelection) {
                    case 1:
                        double volume = maths.BoxVolume(width, height, length);
                        //String resultV = DF(volume) + " units³\n";
                        println(DF(volume) + " units³\n");
                        break;
                    case 2:
                        double surfaceArea = maths.BoxSurfaceArea(width, height, length);
                        //String resultA = DF(surfaceArea) + " units²\n";
                        println((DF(surfaceArea) + " units²\n"));
                        break;
                }
                break;
            }
            case 2: {
                println("Would like to solve for \n 1. Area \n 2. Surface Area ");
                userSelection = scanner.nextInt();

                break;
            }
            default:
                return;
        }

    }

    // Format the result to four decimal places
    public static String DF(double result) {
        DecimalFormat df = new DecimalFormat("#.####");
        return df.format(result);
    }

    // I'm tired of typing out 'System.out.println'
    public static void println (String line) {
        char firstChar = line.charAt(0);
        // I attempted to create my own println for combined variables, spent several hours on it
        // only for it to click later that it wouldn't recognize the variables placed inside. 😭
        if (firstChar == '$')  {
            StringBuilder resultBuilder = new StringBuilder();

            int stringSize = line.length();
            char[] chars = new char[stringSize];
            //if true, it's in a {}
            boolean isOpen = false;

            int placement = 0;

            for (int i = 1; i < stringSize; i++) {
                //chars[i] = line.charAt(i);
                char curr = line.charAt(i);
                System.out.println(curr);

                if (!isOpen) {

                    if (curr == '{') {

                        for (int j = 0; j <= placement; j++) {
                            for (char c : chars) {
                                resultBuilder.append(c);
                            }
                            chars[j] = '\0';
                        }

                        placement = 0;
                        //chars[placement] = curr;

                        isOpen = true;
                    }

                    else {
                        chars[placement] = curr;
                        placement++;
                    }
                }

                else {
                    if (curr == '}') {

                        for (int j = 0; j <= placement; j++) {
                            for (char c : chars) {
                                resultBuilder.append(c);
                            }
                            chars[j] = '\0';
                        }

                        placement = 0;
                        //chars[placement] = curr;

                        isOpen = false;
                    }

                    else {
                        chars[placement] = curr;
                        placement++;
                    }
                }

            }

            //for a bit, I played around with ArrayList. I found more efficient ways of working it.

            String result = resultBuilder.toString();

            System.out.println(result);
        }

        else {
            System.out.println(line);
        }
    }
}