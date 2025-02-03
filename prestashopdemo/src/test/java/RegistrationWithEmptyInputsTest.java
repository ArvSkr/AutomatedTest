
import Inputs.LoginPage;
import Inputs.MainPage;
import Inputs.SignUpPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class RegistrationWithEmptyInputsTest extends BaseTest {
    @Test
    void registrationWithEmptyInputs(){
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLogin();
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.signUpPageNavigation();
        signUpPage.setMrOrMiss();
        String fullName = signUpPage.nameInputs("", "");
        signUpPage.emailInput("");
        signUpPage.passwordInput("");
        signUpPage.birthdayInput("");
        signUpPage.clickOptions();
        String actualFirstName = signUpPage.getFirstName();
        String actualLastName = signUpPage.getLastName();
        String actualEmail = signUpPage.getEmail();
        String actualPassword = signUpPage.getPassword();

        String expectedName = "";
        String expectedEmail = "";
        String expectedPassword="";

        assertEquals(expectedName, actualFirstName);
        assertEquals(expectedName, actualLastName);
        assertEquals(expectedEmail, actualEmail);
        assertEquals(expectedPassword, actualPassword);
        String titleactual = signUpPage.getTitle();
        assertEquals("Create an account", titleactual);


    }

}
