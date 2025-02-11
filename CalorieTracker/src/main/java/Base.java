import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Base {
    static WebDriver driver;
    static WebDriverWait wait;

    public void setDriver() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice.expandtesting.com/tracalorie/?classId=c4774ba1-f652-4846-96cc-91fc3efcb391&assignmentId=fd8e951b-22c6-4570-83e1-9bb1b9293655&submissionId=9923d25e-501c-de7b-be86-4ffa48face84");
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void teardown() {
        driver.quit();
    }
}
