package Lecture_7.Figures;

public class Triangle implements CalculationPerimeterAndArea {
    private double side1;
    private double side2;
    private double side3;
    private String fillColor;
    private String borderColor;

    public Triangle(double side1, double side2, double side3, String fillColor, String borderColor) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double calculatePerimeter() {
        return side1 + side2 + side3;
    }

    //Посчитаем площадь треугольника по формуле Герона
    @Override
    public double calculateArea() {
        double s = calculatePerimeter() / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    public void printTriangleInfo() {
        System.out.printf("Triangle\nPerimeter: %.2f\nArea: %.2f\nFill color: %s\nBorder color: %s\n* * *\n",
                calculatePerimeter(), calculateArea(), fillColor, borderColor);
    }
}