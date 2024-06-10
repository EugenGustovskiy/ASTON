package Lesson_12_junit_5;

public class Factorial {
    //Вычисление факториала числа
    public long calculateFactorial(long n) {
        if (n < 0) {
            throw new IllegalArgumentException("Number must be non-negative.");
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
