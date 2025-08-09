package org.saucelabs.pages;

import org.saucelabs.context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Objects;

public class ProductsPage extends BasePage {

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/productIV")
    private List<WebElement> listProducts;
    @FindBy(id = "com.saucelabs.mydemoapp.android:id/colorIV")
    private List<WebElement> listProductColors;
    @FindBy(id = "com.saucelabs.mydemoapp.android:id/plusIV")
    private WebElement btnPlusQty;
    @FindBy(id = "com.saucelabs.mydemoapp.android:id/cartBt")
    private WebElement btnAddToCart;
    @FindBy(id = "com.saucelabs.mydemoapp.android:id/productTV")
    private WebElement hdrProduct;

    public ProductsPage(TestContext context) {
        super(context);
    }

    public List<WebElement> getListProducts() {
        return listProducts;
    }

    public ProductsPage chooseProduct(String productName) {
        listProducts.stream().filter(element -> Objects.equals(getValueAttribute(element, "content-desc"), productName)).findFirst().get().click();
        return this;
    }

    public ProductsPage chooseColor(String colorName) {
        listProductColors.stream().filter(element -> Objects.equals(getValueAttribute(element, "content-desc"), colorName)).findFirst().get().click();
        return this;
    }

    public ProductsPage inputQty(int quantity) {
        if (quantity > 1) {
            for (int i = 0; i < quantity - 1; i++) {
                btnPlusQty.click();
            }
        }
        return this;
    }

    public void andThenAddToCart() {
        btnAddToCart.click();
    }

    public WebElement getHdrProduct() {
        return hdrProduct;
    }
}