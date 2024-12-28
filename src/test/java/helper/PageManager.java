package helper;

import org.openqa.selenium.WebDriver;
import pages.P02_InventoryPage;
import pages.P03_CheckoutPage;
import pages.P04_NavigatePage;

public class PageManager {
    private final P04_NavigatePage navigatePage;
    private final P03_CheckoutPage checkoutPage;
    private final P02_InventoryPage inventoryPage;

    public PageManager(WebDriver driver) {
        this.navigatePage = new P04_NavigatePage(driver);
        this.checkoutPage = new P03_CheckoutPage(driver);
        this.inventoryPage = new P02_InventoryPage(driver);
    }

    public void clickButton(String buttonName) {
        switch (buttonName.toLowerCase()) {
            case "checkout":
                inventoryPage.clickCheckoutButton();
                break;
            case "continue":
                checkoutPage.clickContinueButton();
                break;
            case "burger":
                navigatePage.clickBurgerButton();
                break;
            default:
                throw new IllegalArgumentException("Button not recognized: " + buttonName);
        }
    }
}