import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OpenCartTest extends BaseTest {
    private HomePage homePage;
    private MP3PlayersPage mp3PlayersPage;
    private ProductPage productPage;

    @BeforeEach
    void setupPages() {
        homePage = new HomePage(driver);
        mp3PlayersPage = new MP3PlayersPage(driver);
        productPage = new ProductPage(driver);
    }

    @Test
    void testAddProductsToCart() throws IOException {
        homePage.goToMP3Players();
        mp3PlayersPage.switchToListView();

        List<String> products = TestDataReader.getProductList("testdata/products.txt");

        for (String product : products) {
            if (mp3PlayersPage.isProductDisplayed(product)) {
                addProductToCart(product);
            } else {
                System.out.println(" Product not found: " + product);
            }
        }
    }

    private void addProductToCart(String productName) {
        mp3PlayersPage.openProduct(productName);
        productPage.addRandomQuantityToCart();
        assertTrue(productPage.isAddedToCart(), "⚠️ Failed to add " + productName + " to cart");
    }
}
