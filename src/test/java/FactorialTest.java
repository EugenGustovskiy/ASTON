import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Lesson_12_junit_5.Factorial;

public class FactorialTest {
    Factorial factorial = new Factorial();

    @DisplayName("Позитивный тест: вычисление факториала положительного числа")
    @Test
    public void positiveNumberCalculateFactorialTest() {
        assertEquals(1, factorial.calculateFactorial(1));
        assertEquals(2, factorial.calculateFactorial(2));
        assertEquals(6, factorial.calculateFactorial(3));
    }

    @DisplayName("Негативный тест: выбрасывание исключения при отрицательном числе")
    @Test
    void negativeNumberCalculateFactorialTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            factorial.calculateFactorial(-1);
        });
    }

    @DisplayName("Позитивный тест: вычисление факториала для нуля")
    @Test
    void zeroCalculateFactorialTest() {
        long result = factorial.calculateFactorial(0);
        assertEquals(1, result); // 0! = 1
    }
}