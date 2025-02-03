import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import javax.swing.*;

public class MainPage extends BasePage {
    @FindBy(id = "todo-input")
    private WebElement task;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void addTask(String taskName) {
        task.sendKeys(taskName);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();
    }
}
