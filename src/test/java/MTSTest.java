import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MTSTest {
    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\Новая папка\\ASTON\\src\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("https://www.mts.by/");
        handleCookiesPopup();
    }

    @DisplayName("Проверить название блока 'Онлайн пополнение без комиссии'")
    @Test
    public void testBlockTitle() {
        WebElement blockTitle = driver.findElement(By.xpath("//div[@class='pay__wrapper']//h2"));
        String expectedTitle = "Онлайн пополнение\nбез комиссии";
        assertEquals(expectedTitle, blockTitle.getText(), "Название блока не совпадает с ожидаемым.");
    }

    @DisplayName("Проверить наличие логотипов платёжных систем")
    @Test
    public void testPaymentSystemLogos() {
        List<WebElement> logos = driver.findElements(By.xpath("//div[@class = 'pay__partners']//ul//li"));
        assertEquals(5, logos.size(), "Логотипы платёжных систем отсутствуют.");
    }

    @DisplayName("Проверить работу ссылки 'Подробнее о сервисе'")
    @Test
    public void testServiceDetailsLink() {
        WebElement serviceLink = driver.findElement(By.linkText("Подробнее о сервисе"));
        serviceLink.click();
        assertTrue(driver.getCurrentUrl().contains("/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"),
                "Ссылка «Подробнее о сервисе» не работает.");
    }

    @DisplayName("Заполнить поля и проверить работу кнопки 'Продолжить'")
    @Test
    public void testPaymentFormSubmission() {
        WebElement phoneInput = driver.findElement(By.id("connection-phone"));
        WebElement sumInput = driver.findElement(By.id("connection-sum"));
        WebElement emailInput = driver.findElement(By.id("connection-email"));
        WebElement submitButton = driver.findElement(By.cssSelector("#pay-connection .button__default"));

        phoneInput.sendKeys("297777777");
        sumInput.sendKeys("10");
        emailInput.sendKeys("test@example.com");
        submitButton.click();

        // Используем явное ожидание для поиска iframe
        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.bepaid-app iframe")));
        driver.switchTo().frame(iframe);

        WebElement popupElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[text()='10.00 BYN']")));



        assertTrue(popupElement.isDisplayed(), "Всплывающее окно не отобразилось");
    }

    private static void handleCookiesPopup() {
        try {
            WebElement acceptCookiesButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cookie-agree")));
            acceptCookiesButton.click();
        } catch (Exception e) {
            // Если не появилось - игнорируем
        }
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}