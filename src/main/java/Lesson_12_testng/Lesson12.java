package Lesson_12_testng;

public class Lesson12 {
    public static void main(String[] args) {
        Factorial factorial = new Factorial();

        long number = 5;
        long factorialNumber = factorial.calculateFactorial(number);

        System.out.println("Факториал " + number + " = " + factorialNumber);
    }
}