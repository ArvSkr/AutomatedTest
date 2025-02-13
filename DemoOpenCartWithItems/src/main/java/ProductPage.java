import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage extends BasePage {

    private By addToCartButton = By.cssSelector("#product-list [class='col mb-3']:nth-of-type(1) .button-group [type='submit']:nth-of-type(1)");
    private By successMessage = By.cssSelector(".alert-dismissible");
    private By closeButton = By.cssSelector(".btn-close");
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void addToCart() {
        driver.findElement(addToCartButton).click();
    }


    public boolean isAddedToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)); // Wait for the success message to be visible
            if (message.isDisplayed()) {

                driver.findElement(closeButton).click();
                return true;
            }
        } catch (Exception e) {

            System.out.println("Success message not displayed.");
        }
        return false;
    }
}
