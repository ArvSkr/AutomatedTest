import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FilterTest {
    static WebDriver driver;
    static WebDriverWait wait;

    @BeforeAll
    static void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test
    void testSearchFunctionality() {

        String searchText = "at";
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-field")));
        searchBox.clear();
        searchBox.sendKeys(searchText);

        List<WebElement> productNames = driver.findElements(By.xpath("//tr/td[1]"));

        for (WebElement product : productNames) {
            assertTrue(product.getText().toLowerCase().contains(searchText),
                    "Product does not have'" + searchText + "': " + product.getText());
        }
    }

    @Test
    void testSortingFunctionality() {
        WebElement sortHeader = driver.findElement(By.xpath("//tr/th[1]"));
        sortHeader.click();

        List<WebElement> productNames = driver.findElements(By.xpath("//tr/td[1]"));
        List<String> obtainedList = new ArrayList<>();
        for (WebElement product : productNames) {
            obtainedList.add(product.getText());
        }

        List<String> sortedList = new ArrayList<>(obtainedList);
        Collections.sort(sortedList);

        Assertions.assertEquals(sortedList, obtainedList, "Products are not sorted by alphabetically");
    }


    @AfterAll
    static void tearDown() {
        if (driver != null) {
            
        }
    }
}
