package stepDef;
import helper.Utility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import pages.WebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class WebStep {

    WebPage webPage;
    WebDriver driver;

    public WebStep() {
        this.driver = Utility.getDriver(); // Assume WebDriverManager manages WebDriver instances
        this.webPage = PageFactory.initElements(driver, WebPage.class);
    }

    @Given("open url {string}")
    public void openUrl(String url) {
        driver.get(url);
    }

    @And("user input username {string}")
    public void inputUsername(String username) {
        webPage.usernameField.sendKeys(username);
    }

    @And("user input password {string}")
    public void inputPassword(String password) {
        webPage.passwordField.sendKeys(password);
    }

    @Then("user click login button")
    public void clickLoginButton() {
        webPage.loginButton.click();
    }

    @Then("user should see the product list")
    public void verifyProductList() {
        assert webPage.productList.isDisplayed();
    }

    @Then("user should see an error message {string}")
    public void verifyErrorMessage(String errorMessage) {
        assert webPage.errorMessage.getText().equals(errorMessage);
    }

    @And("user selects {string} from the sorting dropdown")
    public void selectSortingOption(String option) {
        Select dropdown = new Select(webPage.sortingDropdown);
        dropdown.selectByVisibleText(option);
    }

    @Then("the products should be sorted in ascending order of price")
    public void verifyProductSorting() {
        // Placeholder for actual verification logic
    }

    @When("user click the {string} button for a product")
    public void clickButtonForProduct(String buttonName) {
        if (buttonName.equalsIgnoreCase("Add to cart")) {
            webPage.addToCartButton.click();
        } else if (buttonName.equalsIgnoreCase("Remove")) {
            webPage.removeButton.click();
        }
    }

    @Then("the cart icon should display the number {string}")
    public void verifyCartIcon(String itemCount) {
        assert webPage.cartIcon.getText().equals(itemCount);
    }

    @And("user click the cart icon")
    public void clickCartIcon() {
        webPage.cartIcon.click();
    }

    @And("user click the {string} button")
    public void clickButton(String buttonName) {
        switch (buttonName.toLowerCase()) {
            case "checkout":
                webPage.checkoutButton.click();
                break;
            case "continue":
                webPage.continueButton.click();
                break;
            case "burger":
                webPage.burgerButton.click();
                break;
            default:
                throw new IllegalArgumentException("Button not recognized: " + buttonName);
        }
    }

    @Then("user should be redirected to the checkout information page")
    public void verifyCheckoutPage() {
        assert driver.getCurrentUrl().contains("checkout-step-one.html");
    }

    @When("user enter {string} as the first name")
    public void enterFirstName(String firstName) {
        webPage.firstNameField.sendKeys(firstName);
    }

    @And("user enter {string} as the last name")
    public void enterLastName(String lastName) {
        webPage.lastNameField.sendKeys(lastName);
    }

    @And("user enter {string} as the postal code")
    public void enterPostalCode(String postalCode) {
        webPage.postalCodeField.sendKeys(postalCode);
    }

    @Then("user should see a confirmation message {string}")
    public void verifyConfirmationMessage(String message) {
        assert webPage.confirmationMessage.getText().equals(message);
    }

    @And("user click the Logout button")
    public void clickLogoutButton() {
        driver.findElement(By.id("logout_sidebar_link")).click();
    }

    @Then("user should be redirected to the login page")
    public void verifyLoginPage() {
        assert driver.getCurrentUrl().equals("https://www.saucedemo.com/");
    }


    @And("the product should appear in the cart")
    public void theProductShouldAppearInTheCart() {
        assert webPage.cartIcon.isDisplayed();
        String itemCount = webPage.cartIcon.getText();
        assert !itemCount.isEmpty() && Integer.parseInt(itemCount) > 0;
    }

    @When("user click the {string} button for that product on the inventory page")
    public void userClickTheButtonForThatProductOnTheInventoryPage(String buttonName) {
        if (buttonName.equalsIgnoreCase("Add to cart")) {
            webPage.addToCartButton.click();
        } else if (buttonName.equalsIgnoreCase("Remove")) {
            webPage.removeButton.click();
        } else {
            throw new IllegalArgumentException("Button not recognized: " + buttonName);
        }
    }

    @And("user click the {string} button on the checkout overview page")
    public void userClickTheButtonOnTheCheckoutOverviewPage(String buttonName) {
        webPage.finishButton.click();
    }

    @When("user leave the first name field empty")
    public void userLeaveTheFirstNameFieldEmpty() {
        webPage.firstNameField.clear();
        webPage.firstNameField.sendKeys("");
    }

}