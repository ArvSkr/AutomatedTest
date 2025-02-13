import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage extends BasePage {
    private By cartIcon = By.cssSelector(".btn.btn-block.btn-inverse.btn-lg.dropdown-toggle");
    private By viewCart = By.linkText("View Cart");
    private By shippingAndTaxes = By.cssSelector("#accordion .accordion-item:nth-of-type(1) [data-bs-toggle]");
    private By inputCountry = By.id("input-country");
    private By inputCity = By.id("input-zone");
    private By quoteButton = By.cssSelector("#button-quote");
    private By shippingButton = By.id("button-shipping-method");
    private By subTotal = By.cssSelector("tfoot#checkout-total > tr:nth-of-type(1) > td:nth-of-type(2)");
    private By shippingCost = By.cssSelector("tfoot#checkout-total > tr:nth-of-type(2) > td:nth-of-type(2)");
    private By total = By.cssSelector("tr:nth-of-type(3) > td:nth-of-type(2)");



    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean verifyItemInCart(String productName) {
        driver.findElement(cartIcon).click();
        return driver.getPageSource().contains(productName);
    }
    public void clickOnCart(){
        driver.findElement(cartIcon).click();
        driver.findElement(viewCart).click();
    }
    public void estimateShippingAndTaxes(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(shippingAndTaxes));
        driver.findElement(shippingAndTaxes).click();


        driver.findElement(inputCountry).click();
        driver.findElement(By.cssSelector("[value='123']")).click();
        driver.findElement(inputCity).click();
        driver.findElement(By.cssSelector("[value='1920']")).click();
        driver.findElement(quoteButton).click();
        driver.findElement(By.cssSelector("input#input-shipping-method-flat-flat")).click();
        driver.findElement(shippingButton).click();
    }
    public void checkIfTotalIsSame(){

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            wait.until(ExpectedConditions.visibilityOfElementLocated(subTotal));
            wait.until(ExpectedConditions.visibilityOfElementLocated(shippingCost));
            wait.until(ExpectedConditions.visibilityOfElementLocated(total));

            String subTotalText = driver.findElement(subTotal).getText().replaceAll("[^0-9.]", "");
            String shippingCostText = driver.findElement(shippingCost).getText().replaceAll("[^0-9.]", "");
            String totalText = driver.findElement(total).getText().replaceAll("[^0-9.]", "");

            double subTotalValue = Double.parseDouble(subTotalText);
            double shippingCostValue = Double.parseDouble(shippingCostText);
            double totalValue = Double.parseDouble(totalText);

        System.out.println((subTotalValue + shippingCostValue) == totalValue);


    }
}
