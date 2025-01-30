import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;

import java.time.Duration;
import java.util.Set;

import static java.time.Duration.ofSeconds;

public class AlertandPopuptest {
    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(ofSeconds(5));
    }

    @Test
    void javascriptalert() {
        driver.get("https://webdriveruniversity.com/Popup-Alerts/index.html");
        driver.findElement(By.xpath("/html/body/div[@class='container']/div[2]//span[@class='btn btn-default btn-lg dropdown-toggle']")).click();

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();

        alert.accept();

        System.out.println("Alert appeared with message: " + alertText);
    }

    @Test
    void jsConfirmBox() {
        driver.get("https://webdriveruniversity.com/Popup-Alerts/index.html");

        driver.findElement(By.xpath("/html/body/div[@class='container']/div[5]//span[@class='btn btn-default btn-lg dropdown-toggle']")).click();

        Alert alert = driver.switchTo().alert();

        String alertText = alert.getText();

        alert.accept();

        System.out.println("Alert appeared with message: " + alertText);
        boolean istextdisplayed = driver.findElement(By.id("confirm-alert-text")).isDisplayed();
        System.out.println(istextdisplayed);
    }

    @Test
    void ModalPopup() {
        driver.get("https://webdriveruniversity.com/Popup-Alerts/index.html");

        driver.findElement(By.id("button2")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("myModal")));

        WebElement modalTitleElement = driver.findElement(By.xpath("//div[@class='modal-header']//h4"));

        String modalTitle = modalTitleElement.getText();

        System.out.println("Modal title: " + modalTitle);

        boolean doesItContain = modalTitle.contains("It’s that Easy!! Well I think it is.....");

        System.out.println(doesItContain);
    }

    @Test
    void AjaxLoader() {
        driver.get("https://webdriveruniversity.com/Popup-Alerts/index.html");
        driver.findElement(By.id("button3")).click();

        driver.findElement(By.id("button1")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-header")));
        WebElement modalTitleElement = driver.findElement(By.xpath("/html//div[@id='myModalClick']//div[@class='modal-header']"));

        String modalTitle = modalTitleElement.getText();

        System.out.println("Modal title: " + modalTitle);

        boolean doesItContain = modalTitle.contains("Well Done For Waiting....!!!");

        System.out.println(doesItContain);

    }

    @AfterEach
    void teardown() {
        driver.quit();
    }
}
