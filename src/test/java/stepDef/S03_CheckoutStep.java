package stepDef;
import helper.PageManager;
import helper.Utility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.P03_CheckoutPage;

public class S03_CheckoutStep {

    P03_CheckoutPage checkoutPage;
    PageManager pageManager;
    WebDriver driver;

    public S03_CheckoutStep() {
        this.driver = Utility.getDriver();
        this.checkoutPage = PageFactory.initElements(driver, P03_CheckoutPage.class);
        this.pageManager = new PageManager(driver);
    }

    @Then("user should be redirected to the checkout information page")
    public void verifyCheckoutPage() {
        assert driver.getCurrentUrl().contains("checkout-step-one.html");
    }

    @When("user enter {string} as the first name")
    public void enterFirstName(String firstName) {
        checkoutPage.enterFirstName(firstName);
    }

    @And("user enter {string} as the last name")
    public void enterLastName(String lastName) {
        checkoutPage.enterLastName(lastName);
    }

    @And("user enter {string} as the postal code")
    public void enterPostalCode(String postalCode) {
        checkoutPage.enterPostalCode(postalCode);
    }

    @Then("user should see a confirmation message {string}")
    public void verifyConfirmationMessage(String message) {
        assert checkoutPage.getConfirmationMessage().equals(message);
    }

    @And("user click the {string} button on the checkout overview page")
    public void clickFinishButton(String buttonName) {
        checkoutPage.clickFinishButton();
    }

    @When("user leave the first name field empty")
    public void leaveFirstNameEmpty() {
        checkoutPage.enterFirstName("");
    }

    @And("user click the {string} button on the checkout page")
    public void userClickTheButtonOnTheCheckoutPage(String buttonName) {
        pageManager.clickButton("continue");
    }
}
