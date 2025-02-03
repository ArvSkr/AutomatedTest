package Inputs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.PrivateKey;
import java.time.Duration;

public class LoginPage extends SignUpPage{
    @FindBy(css = ".hidden-sm-down.logout")
    private WebElement signout;
    @FindBy(id = "field-email")
    private WebElement email;
    @FindBy(id = "field-password")
    private WebElement password;
    @FindBy(id = "submit-login")
    private WebElement signin;
    @FindBy(css= "div#_desktop_user_info  a[title='Log in to your customer account']")
    private WebElement login;
    @FindBy(css = "a[title='View my customer account']")
    private WebElement account;
    @FindBy(css = "a#identity-link")
    private WebElement info;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void quickSignUp(){
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.signUpPageNavigation();
        signUpPage.setMrOrMiss();
        String fullName = signUpPage.nameInputs("Tester", "Tester");
        signUpPage.emailInput("Tester2@Tester.com");
        signUpPage.passwordInput("Tester*12345");
        signUpPage.birthdayInput("2005-05-04");
        signUpPage.clickOptions();
    }
    public void signOut(){
        signout.click();
    }
    public void loginForm(String Email, String Password){
        email.sendKeys(Email);
        password.sendKeys(Password);
        signin.click();
    }
    public void loginClick(){
        login.click();
    }
    public void viewAccount(){
        account.click();
        info.click();

    }

}
