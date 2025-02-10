import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Base {
    protected static WebDriver driver;
    protected static WebDriverWait wait;

    public static void initializeDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
            wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        }
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}