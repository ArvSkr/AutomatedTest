import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
    final WebDriver driver;

    @FindBy(linkText = "No account? Create one here")
    private WebElement noAccount;

    @FindBy(id = "field-id_gender-1")
    private WebElement mrOrMiss;
    @FindBy(id = "field-firstname")
    private WebElement firstName;

    @FindBy(id = "field-lastname")
    private WebElement lastName;

    @FindBy(id = "field-email")
    private WebElement email;
    @FindBy(id = "field-password")
    private WebElement password;
    @FindBy(css = "input[name='psgdpr']")
    private WebElement agreeWithTerms;
    @FindBy(css = "input[name='customer_privacy']")
    private WebElement customerPrivacy;
    @FindBy(css = "[data-link-action]")
    private WebElement submit;
    @FindBy(css = "[title] .hidden-sm-down")
    private WebElement accountName;
    @FindBy(css = ".hidden-sm-down.logout")
    private WebElement signout;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void isAccountDisplayed() {
        accountName.isDisplayed();
    }

    public void clickNoAccount() {
        noAccount.click();
    }

    public void AccountCreation(String first, String last, String Email, String Password) {
        mrOrMiss.click();
        firstName.sendKeys(first);
        lastName.sendKeys(last);
        email.sendKeys(Email);
        password.sendKeys(Password);
        agreeWithTerms.click();
        customerPrivacy.click();
        submit.click();
    }

    public void signOut() {
        signout.click();
    }


}
