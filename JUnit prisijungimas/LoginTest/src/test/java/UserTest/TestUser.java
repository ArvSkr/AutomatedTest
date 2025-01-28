package UserTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.*;

public class TestUser {


    WebDriver driver;

    @BeforeEach
    void setUp() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(ofSeconds(5));
    }

    @Test
    void validuser() {


        driver.get("https://www.saucedemo.com/");
        WebElement inputusername = driver.findElement(By.id("user-name"));
        inputusername.sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        String expected = "https://www.saucedemo.com/inventory.html";
        assertEquals(expected, driver.getCurrentUrl());
        WebElement istherecart = driver.findElement(By.className("shopping_cart_link"));
        assertTrue(istherecart != null);


    }


    @Test
    void invalidpassword() {

        driver.get("https://www.saucedemo.com/");
        WebElement inputusername = driver.findElement(By.id("user-name"));
        inputusername.sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("wrong_password");
        driver.findElement(By.id("login-button")).click();
        WebElement errormessage = driver.findElement(By.cssSelector(".error-message-container.error"));
        String expected = "Epic sadface: Username and password do not match any user in this service";
        assertEquals(expected, errormessage.getText());

    }


    @Test
    public void lockoutuser() {

        driver.get("https://www.saucedemo.com/");
        WebElement inputusername = driver.findElement(By.id("user-name"));
        inputusername.sendKeys("locked_out_user");
        driver.findElement(By.id("password")).sendKeys("secret_password");
        driver.findElement(By.id("login-button")).click();
        WebElement errormessage = driver.findElement(By.cssSelector(".error-message-container.error"));
        String expected = "this user has been locked out";
        assertEquals(expected, errormessage.getText());
        driver.quit();
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/logins.csv", numLinesToSkip = 1)
    void testWithCsvFileSourceFromFile(String username, String Password) {
        assertNotNull(username);
        assertNotEquals(0, Password);
    }

    @Test
    void timeoutNotExceeded() {

        assertTimeout(ofSeconds(2), () -> {
            driver.get("https://www.saucedemo.com/");
            WebElement inputusername = driver.findElement(By.id("user-name"));
            inputusername.sendKeys("performance_glitch_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();

        });

    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
