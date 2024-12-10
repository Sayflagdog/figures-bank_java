import java.util.Scanner;

class Rectangle {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        if (length <= 0 || width <= 0) {
            throw new RuntimeException("There is no figure with such parameters.");
        }
        this.length = length;
        this.width = width;
    }

    public double area() {
        return length * width;
    }

    public double perimeter() {
        return 2 * (length + width);
    }
}

class Circle {
    private double radius;

    public Circle(double radius) {
        if (radius <= 0) {
            throw new RuntimeException("There is no figure with such parameters.");
        }
        this.radius = radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public double perimeter() {
        return 2 * Math.PI * radius;
    }
}

class Triangle {
    private double a, b, c;

    public Triangle(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0 || a + b <= c || a + c <= b || b + c <= a) {
            throw new RuntimeException("There is no figure with such parameters.");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }
// Выполнил Зыков Макар
    public double area() {
        double s = perimeter() / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    public double perimeter() {
        return a + b + c;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введите длину прямоугольника: ");
            double length = scanner.nextDouble();
            System.out.print("Введите ширину прямоугольника: ");
            double width = scanner.nextDouble();
            Rectangle rectangle = new Rectangle(length, width);
            System.out.println("Площадь прямоугольника: " + rectangle.area());
            System.out.println("Периметр прямоугольника: " + rectangle.perimeter());

            System.out.print("Введите радиус круга: ");
            double radius = scanner.nextDouble();
            Circle circle = new Circle(radius);
            System.out.println("Площадь круга: " + circle.area());
            System.out.println("Периметр круга: " + circle.perimeter());

            System.out.print("Введите сторону a треугольника: ");
            double a = scanner.nextDouble();
            System.out.print("Введите сторону b треугольника: ");
            double b = scanner.nextDouble();
            System.out.print("Введите сторону c треугольника: ");
            double c = scanner.nextDouble();
            Triangle triangle = new Triangle(a, b, c);
            System.out.println("Площадь треугольника: " + triangle.area());
            System.out.println("Периметр треугольника: " + triangle.perimeter());

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

