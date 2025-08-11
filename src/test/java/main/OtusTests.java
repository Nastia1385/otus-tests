package main;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OtusTests extends AbsBaseTestSuite {

    private final static String BASE_URL = "https://training.otus.kartushin.su/training.html";

    @Test
    public void textMatching() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver.get(BASE_URL);

        WebElement input = driver.findElement(By.id("textInput"));
        String expected = "ОТУС";
        input.sendKeys("ОТУС");
        String value = input.getAttribute("value");
        assertEquals(expected, value);
    }

    @Test
    public void openingTheWindow() {
        driver.manage().window().maximize();
        driver.get(BASE_URL);

        WebElement button = driver.findElement(By.id("openModalBtn"));
        button.click();
        WebElement result = driver.findElement(By.className("modal-content"));
        assertTrue(result.isDisplayed());
    }

    @Test
    public void Test3() {
        driver.manage().window().fullscreen();
        driver.get(BASE_URL);
        WebElement input = driver.findElement(By.id("name"));
        input.sendKeys("Анастасия");
        WebElement inputType = driver.findElement(By.id("email"));
        inputType.sendKeys("12031985@TTT.gmail.com");
        WebElement button = driver.findElement(By.cssSelector("button[type='submit']"));
        button.click();
        WebElement div = driver.findElement(By.id("messageBox"));
        String rgbaColor = div.getCssValue("background-color");
        String resultMessage = div.getText();
        String expectedMessage = "Форма отправлена с именем: Анастасия и email: 12031985@TTT.gmail.com";
        assertEquals("rgba(234, 248, 230, 1)", rgbaColor);
        assertEquals(expectedMessage, resultMessage);
    }
}


