package Lecture_7.Figures;

public interface CalculationPerimeterAndArea {
    //Находим периметр
    default double calculatePerimeter() {
        return 0.0;
    }

    //Находим площадь
    default double calculateArea() {
        return 0.0;
    }
}