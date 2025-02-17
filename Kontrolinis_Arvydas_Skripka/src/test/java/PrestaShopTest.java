import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class PrestaShopTest extends BaseTest {


    @Test
    void signUpTest() {
        MainPage main = new MainPage(driver);
        main.clickToSignIn();
        SignUpPage signIn = new SignUpPage(driver);
        signIn.clickNoAccount();
        signIn.AccountCreation("Tester", "Tester", "Tester50@tester.com", "Tester*12345");
        signIn.isAccountDisplayed();
        signIn.signOut();
    }

    @Test
    void loginTest() {
        MainPage main = new MainPage(driver);
        main.clickToSignIn();
        LoginPage login = new LoginPage(driver);
        login.quickSignUp();
        main.clickToSignIn();
        login.login("Tester10@tester.com", "Tester*12345");
        login.isAccountDisplayed();
    }

    @Test
    void addItemsToCart() {

        List<String[]> productList = List.of(
                new String[]{"Hummingbird printed t-shirt", "23.9", "20", "XL"},
                new String[]{"HUMMINGBIRD PRINTED SWEATER", "35.9", "20", "M"}
        );

        MainPage main = new MainPage(driver);


        for (String[] productData : productList) {
            String productName = productData[0];
            String price = productData[1];
            String discount = productData[2];
            String size = productData[3];

            main.SearchItem(productName);
            if (main.isProductDisplayed(productName)) {
                main.openProductPage(productName);

                ProductPage productPage = new ProductPage(driver);
                productPage.wishlist();
                assertTrue(productPage.isSignInPopUpDisplayed(), "Pop Up did not show up");
                productPage.setCancelButton();
                productPage.selectSize(size);
                productPage.addToCart();

                CartPage cartPage = new CartPage(driver);
                assertTrue(cartPage.isProductInCart(productName), "Product not added to cart.");
            }
        }
    }

}





