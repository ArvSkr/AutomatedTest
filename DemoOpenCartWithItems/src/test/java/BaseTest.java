
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public abstract class BaseTest {
    protected WebDriver driver;



    @BeforeEach
    void setupBrowser() {
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("http://192.168.91.192/en-gb?route=common/home");
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }
}
