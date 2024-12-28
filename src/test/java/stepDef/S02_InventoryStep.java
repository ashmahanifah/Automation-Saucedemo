package stepDef;
import helper.PageManager;
import helper.Utility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.P02_InventoryPage;

public class S02_InventoryStep {
    P02_InventoryPage inventoryPage;
    PageManager pageManager;
    WebDriver driver;

    public S02_InventoryStep() {
        this.driver = Utility.getDriver();
        this.inventoryPage = PageFactory.initElements(driver, P02_InventoryPage.class);
        this.pageManager = new PageManager(driver);

    }

    @Then("user should see the product list")
    public void verifyProductList() {
        assert inventoryPage.isProductListDisplayed();
    }

    @And("user selects {string} from the sorting dropdown")
    public void selectSortingOption(String option) {
        inventoryPage.selectSortingOption(option);
    }

    @Then("the products should be sorted in ascending order of price")
    public void verifyProductSorting() {
        assert inventoryPage.isProductSortedByPrice();
    }

    @When("user click the {string} button for a product")
    public void clickButtonForProduct(String buttonName) {
        inventoryPage.clickButtonForProduct(buttonName);
    }

    @Then("the cart icon should display the number {string}")
    public void verifyCartIcon(String itemCount) {
        assert inventoryPage.getCartIconText().equals(itemCount);
    }

    @And("user click the cart icon")
    public void clickCartIcon() {
        inventoryPage.clickCartIcon();
    }

    @And("the product should appear in the cart")
    public void theProductShouldAppearInTheCart() {
        assert inventoryPage.isProductInCart();
    }


    @And("user click the {string} button on the inventory cart page")
    public void userClickTheButtonOnTheInventoryCartPage(String buttonName) {
        pageManager.clickButton("checkout");
    }
}