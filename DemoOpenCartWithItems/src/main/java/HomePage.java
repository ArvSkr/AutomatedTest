import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private By mp3PlayersMenu = By.linkText("MP3 Players");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void goToMP3Players() {
        driver.findElement(mp3PlayersMenu).click();
    }
}
