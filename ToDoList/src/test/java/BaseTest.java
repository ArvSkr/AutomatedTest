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
        driver.get("https://todomvc.com/examples/react/dist/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(ofSeconds(10));
    }

    @AfterEach
    void teardown() {
driver.quit();
    }
}
