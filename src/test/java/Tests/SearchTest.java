package Tests;

import PageObjects.HomePage;
import PageObjects.OrderConfirmationPage;
import PageObjects.SearchResults;
import PageObjects.ShoppingCartSummary;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SearchTest extends BaseTest {

    private String wrongNameProduct = "";

    @Test
    public void addOneProductToCartAndCreatneNewAccount() {
        HomePage homePage = new HomePage(driver).goTo(configuration.getBaseUrl());
        ShoppingCartSummary shoppingCartSummary = homePage.findProductInSearch(testData.getProduct().getProductName()).chooseProductFromSearchResult().addToCartAndConfirmProduct();
        int productsAmount = shoppingCartSummary.getHowManyProductsAreInCart();

        OrderConfirmationPage orderConfirmationPage = shoppingCartSummary.confirmSummary()
                .createNewEmail().chooseTitle()
                .chooseTitle()
                .createNewAccount(testData.getUser().getName(), testData.getUser().getLastName(), testData.getUser().getPassword(), testData.getUser().getStreet()
                        , testData.getUser().getCity(), testData.getUser().getPostalCode(), testData.getUser().getMobilePhone())
                .clickProccedButton()
                .AcceptTermsAndClickProcceedButton()
                .payByBankWire()
                .confirmMyOrder();

        Assertions.assertAll("Checking order summary",
                () -> Assertions.assertEquals(29.0, orderConfirmationPage.getTotalAmount(),
                        "Total price of product is not what expected. Expected 29.0, but was..."),
                () -> Assertions.assertEquals(1, productsAmount, "Quantity of the product is not what expected. Expected: 11, but was ")
        );
    }

    @Test
    public void findProductWithWrongName() {
        HomePage homePage = new HomePage(driver).goTo(configuration.getBaseUrl());
        SearchResults searchResults = homePage.findProductInSearch(testData.getProduct().getWrongProductName());
        Assertions.assertEquals("No results were found for your search "  + "\"" + testData.getProduct().getWrongProductName() + "\"" , searchResults.getTextFromAlert(),
                "No results message wasn't found");
    }

}
