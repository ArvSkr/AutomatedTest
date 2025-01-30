package PirmaUzduotis;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static java.time.Duration.ofSeconds;

public class PraktinisDarbas {
    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(ofSeconds(60));
        driver.get("file:///C:/Users/D2PT/Downloads/QApraktinisALL.html");
    }

    @Test
    void clickthemall() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        int maxLevel = 7;
        int currentLevel = 1;


        while (currentLevel <= maxLevel) {

            try {
                Alert alert = driver.switchTo().alert();
                alert.accept();
            } catch (Exception e) {

            }

            List<WebElement> buttons = driver.findElements(By.className("icon"));

            if (currentLevel > maxLevel) {
                break;
            }

            for (WebElement button : buttons) {
                wait.until(ExpectedConditions.elementToBeClickable(button));
                button.click();

            }

            currentLevel++;
        }
    }

//
//    @AfterEach
//    void teardown() {
//        driver.quit();
//    }

}
