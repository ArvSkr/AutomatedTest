import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class MP3PlayersPage extends BasePage {
    private By listViewButton = By.cssSelector(".nav-link.dropdown-toggle");
    private By allMP3 = By.linkText("Show All MP3 Players");


    public MP3PlayersPage(WebDriver driver) {
        super(driver);
    }

    public void switchToListView() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(listViewButton));
        driver.findElement(allMP3).click();

    }

    public boolean isProductDisplayed(String productName) {
        return driver.getPageSource().contains(productName);
    }

    public void openProduct(String productName) {
        driver.findElement(By.linkText(productName)).click();
    }
}
