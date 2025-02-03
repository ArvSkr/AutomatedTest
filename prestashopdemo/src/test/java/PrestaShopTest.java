
import Inputs.LoginPage;
import Inputs.MainPage;
import Inputs.SignUpPage;
import com.google.common.base.MoreObjects;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class PrestaShopTest extends BaseTest {


    @Test
    void SignupTest() {

        MainPage mainPage = new MainPage(driver);
        mainPage.clickLogin();
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.signUpPageNavigation();
        signUpPage.setMrOrMiss();
        String fullName = signUpPage.nameInputs("Tester", "Tester");
        signUpPage.emailInput("Tester3@tester.com");
        signUpPage.passwordInput("Tester*12345");
        signUpPage.birthdayInput("2005-05-04");
        signUpPage.clickOptions();
        String account = signUpPage.getAccountName().getText();
        assertEquals(fullName, account, "Tester Tester");



    }
    @Test
    void LoginTest(){
        MainPage mainPage = new MainPage(driver);
        SignUpPage signUpPage = new SignUpPage(driver);
        mainPage.clickLogin();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.quickSignUp();
        loginPage.signOut();
        loginPage.loginClick();
        loginPage.loginForm("Tester2@Tester.com", "Tester*12345");
        loginPage.viewAccount();
        String actualFirstName = signUpPage.getFirstName();
        String actualLastName = signUpPage.getLastName();
        String actualEmail = signUpPage.getEmail();

        String expectedname = "Tester";
        String expectedEmail = "Tester2@tester.com";


        assertEquals(expectedname, actualFirstName, "Tester");
        assertEquals(expectedname, actualLastName, "Tester");
        assertEquals(expectedEmail, actualEmail, "Tester2@Tester.com");





    }
}
