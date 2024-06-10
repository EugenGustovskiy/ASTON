import Lesson_12_testng.Factorial;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FastorialTest {
    private Factorial factorial;

    @BeforeMethod(description = "Настройка перед каждым тестом")
    public void setUp() {
        factorial = new Factorial();
    }

    @Test(description = "Тест вычисления факториала с положительным числом")
    public void positiveNumberCalculateFactorialTest() {
        long result = factorial.calculateFactorial(3);
        Assert.assertEquals(result, 6);
    }

    @Test(description = "Тест вычисления факториала с нулем")
    public void zeroCalculateFactorialTest() {
        long result = factorial.calculateFactorial(0);
        Assert.assertEquals(result, 1);
    }

    @Test(description = "Тест вычисления факториала с отрицательным числом",
            expectedExceptions = IllegalArgumentException.class)
    public void negativeNumberCalculateFactorialTest() {
        factorial.calculateFactorial(-5);
    }

    //Возможно это будет необходимо
    @AfterMethod(description = "Освобождение ресурсов после каждого теста ")
    public void tearDown() {
        factorial = null;
    }
}