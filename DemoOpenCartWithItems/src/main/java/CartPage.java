import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    private By cartIcon = By.cssSelector(".btn.btn-block.btn-inverse.btn-lg.dropdown-toggle");
    private By viewCart = By.linkText("View Cart");
    private By shippingAndTaxes = By.cssSelector("#accordion .accordion-item:nth-of-type(1) [data-bs-toggle]");
    private By inputCountry = By.cssSelector("#input-country");
    private By inputCity = By.cssSelector("#input-zone");
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
        driver.findElement(shippingAndTaxes).click();
        driver.findElement(inputCountry).click();
        driver.findElement(By.cssSelector("[value='123']")).click();
        driver.findElement(inputCity).click();
        driver.findElement(By.cssSelector("[value='1920']")).click();
        driver.findElement(quoteButton).click();
        driver.findElement(By.cssSelector("input#input-shipping-method-flat-flat")).click();
        driver.findElement(shippingButton).click();
    }
    public boolean checkIfTotalisSame(){

        String subTotalText = driver.findElement(subTotal).getText().replaceAll("[^0-9.]", "");
        String shippingCostText = driver.findElement(shippingCost).getText().replaceAll("[^0-9.]", "");
        String totalText = driver.findElement(total).getText().replaceAll("[^0-9.]", "");


        double subTotalValue = Double.parseDouble(subTotalText);
        double shippingCostValue = Double.parseDouble(shippingCostText);
        double totalValue = Double.parseDouble(totalText);


        return (subTotalValue + shippingCostValue) == totalValue;
    }
}
