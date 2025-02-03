import Inputs.MainPage;
import Inputs.SignUpPage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class InvalidEmailTest extends  BaseTest{
    @Test
    void invalidEmailTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLogin();
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.signUpPageNavigation();
        signUpPage.setMrOrMiss();
        String fullName = signUpPage.nameInputs("Tester", "Tester");
        signUpPage.emailInput("Tester@tester");
        signUpPage.passwordInput("Tester*12345");
        signUpPage.birthdayInput("2005-12-05");
        signUpPage.clickOptions();
        String errorMessage = signUpPage.getError();
        assertEquals("Invalid format.", errorMessage, "");

    }
}
