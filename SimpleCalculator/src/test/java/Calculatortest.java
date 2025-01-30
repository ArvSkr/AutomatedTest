import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static java.time.Duration.ofSeconds;

public class Calculatortest {

    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(ofSeconds(60));
        driver.get("https://testpages.herokuapp.com/styled/calculator");
    }

    @Test
    void calculateminus() {
        driver.findElement(By.id("number1")).sendKeys("3");
        Select option = new Select(driver.findElement(By.id("function")));
        option.selectByValue("minus");
        driver.findElement(By.id("number2")).sendKeys("2");
        driver.findElement(By.id("calculate")).click();

        String answer = driver.findElement(By.id("answer")).getText();

        boolean isanswertrue = answer.equals("1");
        System.out.println(isanswertrue);
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }
}
