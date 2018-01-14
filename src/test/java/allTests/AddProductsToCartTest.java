package allTests;

/**
 * This is a test for verification of adding products to shopping cart and cleaning shopping cart
 */

import org.junit.Test;
import parentTest.ParentTest;

public class AddProductsToCartTest extends ParentTest {

    final private String HOMEPAGE_TITLE = "Homepage";
    final private String PRODUCT_KEYWORD = "gslgsv-h10"; // Note: product should be in stock
    final private Integer PRODUCT_QUANTITY = 5; // quantity should be integer from 1 to 999

    @Test
    public void addProductToCartFromPDPTest() {

        // open Homepage and search by product keyword
        homePage.openHomePage();
        homePage.checkTitle(HOMEPAGE_TITLE);
        homePage.searchBySearchKeyword(PRODUCT_KEYWORD);
        checkAcceptanceCriteria("Product details page isn't shown", productDetailsPage.isItProductDetailsPage(), true);

        // on product details page change quantity and add product to shopping cart
        productDetailsPage.changeProductQuantity(PRODUCT_QUANTITY);
        productDetailsPage.clickOnAddToCartButton();
        checkAcceptanceCriteria("Add to cart popup isn't shown", productDetailsPage.checkIfAddToCartPopupAppears(), true);

        // on Add to Cart popup click on View cart button
        productDetailsPage.clickOnViewCartButtonAddToCartPopup();
        checkAcceptanceCriteria("Shopping cart isn't shown", shoppingCartPage.isItShoppingCartPage(), true);

        // on shopping cart page remove all products
        shoppingCartPage.removeAllProductsFromCart();
        checkAcceptanceCriteria("Empty shopping cart isn't shown", shoppingCartPage.isItEmptyShoppingCart(), true);
    }
}
