package onlykrastines;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static java.time.Duration.ofSeconds;

public class onlykrastinesclicktest {

    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(ofSeconds(60));
        driver.get("file:///C:/Users/D2PT/Downloads/QApraktinisKrastines.html");
    }

    @Test
    void clickBorderElements() {
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


            int gridSize = (int) Math.sqrt(buttons.size());


            for (int i = 0; i < gridSize; i++) {
                WebElement topButton = buttons.get(i);
                wait.until(ExpectedConditions.elementToBeClickable(topButton));
                topButton.click();
            }


            for (int i = 1; i < gridSize - 1; i++) {
                WebElement rightButton = buttons.get(i * gridSize + gridSize - 1);
                wait.until(ExpectedConditions.elementToBeClickable(rightButton));
                rightButton.click();
            }


            for (int i = 0; i < gridSize; i++) {
                WebElement bottomButton = buttons.get((gridSize - 1) * gridSize + i);
                wait.until(ExpectedConditions.elementToBeClickable(bottomButton));
                bottomButton.click();
            }


            for (int i = 1; i < gridSize - 1; i++) {
                WebElement leftButton = buttons.get(i * gridSize);
                wait.until(ExpectedConditions.elementToBeClickable(leftButton));
                leftButton.click();
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
