import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.time.Duration.ofSeconds;

public class BaseTest {
    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demo.prestashop.com/#/en/front");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(ofSeconds(40));
    }
    @AfterEach
    void teardown(){
        driver.quit();
    }
}
