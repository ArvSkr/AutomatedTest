import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main extends Base {
    private By mealNameField = By.id("item-name");
    private By caloriesField = By.id("item-calories");
    private By addMealButton = By.cssSelector(".add-btn.blue.btn.darken-3");
    private final By consentButton = By.cssSelector(".fc-button.fc-cta-consent.fc-primary-button");


    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    public void inputMealName(String meal) {
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(mealNameField));
        input.clear();
        input.sendKeys(meal);
    }

    public void inputCalories(String calories) {
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(caloriesField));
        input.clear();
        input.sendKeys(calories);
    }

    public void addMeal() {
        wait.until(ExpectedConditions.elementToBeClickable(addMealButton)).click();
    }


    public void clickConsentButton() {
        WebElement consent = wait.until(ExpectedConditions.elementToBeClickable(consentButton));
        consent.click();
    }
}
