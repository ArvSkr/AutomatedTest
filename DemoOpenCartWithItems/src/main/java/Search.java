import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Search extends BasePage{
    public Search(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = ".form-control.form-control-lg")
    WebElement searchBar;
    @FindBy(css = ".btn-light.btn-lg")
    WebElement searchButton;

    void inputSearchBar(String words){
        searchBar.sendKeys(words);
        searchButton.click();

    }
    public boolean isProductDisplayed(String productName) {
        return driver.getPageSource().contains(productName);
    }
}
