package PageObjectModel;

import Base.BaseTest;
import Utilities.pageUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class homePage extends BaseTest {
    pageUtils p;
    public homePage(WebDriver driver) {
        super(driver);
        p = new pageUtils(driver);
    }

    @FindBy(css = ".js-main-menu-btn.MenuButton")
    private static WebElement menuButton;

    @FindBy(xpath = "//*[@id=\"left\"]/div[1]/div/div[3]/section/div[2]/nav[1]/ul/li[3]/a/span")
    private static WebElement menuItems;
    @FindBy(xpath = "//*[@id=\"account-ACC-1\"]/div[2]/span[1]/h3")
    private static WebElement everyDayLabel;

    @FindBy(xpath = "//span[contains(text(),'Transfer successful')]")
    private WebElement transferSuccessfullMessage;

    @FindBy(xpath = "//span[contains(text(),'Payees')]")
    private WebElement payeeMenuButton;

    @FindBy(xpath = "//span[contains(text(),'Pay or transfer')]")
    private WebElement payOrTransferMenuButton;

    @FindBy(xpath = "//*[@id=\"account-ACC-5\"]/div[2]/span[3]")
    private WebElement getBillAccountBalance;

    @FindBy(xpath = "//*[@id=\"account-ACC-1\"]/div[2]/span[3]")
    private WebElement getEveryDayAccountBalance;

    public void navigateTo(String text) {
        p.waitForElementToDisplay(menuButton, "Menu Button", 10, 3);
        menuButton.click();
        p.waitForElementToDisplay(menuItems, "Menu Items", 10, 3);
        menuItems.click();

        //menuItems.stream().filter(i -> i.getText().equals(text)).findFirst().get().click();
    }

}

