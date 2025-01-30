import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.time.Duration.ofSeconds;

public class ActionTest {

    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(ofSeconds(60));
    }

    @Test
    void DragAndDrop() {
        driver.get("https://webdriveruniversity.com/Actions/index.html");
        Actions actions = new Actions(driver);
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));
        actions.dragAndDrop(draggable, droppable).build().perform();

    }

    @Test
    void doubleclick() {
        driver.get("https://webdriveruniversity.com/Actions/index.html");
        Actions actions = new Actions(driver);
        WebElement doubleclick = driver.findElement(By.id("double-click"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(doubleclick));
        actions.doubleClick(doubleclick).perform();

    }

    @Test
    void mouseHover() {
        driver.get("https://webdriveruniversity.com/Actions/index.html");
        Actions actions = new Actions(driver);
        WebElement button1 = driver.findElement(By.xpath("//div[@id='div-hover']/div[1]/button[@class='dropbtn']"));
        WebElement button2 = driver.findElement(By.xpath("//div[@id='div-hover']/div[2]/button[@class='dropbtn']"));
        WebElement button3 = driver.findElement(By.xpath("//div[@id='div-hover']/div[3]/button[@class='dropbtn']"));


        actions.moveToElement(button1)
                .moveToElement(button2)
                .moveToElement(button3)
                .perform();
    }

    @Test
    void clickAndHold() {
        driver.get("https://webdriveruniversity.com/Actions/index.html");
        Actions actions = new Actions(driver);
        WebElement clickandhold = driver.findElement(By.id("click-box"));
        actions.clickAndHold(clickandhold).perform();
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }
}
