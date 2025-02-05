import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MainPage extends BasePage {

    @FindBy(id = "todo-input")
    private WebElement taskInput;

    @FindBy(css = ".todo-list label")
    private List<WebElement> tasks;

    @FindBy(xpath = "/html//section[@id='root']//ul[@class='todo-list']//input[@class='toggle']")
    private List<WebElement> checkboxes;

    @FindBy(css = ".destroy")
    private List<WebElement> deleteButtons;
    @FindBy(css = ".todo-list label")
    private List<WebElement> taskLabels;


    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void addTask(String taskName) {
        taskInput.sendKeys(taskName);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();
    }

    public boolean isTaskDisplayed(String taskName) {
        return tasks.stream().anyMatch(task -> task.getText().equals(taskName));
    }

    public int getTaskCount() {
        return tasks.size();
    }

    public void markTaskAsCompleted(String taskName) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getText().equals(taskName)) {
                checkboxes.get(i).click();
                break;
            }
        }
    }

    public boolean isTaskCompleted(String taskName) {
        for (WebElement task : tasks) {
            if (task.getText().equals(taskName)) {
                return task.getAttribute("class").contains(taskName);
            }
        }
        return false;
    }

    public void deleteTask(String taskName) {
        Actions actions = new Actions(driver);
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getText().equals(taskName)) {
                actions.moveToElement(tasks.get(i)).perform();
                deleteButtons.get(i).click();
                break;
            }
        }
    }

    public boolean isTaskDeleted(String taskName) {
        return tasks.stream().noneMatch(task -> task.getText().equals(taskName));
    }


    public void editTask(String oldTask, String newTask) {
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Wait for up to 10 seconds

        for (WebElement taskLabel : taskLabels) {
            if (taskLabel.getText().equals(oldTask)) {

                actions.doubleClick(taskLabel).perform();

                WebElement taskInputField = wait.until(ExpectedConditions.visibilityOf(taskInput));

                taskInputField.clear();


                taskInputField.sendKeys(newTask);


                taskInputField.sendKeys(Keys.ENTER);
                break;
            }
        }
    }
}

