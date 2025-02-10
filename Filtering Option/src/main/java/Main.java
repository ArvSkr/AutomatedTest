import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;


public class Main extends Base {
    private final By searchBox = By.id("search-field");
    private final By productNames = By.xpath("//tr/td[1]");
    private final By sortHeader = By.xpath("//tr/th[1]");


    public void searchProduct(String text) {
        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
        searchField.clear();
        searchField.sendKeys(text);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productNames));
    }

    public List<WebElement> getProductList() {
        return driver.findElements(productNames);
    }

    public void sortProducts() {
        driver.findElement(sortHeader).click();
    }
}
