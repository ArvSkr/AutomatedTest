import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MP3PlayersPage extends BasePage {
    private By listViewButton = By.cssSelector("button#list-view");

    public MP3PlayersPage(WebDriver driver) {
        super(driver);
    }

    public void switchToListView() {
        driver.findElement(listViewButton).click();
    }

    public boolean isProductDisplayed(String productName) {
        return driver.getPageSource().contains(productName);
    }

    public void openProduct(String productName) {
        driver.findElement(By.linkText(productName)).click();
    }
}
