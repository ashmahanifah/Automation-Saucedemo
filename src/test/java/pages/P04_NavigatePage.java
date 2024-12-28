package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P04_NavigatePage {

    WebDriver driver;

    @FindBy(id = "react-burger-menu-btn")
    public WebElement burgerButton;

    public P04_NavigatePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickBurgerButton() {
        burgerButton.click();
    }

    public void clickLogoutButton() {
        driver.findElement(By.id("logout_sidebar_link")).click();
    }

}
