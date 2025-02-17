import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends SignUpPage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "field-email")
    private WebElement email;
    @FindBy(id = "field-password")
    private WebElement password;
    @FindBy(id = "submit-login")
    private WebElement submitLogin;
    @FindBy(css = "div#_desktop_user_info  a[title='Log in to your customer account']")
    private WebElement login;


    public void quickSignUp() {
        SignUpPage signIn = new SignUpPage(driver);
        signIn.clickNoAccount();
        signIn.AccountCreation("Tester", "Tester", "Tester10@tester.com", "Tester*12345");
        signIn.isAccountDisplayed();
        signIn.signOut();
    }

    public void login(String Email, String Password) {
        email.sendKeys(Email);
        password.sendKeys(Password);
        submitLogin.click();
    }


}
