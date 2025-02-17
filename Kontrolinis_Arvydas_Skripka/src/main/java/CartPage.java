import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends MainPage {
    @FindBy(css = "div#_desktop_cart > .blockcart.cart-preview")
    WebElement cart;
    @FindBy(css = ".cart-items .cart-item:nth-of-type(1)")
    WebElement Item1;
    @FindBy(css = ".cart-items .cart-item:nth-of-type(2)")
    WebElement Item2;


    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductInCart(String productName) {
        cart.click();
        if (Item1.isDisplayed() || Item2.isDisplayed()) {
            return true;
        }
        return false;
    }
}
