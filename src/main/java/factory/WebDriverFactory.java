package factory;

import exceptions.BrowserNotSupportedExceptions;
import factory.settings.ChromeDriverSettings;
import factory.settings.ISettings;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    private final String browser = System.getProperty("browser").toLowerCase().trim();

    public WebDriver create () {
        return switch (browser) {
            case "chrome" -> {
                ISettings settings = new ChromeDriverSettings();
                yield new ChromeDriver((ChromeOptions) settings.settings(null));
            }
            case "firefox" -> new FirefoxDriver();
            default -> throw new BrowserNotSupportedExceptions(browser);
        };
    }
}
