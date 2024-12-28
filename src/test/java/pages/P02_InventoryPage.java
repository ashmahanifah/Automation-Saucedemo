package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class P02_InventoryPage {
    WebDriver driver;

    @FindBy(className = "inventory_list")
    public WebElement productList;

    @FindBy(className = "product_sort_container")
    public WebElement sortingDropdown;

    @FindBy(xpath = "//button[text()='Add to cart']")
    public WebElement addToCartButton;

    @FindBy(xpath = "//button[text()='Remove']")
    public WebElement removeButton;

    @FindBy(className = "shopping_cart_badge")
    public WebElement cartIcon;

    @FindBy(css = ".inventory_item_price")
    List<WebElement> productPrices;

    @FindBy(id = "checkout")
    public WebElement checkoutButton;

    public P02_InventoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isProductListDisplayed() {
        return productList.isDisplayed();
    }

    public void selectSortingOption(String option) {
        Select dropdown = new Select(sortingDropdown);
        dropdown.selectByVisibleText(option);
    }

    public List<Double> getProductPrices() {
        List<Double> prices = new ArrayList<>();
        for (WebElement priceElement : productPrices) {
            String priceText = priceElement.getText().replace("$", "");
            prices.add(Double.parseDouble(priceText));
        }
        return prices;
    }


    public boolean isProductSortedByPrice() {
        List<Double> prices = getProductPrices();
        List<Double> sortedPrices = prices.stream().sorted().toList();
        return prices.equals(sortedPrices);
    }

    public void clickButtonForProduct(String buttonName) {
        if (buttonName.equals("Add to cart")) {
            addToCartButton.click();
        } else if (buttonName.equals("Remove")) {
            removeButton.click();
        } else {
            throw new IllegalArgumentException("Button not recognized: " + buttonName);
        }
    }

    public String getCartIconText() {
        return cartIcon.getText();
    }

    public void clickCartIcon() {
        cartIcon.click();
    }

    public boolean isProductInCart() {
        return cartIcon.isDisplayed() && !cartIcon.getText().isEmpty() && Integer.parseInt(cartIcon.getText()) > 0;
    }

    public void clickCheckoutButton() {
        checkoutButton.click();
    }

}

