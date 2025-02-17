import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;

import java.time.Duration;


public class MainPage {
    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickToSignIn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement signIn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='_desktop_user_info']//a")));
        signIn.click();
    }

    public void SearchItem(String productName) {
        WebElement searchBar = driver.findElement(By.cssSelector("input[name='s']"));
        searchBar.sendKeys(productName);
        searchBar.sendKeys(Keys.ENTER);

    }

    public boolean isProductDisplayed(String productName) {

        WebElement product = driver.findElement(By.cssSelector("h2 > a"));

        String productname = product.getText();

        String[] productNameParts = productname.split(" ");

        if (productNameParts.length > 0) {
            productNameParts[0] = productNameParts[0].substring(0, 1).toUpperCase() + productNameParts[0].substring(1).toLowerCase();
        }

        String modifiedProductName = String.join(" ", productNameParts);


        if (modifiedProductName.equalsIgnoreCase(productName.toUpperCase())) {

            return true;
        } else {

            String productInCaps = modifiedProductName.toUpperCase();
            System.out.println("Product name detected (in uppercase): " + productInCaps);
        }

        return false;
    }


    public void openProductPage(String productName) {

        WebElement product = driver.findElement(By.cssSelector("h2 > a"));
        product.click();


    }
}

