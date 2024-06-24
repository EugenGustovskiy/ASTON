import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.*;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NewMTSTest {
    WebDriver driver;
    WebDriverWait wait;

    private final String phoneNumber = "297777777";
    private final String paymentSum = "10";

    @BeforeAll
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUp() {
        driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("https://www.mts.by/");
        handleCookiesPopup();
    }

    //Задание 1
    @Test
    @DisplayName("Проверить надписи в незаполненных полях 'Услуги связи'")
    @Story("Проверка placeholder")
    @Severity(SeverityLevel.MINOR)
    @Step("Проверить placeholders в назполненных полях для 'Услуги связи'")
    public void testEmptyFieldsCommunicationService() {
        WebElement phoneInputField = driver.findElement(By.xpath("//input[@id = 'connection-phone']"));
        WebElement sumInputField = driver.findElement(By.xpath("//input[@id = 'connection-sum']"));
        WebElement emailInputField = driver.findElement(By.xpath("//input[@id = 'connection-email']"));

        assertEquals("Номер телефона", phoneInputField.getAttribute("placeholder"),
                "Placeholder не совпадает с ожидаемым.");
        assertEquals("Сумма", sumInputField.getAttribute("placeholder"),
                "Placeholder не совпадает с ожидаемым.");
        assertEquals("E-mail для отправки чека", emailInputField.getAttribute("placeholder"),
                "Placeholder не совпадает с ожидаемым.");
    }

    @Test
    @DisplayName("Проверить надписи в незаполненных полях 'Домашний интернет'")
    @Story("Проверка placeholder")
    @Severity(SeverityLevel.MINOR)
    @Step("Проверить placeholders в назполненных полях для 'Домашний интернет'")
    public void testEmptyFieldsHomeInternet() {
        WebElement dropDownServices = driver.findElement(By.xpath("//button[@class = 'select__header']"));
        dropDownServices.click();
        WebElement homeInternet = driver.findElement(By.xpath
                ("//p[@class='select__option'][text()='Домашний интернет']"));
        homeInternet.click();

        WebElement phoneInputField = driver.findElement(By.xpath("//input[@id = 'internet-phone']"));
        WebElement sumInputField = driver.findElement(By.xpath("//input[@id = 'internet-sum']"));
        WebElement emailInputField = driver.findElement(By.xpath("//input[@id = 'internet-email']"));

        assertEquals("Номер абонента", phoneInputField.getAttribute("placeholder"),
                "Placeholder номера абонента не совпадает с ожидаемым.");
        assertEquals("Сумма", sumInputField.getAttribute("placeholder"),
                "Placeholder суммы не совпадает с ожидаемым.");
        assertEquals("E-mail для отправки чека", emailInputField.getAttribute("placeholder"),
                "Placeholder email не совпадает с ожидаемым.");
    }

    @Test
    @DisplayName("Проверить надписи в незаполненных полях 'Рассрочка'")
    @Story("Проверка placeholder")
    @Severity(SeverityLevel.MINOR)
    @Step("Проверить placeholders в назполненных полях для 'Рассрочка'")
    public void testEmptyFieldsInstallment() {
        WebElement dropDownServices = driver.findElement(By.xpath("//button[@class = 'select__header']"));
        dropDownServices.click();
        WebElement installment = driver.findElement(By.xpath("//p[@class='select__option'][text()='Рассрочка']"));
        installment.click();

        WebElement accountNumberInputField = driver.findElement(By.xpath("//input[@id = 'score-instalment']"));
        WebElement sumInputField = driver.findElement(By.xpath("//input[@id = 'instalment-sum']"));
        WebElement emailInputField = driver.findElement(By.xpath("//input[@id = 'instalment-email']"));

        assertEquals("Номер счета на 44", accountNumberInputField.getAttribute("placeholder"),
                "Placeholder номера счета не совпадает с ожидаемым.");
        assertEquals("Сумма", sumInputField.getAttribute("placeholder"),
                "Placeholder суммы не совпадает с ожидаемым.");
        assertEquals("E-mail для отправки чека", emailInputField.getAttribute("placeholder"),
                "Placeholder email не совпадает с ожидаемым.");
    }

    @Test
    @DisplayName("Проверить надписи в незаполненных полях 'Задолженность'")
    @Story("Проверка placeholder")
    @Severity(SeverityLevel.MINOR)
    @Step("Проверить placeholders в назаполненных полях для 'Задолженность'")
    public void testEmptyFieldsArrears() {
        WebElement dropDownServices = driver.findElement(By.xpath("//button[@class = 'select__header']"));
        dropDownServices.click();
        WebElement arrears = driver.findElement(By.xpath("//p[@class='select__option'][text()='Задолженность']"));
        arrears.click();

        WebElement accountNumberInputField = driver.findElement(By.xpath("//input[@id = 'score-arrears']"));
        WebElement sumInputField = driver.findElement(By.xpath("//input[@id = 'arrears-sum']"));
        WebElement emailInputField = driver.findElement(By.xpath("//input[@id = 'arrears-email']"));

        assertEquals("Номер счета на 2073", accountNumberInputField.getAttribute("placeholder"),
                "Placeholder не совпадает с ожидаемым.");
        assertEquals("Сумма", sumInputField.getAttribute("placeholder"),
                "Placeholder не совпадает с ожидаемым.");
        assertEquals("E-mail для отправки чека", emailInputField.getAttribute("placeholder"),
                "Placeholder не совпадает с ожидаемым.");
    }

    //Задание 2
    @Test
    @DisplayName("Проверить наличие номера телефона в окне оплаты")
    @Story("Проверить окно оплаты")
    @Severity(SeverityLevel.CRITICAL)
    @Step("Проверить номер телефона в окне оплаты")
    public void testPhoneNumberInPaymentWindow() {
        WebElement phoneInputField = driver.findElement(By.xpath("//input[@id = 'connection-phone']"));
        WebElement sumInputField = driver.findElement(By.xpath("//input[@id = 'connection-sum']"));
        WebElement continueButton = driver.findElement(By.cssSelector("#pay-connection .button__default"));

        phoneInputField.sendKeys(phoneNumber);
        sumInputField.sendKeys(paymentSum);
        continueButton.click();

        WebElement iframe = driver.findElement(By.cssSelector("div.bepaid-app iframe"));
        driver.switchTo().frame(iframe);

        WebElement infoField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//span[@class = 'pay-description__text']")));

        String textInfoField = infoField.getText();
        String expectedNumber = "375297777777";

        assertTrue(textInfoField.contains(expectedNumber), "Текст не содержит номер телефона " + expectedNumber);
    }

    @Test
    @DisplayName("Проверить наличие суммы в окне оплаты")
    @Story("Проверить окно оплаты")
    @Severity(SeverityLevel.CRITICAL)
    @Step("Проверить наличие суммы в окне оплаты")
    public void testSumInPaymentWindow() {
        WebElement phoneInputField = driver.findElement(By.xpath("//input[@id = 'connection-phone']"));
        WebElement sumInputField = driver.findElement(By.xpath("//input[@id = 'connection-sum']"));
        WebElement continueButton = driver.findElement(By.cssSelector("#pay-connection .button__default"));

        phoneInputField.sendKeys(phoneNumber);
        sumInputField.sendKeys(paymentSum);
        continueButton.click();

        WebElement iframe = driver.findElement(By.cssSelector("div.bepaid-app iframe"));
        driver.switchTo().frame(iframe);

        WebElement sumField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//div[@class = 'pay-description__cost']")));
        String textSumField = sumField.getText();
        WebElement payButton = driver.findElement(By.xpath("//button[@class = 'colored disabled']"));
        String textPayButton = payButton.getText();
        String expectedSum = "10.00";

        assertTrue(textSumField.contains(expectedSum), "Текст не содержит сумму " + expectedSum);
        assertTrue(textPayButton.contains(expectedSum), "Текст не содержит сумму " + expectedSum);
    }

    @Test
    @DisplayName("Проверить незаполненные поля в окне оплаты")
    @Story("Проверить окно оплаты")
    @Severity(SeverityLevel.CRITICAL)
    @Step("Проверить незаполненные поля в окне оплаты")
    public void testBlankFieldsInPaymentWindow() {
        WebElement phoneInputField = driver.findElement(By.xpath("//input[@id = 'connection-phone']"));
        WebElement sumInputField = driver.findElement(By.xpath("//input[@id = 'connection-sum']"));
        WebElement continueButton = driver.findElement(By.cssSelector("#pay-connection .button__default"));

        phoneInputField.sendKeys(phoneNumber);
        sumInputField.sendKeys(paymentSum);
        continueButton.click();

        WebElement iframe = driver.findElement(By.cssSelector("div.bepaid-app iframe"));
        driver.switchTo().frame(iframe);

        WebElement inputCardNumber = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//label[text() = 'Номер карты']")));
        WebElement inputExpirationDate = driver.findElement(By.xpath("//label[text() = 'Срок действия']"));
        WebElement inputCVC = driver.findElement(By.xpath("//label[text() = 'CVC']"));
        WebElement inputHolderName = driver.findElement(By.xpath("//label[contains(text(), 'Имя держателя')]"));

        assertEquals("Номер карты", inputCardNumber.getText(), "Текст 'Номер карты' не совпадает");
        assertEquals("Срок действия", inputExpirationDate.getText(), "Текст 'Срок действия' не совпадает");
        assertEquals("CVC", inputCVC.getText(), "Текст 'CVC' не совпадает");
        assertEquals("Имя держателя (как на карте)", inputHolderName.getText(), "Текст 'Имя держателя' не совпадает");
    }

    @Test
    @DisplayName("Проверить иконки платёжных систем в окне оплаты")
    @Story("Проверить окно оплаты")
    @Severity(SeverityLevel.MINOR)
    @Step("Проверить иконки платёжных систем в окне оплаты")
    public void testPaymentSystemIconsInPaymentWindow() {
        WebElement phoneInputField = driver.findElement(By.xpath("//input[@id = 'connection-phone']"));
        WebElement sumInputField = driver.findElement(By.xpath("//input[@id = 'connection-sum']"));
        WebElement continueButton = driver.findElement(By.cssSelector("#pay-connection .button__default"));

        phoneInputField.sendKeys(phoneNumber);
        sumInputField.sendKeys(paymentSum);
        continueButton.click();

        WebElement iframe = driver.findElement(By.cssSelector("div.bepaid-app iframe"));
        driver.switchTo().frame(iframe);

        WebElement container = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[contains(@class, 'cards-brands__container')]")));
        List<WebElement> images = container.findElements(By.tagName("img"));
        assertEquals(5, images.size(), "Количество изображений не равно 5");
    }

    @Step("Обработка cookie")
    private void handleCookiesPopup() {
        try {
            WebElement acceptCookiesButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cookie-agree")));
            acceptCookiesButton.click();
        } catch (Exception e) {
            System.out.println("Cookies popup was not found or could not be handled.");
        }
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}