package bnzTestCases;

import Base.BaseTest;
import org.testng.annotations.*;

public class TestCases extends BaseTest {

    public TestCases() {
        super();
    }

    @Test
    public void NavigationTest() throws InterruptedException {

        homepage.navigateTo("Payees");
        payeepage.verifyPayeeHeaderText();

    }

    @Test
    public void VerifyAddPayee() throws InterruptedException {

        homepage.navigateTo("Payees");
        payeepage.verifyPayeeHeaderText();
        payeepage.clickOnAddPayee();
        payeepage.addPayee("TestS", "03", "1404", "0004589", "0000");
        payeepage.addPayeeNotification();

    }

}
