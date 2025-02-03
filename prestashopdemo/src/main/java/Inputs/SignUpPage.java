package Inputs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BasePage {

    @FindBy(xpath = "//div[@id='content']/div[@class='no-account']" )
    private WebElement noAccount;

    @FindBy(xpath = "/html//form[@id='customer-form']/div/div[1]/div[1]/label[1]" )
    private WebElement MrOrMiss;

    @FindBy(id = "field-firstname")
    private WebElement firstName;

    @FindBy(id = "field-lastname")
    private WebElement lastName;

    @FindBy(id = "field-email")
    private WebElement email;
    @FindBy(id = "field-password")
    private WebElement Password;

    @FindBy(id = "field-birthday" )
    private WebElement Birthday;
    @FindBy(xpath = "/html//form[@id='customer-form']/div/div[7]//input[@name='optin']")
    private WebElement Option1;
    @FindBy(css = "input[name='psgdpr']")
    private WebElement AggreWithTerms;
    @FindBy(xpath = "/html//form[@id='customer-form']/div/div[10]//input[@name='customer_privacy']")
    private WebElement CustomerPrivacy;
    @FindBy(xpath = "//form[@id='customer-form']//button[@type='submit']")
    private WebElement submit;
    @FindBy(css = "a[title='View my customer account']")
    private WebElement accountName;
    @FindBy(xpath = "//section[@id='main']//h1[1]")
    private WebElement title;


    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public void signUpPageNavigation(){

       noAccount.click();
    }
    public void setMrOrMiss(){
        MrOrMiss.click();

    }
    public String nameInputs(String firstname, String lastname) {
        firstName.sendKeys(firstname);
        lastName.sendKeys(lastname);
        return firstname + " " + lastname;  // Return concatenated full name
    }

    public void emailInput(String Email) {
        email.sendKeys(Email);
    }
    public void passwordInput(String password){
        Password.sendKeys(password);
    }
     public void birthdayInput( String birthday){
         Birthday.sendKeys(birthday);
     }
    public WebElement getAccountName() {
        return accountName;
    }


    public void clickOptions(){
         Option1.click();

         AggreWithTerms.click();
         CustomerPrivacy.click();

         submit.click();
     }
    public String getFirstName() {
        return firstName.getAttribute("value");
    }

    public String getLastName(){
        return lastName.getAttribute("value");
    }

    public String getEmail() {
        return email.getAttribute("value");
    }
    public String getPassword(){
        return Password.getAttribute("value");
    }
    public String getTitle(){
        return title.getAttribute("value");
    }

}


