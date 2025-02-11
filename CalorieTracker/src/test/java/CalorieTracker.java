import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.*;

public class CalorieTracker extends SetUpTest {


    @Test
    void inputMeal() {
        Main main = new Main();
        main.clickConsentButton();
        main.inputMealName("Steak");
        main.inputCalories("2000");
        main.addMeal();
        WebElement addedMeal = Base.driver.findElement(By.xpath("//div[contains(text(),'Steak')]"));
        assertNotNull(addedMeal, "Steak meal should be present in the UI after adding.");
    }


    @Test
    void addMultipleMeals() {
        Main main = new Main();
        main.clickConsentButton();
        main.inputMealName("Burger");
        main.inputCalories("800");
        main.addMeal();
        main.inputMealName("Salad");
        main.inputCalories("200");
        main.addMeal();
        WebElement addedMeal = Base.driver.findElement(By.xpath("//div[contains(text(),'" + "Burger" + "Salad" + "')]"));
        assertNotNull(addedMeal, "Burger" + "Salad" + " should be present in the UI.");
    }

    @Test
    void addMealWithEmptyFields() {
        Main main = new Main();
        main.clickConsentButton();
        main.inputMealName("");
        main.inputCalories("");
        main.addMeal();
        WebElement addMealBtn = Base.driver.findElement(By.cssSelector(".add-btn.blue.btn.darken-3"));
        assertFalse(addMealBtn.isEnabled(), "Add Meal button should be disabled for invalid calorie input.");
    }


    @Test
    void inputInvalidCalories() {
        Main main = new Main();
        main.clickConsentButton();
        main.inputMealName("Soup");
        main.inputCalories("abc");
        main.addMeal();
        WebElement addMealBtn = Base.driver.findElement(By.cssSelector(".add-btn.blue.btn.darken-3"));
        assertFalse(addMealBtn.isEnabled(), "Add Meal button should be disabled for invalid calorie input.");

    }
}
