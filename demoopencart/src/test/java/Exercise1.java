import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static java.time.Duration.ofSeconds;

public class Exercise1 {
    WebDriver driver;

    @BeforeEach
    void setUp() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(ofSeconds(5));
    }

    @Test
    void clickonwishlist() {
        driver.get("http://192.168.91.192/");
        driver.findElement(By.id("wishlist-total")).click();

    }

    @Test
    void countbuttons() {
        driver.get("http://192.168.91.192/");
        List<WebElement> buttons = driver.findElements(By.tagName("button"));

        int buttonCount = buttons.size();

        System.out.println("Total number of buttons on the page: " + buttonCount);


    }

    @Test
    void enteremail() {
        driver.get("http://192.168.91.192/en-gb?route=account/register");
        WebElement email = driver.findElement(By.id("input-email"));
        email.sendKeys("email@email.com");

    }

    @Test
    void clearemail() {
        driver.get("http://192.168.91.192/en-gb?route=account/register");
        WebElement email = driver.findElement(By.id("input-email"));
        email.sendKeys("email@email.com");
        email.clear();
    }

    @Test
    void submitform() {
        driver.get("http://192.168.91.192/en-gb?route=account/register");
        driver.findElement(By.id("input-firstname")).sendKeys("Tester");
        driver.findElement(By.id("input-lastname")).sendKeys("Tester");
        driver.findElement(By.id("input-email")).sendKeys("email@email.com");
        driver.findElement(By.id("input-password")).sendKeys("Tester123");
        driver.findElement(By.className("form-check-input")).click();
        driver.findElement(By.tagName("button")).click();

    }

    @Test
    void checkpassword() {
        driver.get("http://192.168.91.192/en-gb?route=account/register");
        boolean ispasswordenabled = driver.findElement(By.id("input-password")).isEnabled();
        System.out.println(ispasswordenabled);
    }

    @Test
    void checkcart() {
        driver.get("http://192.168.91.192/");
        boolean iscartdisplayed = driver.findElement(By.id("header-cart")).isDisplayed();
        System.out.println(iscartdisplayed);
    }

    @Test
    void checkchecklist() {
        driver.get("http://192.168.91.192/en-gb?route=account/register");
        boolean isselected = driver.findElement(By.className("form-check-input")).isSelected();
        System.out.println(isselected);
    }

    @Test
    void clickonDesktop() {
        driver.get("http://192.168.91.192/");
        driver.findElement(By.linkText("Desktops")).click();
    }

    @Test
    void showitemsperpage() {
        driver.get("http://192.168.91.192/en-gb/catalog/desktops");
        try {
            Select limit = new Select(driver.findElement(By.id("input-limit")));
            limit.selectByVisibleText("25");

            WebElement selectedOption = limit.getFirstSelectedOption();
            System.out.println("Selected option: " + selectedOption.getText());

        } catch (StaleElementReferenceException e) {
            WebElement limitElement = driver.findElement(By.id("input-limit"));
            Select limit = new Select(limitElement);
            limit.selectByVisibleText("25");

            WebElement selectedOption = limit.getFirstSelectedOption();
            System.out.println("Selected option: " + selectedOption.getText());
        }
    }

    @Test
    void show4thitemperpage() {
        driver.get("http://192.168.91.192/en-gb/catalog/desktops");
        try {
            Select limit = new Select(driver.findElement(By.id("input-limit")));
            limit.selectByVisibleText("75");

            WebElement selectedOption = limit.getFirstSelectedOption();
            System.out.println("Selected option: " + selectedOption.getText());

        } catch (StaleElementReferenceException e) {
            WebElement limitElement = driver.findElement(By.id("input-limit"));
            Select limit = new Select(limitElement);
            limit.selectByVisibleText("75");

            WebElement selectedOption = limit.getFirstSelectedOption();
            System.out.println("Selected option: " + selectedOption.getText());
        }
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }
}
