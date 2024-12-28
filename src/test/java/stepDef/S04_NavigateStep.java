package stepDef;

import helper.Utility;
import helper.PageManager;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.P04_NavigatePage;

public class S04_NavigateStep {
    P04_NavigatePage navigationPage;
    PageManager pageManager;
    WebDriver driver;

    public S04_NavigateStep() {
        this.driver = Utility.getDriver();
        this.navigationPage = PageFactory.initElements(driver, P04_NavigatePage.class);
        this.pageManager = new PageManager(driver);
    }

    @And("user click the {string} button")
    public void clickNavigationButton(String buttonName) {
        pageManager.clickButton("burger");
    }

    @And("user click the Logout button")
    public void clickLogoutButton() {
        navigationPage.clickLogoutButton();
    }

}
