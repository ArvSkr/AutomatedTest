package ActionClick;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.time.Duration.ofSeconds;

public class Buttons {
    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(ofSeconds(5));
    }

    @Test
    void Actionclick() {
        driver.get("https://webdriveruniversity.com/Click-Buttons/index.html");
        WebElement click = driver.findElement(By.id("button3"));
        Actions actions = new Actions(driver);
        actions.moveToElement(click).click().perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("myModalMoveClick")));

        WebElement modalElement = driver.findElement(By.xpath("/html//div[@id='myModalMoveClick']//div[@class='modal-body']"));


        String modaltext = modalElement.getText().trim();  // Trim extra spaces

        System.out.println("Modal Text: " + modaltext);

        boolean expectedText = modaltext.contains("Advanced user interactions (API) has been developed to enable you to perform more complex interactions such as:");
        System.out.println(expectedText);
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

}
