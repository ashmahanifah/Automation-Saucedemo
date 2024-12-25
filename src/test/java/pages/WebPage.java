package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class WebPage {

    @FindBy(id = "user-name")
    public WebElement usernameField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(id = "login-button")
    public WebElement loginButton;

    @FindBy(className = "inventory_list")
    public WebElement productList;

    @FindBy(css = ".error-message-container")
    public WebElement errorMessage;

    @FindBy(className = "product_sort_container")
    public WebElement sortingDropdown;

    @FindBy(xpath = "//button[text()='Add to cart']")
    public WebElement addToCartButton;

    @FindBy(xpath = "//button[text()='Remove']")
    public WebElement removeButton;

    @FindBy(className = "shopping_cart_badge")
    public WebElement cartIcon;

    @FindBy(id = "checkout")
    public WebElement checkoutButton;

    @FindBy(id = "first-name")
    public WebElement firstNameField;

    @FindBy(id = "last-name")
    public WebElement lastNameField;

    @FindBy(id = "postal-code")
    public WebElement postalCodeField;

    @FindBy(id = "continue")
    public WebElement continueButton;

    @FindBy(id = "finish")
    public WebElement finishButton;

    @FindBy(css = ".complete-header")
    public WebElement confirmationMessage;

    @FindBy(id = "react-burger-menu-btn")
    public WebElement burgerButton;

}
