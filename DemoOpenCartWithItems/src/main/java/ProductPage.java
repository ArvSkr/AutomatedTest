import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class ProductPage extends BasePage {
    private By qtyField = By.id("input-quantity");
    private By addToCartButton = By.id("button-cart");
    private By successMessage = By.cssSelector(".alert-success");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void addRandomQuantityToCart() {
        int randomQty = new Random().nextInt(20) + 1;
        driver.findElement(qtyField).clear();
        driver.findElement(qtyField).sendKeys(String.valueOf(randomQty));
        driver.findElement(addToCartButton).click();
    }

    public boolean isAddedToCart() {
        return driver.findElement(successMessage).isDisplayed();
    }
}
