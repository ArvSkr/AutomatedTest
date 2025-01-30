package webclick;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Buttons {
    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(ofSeconds(5));
    }

    @Test
    void Webclick() {
        driver.get("https://webdriveruniversity.com/Click-Buttons/index.html");
        WebElement click = driver.findElement(By.id("button1"));
        click.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("myModalClick")));

        WebElement modalElement = driver.findElement(By.xpath("/html//div[@id='myModalClick']//p"));

        String modaltext = modalElement.getText();
        System.out.println("Modal Text: " + modaltext);
        boolean equals = modaltext.equals("Well done for successfully using the click() method!");
        System.out.println(equals);
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

}
