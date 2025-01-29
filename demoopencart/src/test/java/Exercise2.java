import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static java.time.Duration.ofSeconds;

public class Exercise2 {
    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(ofSeconds(5));
    }

    @Test
    void invalidsearchname() {


        driver.get("http://192.168.91.192/en-gb?route=common/home");


        WebElement searchbar = driver.findElement(By.cssSelector(".form-control.form-control-lg"));

        searchbar.sendKeys("MaxBook");
        driver.findElement(By.tagName("button")).click();
        boolean issearchbuttondisplayed = driver.findElement(By.tagName("button")).isDisplayed();
        System.out.println(issearchbuttondisplayed);

    }

    @Test
    void validsearchname() {


        driver.get("http://192.168.91.192/en-gb?route=common/home");


        WebElement searchbar = driver.findElement(By.cssSelector(".form-control.form-control-lg"));

        searchbar.sendKeys("MaxBook");
        searchbar.clear();
        searchbar.sendKeys("Macbook");
        driver.findElement(By.tagName("button")).click();
        List<WebElement> productItems = driver.findElements(By.cssSelector(".product-thumb"));
        System.out.println(productItems.size());
        try {
            Select sort = new Select(driver.findElement(By.id("input-sort")));
            sort.selectByVisibleText("Price (Low > High)");

            WebElement selectedOption = sort.getFirstSelectedOption();
            System.out.println("Selected option: " + selectedOption.getText());

        } catch (StaleElementReferenceException e) {
            WebElement limitElement = driver.findElement(By.id("input-sort"));
            Select sort = new Select(limitElement);
            sort.selectByVisibleText("Price (Low > High)");

            WebElement selectedOption = sort.getFirstSelectedOption();
            System.out.println("Selected option: " + selectedOption.getText());
        }
    }


    @AfterEach
    void teardown() {
        driver.quit();
    }
}
