import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseTest {
    protected WebDriver driver;

    @BeforeAll
    static void setupDriverManager() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/");
    }

    @AfterEach
    void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
