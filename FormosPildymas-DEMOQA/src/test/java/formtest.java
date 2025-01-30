import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class formtest {

    @Test
    void form() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");

        driver.findElement(By.id("firstName")).sendKeys("batman");
        driver.findElement(By.id("lastName")).sendKeys("batman");
        driver.findElement(By.id("userEmail")).sendKeys("batman@gmail.com");


        driver.findElement(By.cssSelector("label[for='gender-radio-1']")).click();

        driver.findElement(By.id("userNumber")).sendKeys("4040404045");
        driver.findElement(By.id("dateOfBirthInput")).sendKeys(Keys.CONTROL + "a");
        driver.findElement(By.id("dateOfBirthInput")).sendKeys("2005-05-05");
        driver.findElement(By.id("dateOfBirthInput")).sendKeys(Keys.ENTER);

        driver.findElement(By.id("subjectsInput")).sendKeys("Computer Science");
        driver.findElement(By.id("subjectsInput")).sendKeys(Keys.ENTER);
        driver.findElement(By.id("hobbiesWrapper")).click();
        driver.findElement(By.id("uploadPicture")).sendKeys("C:\\Users\\D2PT\\Desktop\\text.txt");
        driver.findElement(By.id("currentAddress")).sendKeys("uuyagyusagyusdagyusagsyuagdsyuagdyu");


        driver.findElement(By.id("state")).click();
        driver.findElement(By.xpath("//div[text()='Haryana']")).click();


        driver.findElement(By.id("city")).click();
        driver.findElement(By.xpath("//div[text()='Karnal']")).click();

        driver.findElement(By.id("submit")).click();

        driver.quit();

    }
}
