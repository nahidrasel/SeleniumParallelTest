package PageObjectModel;

import Base.BaseTest;
import Utilities.pageUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class payeePage extends BaseTest {
    pageUtils p;

    public payeePage(WebDriver driver) {
        super(driver);
        p = new pageUtils(driver);
    }

    @FindBy(css = ".CustomSection button.js-add-payee")
    private WebElement addPayeeButton;
    @FindBy(css = ".CustomPage-heading > .Language__container")
    private WebElement payeesHeader;

    @FindBy(css = "[placeholder='Search payees']")
    private WebElement SearchPayeeInputBox;

    @FindBy(css = "#notification .message")
    private WebElement payeeAddedMessage;

    @FindBy(id = "ComboboxInput-apm-name")
    private WebElement payeeNameTextBox;
    @FindBy(id = "ComboboxList-apm-name")
    private WebElement someoneNewText;

    @FindBy(css = "[data-rv-value='account.bankCode']")
    private WebElement bankCode;
    @FindBy(css = "[data-rv-value='account.branchCode']")
    private WebElement branchCode;
    @FindBy(css = "[data-rv-value='account.accountNumber']")
    private WebElement accountNumber;
    @FindBy(css = "[data-rv-value='account.suffix']")
    private WebElement suffix;

    @FindBy(css = ".js-submit")
    private WebElement add;


    public boolean verifyPayeeHeaderText() {

        p.waitForElementToDisplay(payeesHeader, "Payee Header", 10, 3);
        payeesHeader.click();
        System.out.println(payeesHeader.getText());
        Assert.assertEquals(payeesHeader.getText(), "Payees");
        return true;
    }

    public void clickOnAddPayee() {
        addPayeeButton.click();
    }

    public void addPayeeNotification() {
        p.waitForElementToDisplay(payeeAddedMessage, "Payee Added Message", 10, 2);
        Assert.assertEquals(payeeAddedMessage.getText(), "Payee added");
    }

    public void addPayee(String payeeName, String BankCode, String BranchCode, String AccountNumber, String Suffix) {
        if (payeeNameTextBox.isDisplayed()) {
            payeeNameTextBox.sendKeys(payeeName);
            someoneNewText.isDisplayed();
            someoneNewText.click();

            bankCode.sendKeys(BankCode);
            branchCode.sendKeys(BranchCode);
            accountNumber.sendKeys(AccountNumber);
            suffix.sendKeys(Suffix);
            add.click();
        }
    }

    public void enterPayeeName(String pyName) {

        payeeNameTextBox.click();
        payeeNameTextBox.sendKeys(pyName);
    }

    public void clickOnAddPayeeButton() {
        addPayeeButton.click();
    }
}