import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.time.Duration.ofSeconds;

public class Testlogin {
    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(ofSeconds(5));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test
    void Loginvalid() {
        WebElement usernameLabel = driver.findElement(By.cssSelector(".orangehrm-demo-credentials p:nth-child(1)"));
        String usernameText = usernameLabel.getText();
        String username = usernameText.replace("Username : ", "").trim();
        WebElement passwordLabel = driver.findElement(By.cssSelector(".orangehrm-demo-credentials p:nth-child(2)"));
        String passwordText = passwordLabel.getText();
        String password = passwordText.replace("Password : ", "").trim();
        WebElement usernameInput = driver.findElement(By.xpath("//div[@id='app']/div[@class='orangehrm-login-layout']//div[@class='orangehrm-login-slot']//form[@action='/web/index.php/auth/validate']/div[1]/div//input[@name='username']"));
        usernameInput.sendKeys(username);
        WebElement passwordInput = driver.findElement(By.xpath("//div[@id='app']/div[@class='orangehrm-login-layout']//div[@class='orangehrm-login-slot']//form[@action='/web/index.php/auth/validate']/div[2]/div//input[@name='password']"));
        passwordInput.sendKeys(password);
        WebElement Loginbutton = driver.findElement(By.xpath("//div[@id='app']/div[@class='orangehrm-login-layout']//div[@class='orangehrm-login-slot']//form[@action='/web/index.php/auth/validate']/div[3]/button[@type='submit']"));
        Loginbutton.click();
    }

}
