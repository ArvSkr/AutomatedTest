
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FilterTest extends BaseTest {


    @Test
    void testSearchFunctionality() {
        Main main = new Main();
        String text = "at";
        main.searchProduct(text);
        List<WebElement> productNames = main.getProductList();
        for (WebElement product : productNames) {
            assertTrue(product.getText().toLowerCase().contains(text.toLowerCase()),
                    "Product does not contain '" + text + "': " + product.getText());
        }
    }

    @Test
    void testSortingFunctionality() {
        Main main = new Main();
        main.sortProducts();

        List<WebElement> productNames = main.getProductList();
        List<String> obtainedList = new ArrayList<>();
        for (WebElement product : productNames) {
            obtainedList.add(product.getText());
        }

        List<String> sortedList = new ArrayList<>(obtainedList);
        Collections.sort(sortedList);

        Assertions.assertEquals(sortedList, obtainedList, "Products are not sorted alphabetically");
    }


}
