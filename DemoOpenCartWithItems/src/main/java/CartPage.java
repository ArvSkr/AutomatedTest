import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    private By cartIcon = By.cssSelector("#cart-total");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean verifyItemInCart(String productName) {
        driver.findElement(cartIcon).click();
        return driver.getPageSource().contains(productName);
    }
}
