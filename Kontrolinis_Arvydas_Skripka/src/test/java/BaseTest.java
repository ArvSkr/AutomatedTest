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
        driver.get("http://192.168.91.67/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(ofSeconds(20));

    }

    @AfterEach
    void teardown() {
        
    }
}
