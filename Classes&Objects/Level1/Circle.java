class Circle {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    double area() {
        return Math.PI * radius * radius;
    }

    double circumference() {
        return 2 * Math.PI * radius;
    }

    void display() {
        System.out.printf("Area: %.2f\nCircumference: %.2f\n", area(), circumference());
    }

    public static void main(String[] args) {
        Circle c = new Circle(5);
        c.display();
    }
}
