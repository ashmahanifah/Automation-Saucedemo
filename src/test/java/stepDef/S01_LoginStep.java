package stepDef;

import helper.Utility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.P01_LoginPage;

public class S01_LoginStep {

    P01_LoginPage loginPage;
    WebDriver driver;

    public S01_LoginStep() {
        this.driver = Utility.getDriver();
        this.loginPage = PageFactory.initElements(driver, P01_LoginPage.class);
    }

    @Given("open url {string}")
    public void openUrl(String url) {
        driver.get(url);
    }

    @And("user input username {string}")
    public void inputUsername(String username) {
        loginPage.inputUsername(username);
    }

    @And("user input password {string}")
    public void inputPassword(String password) {
        loginPage.inputPassword(password);
    }

    @Then("user click login button")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("user should see an error message {string}")
    public void verifyErrorMessage(String errorMessage) {
        assert loginPage.getErrorMessage().equals(errorMessage);
    }

    @Then("user should be redirected to the login page")
    public void verifyLoginPage() {
        assert loginPage.isLoginPageDisplayed();
    }


}
