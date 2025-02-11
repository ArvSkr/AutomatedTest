import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SetUpTest {


    @BeforeAll
    static void setUp() {
        Base base = new Base();
        base.setDriver();
    }

    @AfterAll
    static void tearDown() {

        Base base = new Base();
        base.teardown();

    }
}
