import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OpenCartTest extends BaseTest {
    private HomePage homePage;
    private MP3PlayersPage mp3PlayersPage;
    private ProductPage productPage;
    private Search search;
    private CartPage cartPage;

    @BeforeEach
    void setupPages() {
        homePage = new HomePage(driver);
        mp3PlayersPage = new MP3PlayersPage(driver);
        productPage = new ProductPage(driver);
        search = new Search(driver);
        cartPage = new CartPage(driver);
    }

    @Test
    void testAddProductsToCart() throws IOException {
        homePage.goToMP3Players();
        mp3PlayersPage.switchToListView();

        List<String> products = TestDataReader.getProductList("src/testdata/products.txt");

        for (String product : products) {
            if (mp3PlayersPage.isProductDisplayed(product)) {
                productPage.addToCart();
                productPage.isAddedToCart();
                System.out.println(product + " is added to cart");
            } else {
                System.out.println(" Product not found: " + product);
            }
        }
    }
    @Test
    void addToCartAndCheckTotal(){
        search.inputSearchBar("touch");
        search.isProductDisplayed("touch");

        List<WebElement> products = driver.findElements(By.cssSelector(".product-thumb"));

        for(WebElement product : products){
            String productName = product.findElement(By.cssSelector(".product-title")).getText();

            productPage.addToCart();
            productPage.isAddedToCart();

            
            System.out.println(productName + " is added to cart");
        }
        cartPage.clickOnCart();
        cartPage.estimateShippingAndTaxes();
        cartPage.checkIfTotalisSame();
    }


}
