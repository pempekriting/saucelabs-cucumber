package steps;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.saucelabs.context.TestContext;
import org.saucelabs.pages.*;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class CheckoutSteps {

    private final ProductsPage productsPage;
    private final LoginPage loginPage;
    private final CheckoutPage checkoutPage;
    private final HeaderNavigation headerNavigation;
    private final MyCartPage myCartPage;
    List<String> listItemsInCart = new ArrayList<>();

    public CheckoutSteps(TestContext context) {
        productsPage = new ProductsPage(context);
        loginPage = new LoginPage(context);
        checkoutPage = new CheckoutPage(context);
        headerNavigation = new HeaderNavigation(context);
        myCartPage = new MyCartPage(context);
    }

    @Given("the app is launched")
    public void theAppIsLaunched() {
        Assert.assertTrue(headerNavigation.isCartDisplayed());
    }

    @And("the user is on the catalog")
    public void theUserIsOnTheCatalog() {
        Assert.assertTrue(productsPage.getHdrProduct().isDisplayed());
    }

    @When("the user adds {string} color {string} quantity {int} to the cart")
    public void theUserAddsColorQuantityQtyToTheCart(String productName, String color, Integer qty) {
        listItemsInCart.add(productName);
        productsPage.chooseProduct(productName)
                .chooseColor(color)
                .inputQty(qty)
                .andThenAddToCart();
    }

    @And("proceeds to checkout")
    public void proceedsToCheckout() {
        headerNavigation.clickCart();
        myCartPage.assertListItemsNameInCart(listItemsInCart);
        myCartPage.clickProceedToCheckoutButton();
    }

    @And("logs in with valid credentials")
    public void logsInWithValidCredentials() {
        loginPage.inputUsername()
                .inputPassword()
                .andLogin();
    }

    @And("provides shipping details")
    public void providesShippingDetails() {
        checkoutPage.inputFullName()
                .inputAddressLineOne()
                .inputCityName()
                .inputZipCode()
                .inputCountryName()
                .andClickToPaymentButton();
    }

    @And("provides payment details")
    public void providesPaymentDetails() {
        checkoutPage.inputFullNameCard()
                .inputCardNumber()
                .inputExpirationDate()
                .inputSecurityCode()
                .andClickReviewOrderButton();
    }
    @And("the order summary shows")
    public void theOrderSummaryShows() {
        myCartPage.assertTotalAmountInCheckout();
        checkoutPage.clickPlaceOrderButton();
    }

    @Then("the order is confirmed")
    public void theOrderIsConfirmed() {
        Assert.assertTrue(checkoutPage.isCheckoutCompleteBannerDisplayed());
    }
}
