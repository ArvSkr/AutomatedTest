import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import javax.swing.*;

import java.time.Duration;

import static java.time.Duration.ofSeconds;

public class prestashoptest {
    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(ofSeconds(5));

    }

    @Test
    void Signup() {
        driver.get("https://demo.prestashop.com/#/en/front");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));


        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("framelive")));


        WebElement signinwait = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='_desktop_user_info']//a")));
        signinwait.click();
        WebElement createAccountLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@className, 'no-account')]")));
        createAccountLink.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer-form")));

        signinwait.click();
        driver.quit();
    }
}
