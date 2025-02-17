import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProductPage extends MainPage {
    @FindBy(css = "select[name='group[1]']")
    WebElement sizeSelector;
    @FindBy(css = ".add-to-cart.btn.btn-primary")
    WebElement addToCart;
    @FindBy(css = ".modal-body .btn.btn-primary")
    WebElement checkOut;
    @FindBy(css = ".wishlist-login > div[role='dialog'] > div[role='document'] .btn.btn-secondary.modal-cancel")
    WebElement cancelButton;
    @FindBy(css = ".wishlist-button-add.wishlist-button-product")
    WebElement wishList;

    @FindBy(css = ".wishlist-login > div[role='dialog'] > div[role='document']  .modal-header")
    WebElement popUpHeader;

    public ProductPage(WebDriver driver) {
        super(driver);
    }


    public void selectSize(String size) {
        Select select = new Select(sizeSelector);

        select.selectByVisibleText(size);
    }


    public void addToCart() {
        addToCart.click();
        checkOut.click();
    }

    public void wishlist() {
        wishList.click();
    }

    public boolean isSignInPopUpDisplayed() {
        if (popUpHeader.isDisplayed()) {
            return true;
        }
        return false;
    }

    public void setCancelButton() {
        cancelButton.click();
    }
}
