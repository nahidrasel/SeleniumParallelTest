package Utilities;

import Base.BaseTest;
import Reporting.ExtentReport;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebDriverEventListener extends BaseTest implements org.openqa.selenium.support.events.WebDriverEventListener {
    public WebDriverEventListener(WebDriver driver) {
        super();
    }

    public void beforeNavigateTo(String url, WebDriver driver) {
        System.out.println("Test Started to load : '" + url + "'");
    }

    public void afterNavigateTo(String url, WebDriver driver) {
        System.out.println("Navigated to:'" + url + "'");
    }

    public void beforeChangeValueOf(WebElement element, WebDriver driver) {
        System.out.println("Value of the:" + element.toString() + " before any changes made");
    }

    public void afterChangeValueOf(WebElement element, WebDriver driver) {
        System.out.println("Element value changed to: " + element.toString());
    }

    public void beforeClickOn(WebElement element, WebDriver driver) {
        System.out.println("Trying to click on: " + element.toString());
    }

    public void afterClickOn(WebElement element, WebDriver driver) {
        System.out.println("Clicked on: " + element.toString());
    }

    public void beforeNavigateBack(WebDriver driver) {
        System.out.println("Navigating back to previous page");
    }

    public void afterNavigateBack(WebDriver driver) {
        System.out.println("Navigated back to previous page");
    }

    public void beforeNavigateForward(WebDriver driver) {
        System.out.println("Navigating forward to next page");
    }

    public void afterNavigateForward(WebDriver driver) {
        System.out.println("Navigated forward to next page");
    }

    public void onException(Throwable error, WebDriver driver) {
        System.out.println("Exception occurred: " + error);
        //ExtentReport.screenshotCapture();
    }

    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("Trying to find Element By : " + by.toString());
    }

    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("Found Element By : " + by.toString());
    }


    public void beforeScript(String script, WebDriver driver) {
        System.out.println("Trying to execute script : " + script.toString());
    }

    public void afterScript(String script, WebDriver driver) {
        System.out.println("Execute script : " + script.toString());
    }

    public void beforeAlertAccept(WebDriver driver) {


    }

    public void afterAlertAccept(WebDriver driver) {


    }

    public void afterAlertDismiss(WebDriver driver) {


    }

    public void beforeAlertDismiss(WebDriver driver) {


    }

    public void beforeNavigateRefresh(WebDriver driver) {


    }

    public void afterNavigateRefresh(WebDriver driver) {


    }

    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {


    }

    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {


    }

    public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1) {


    }

    public void afterGetText(WebElement arg0, WebDriver arg1, String arg2) {


    }

    public void afterSwitchToWindow(String arg0, WebDriver arg1) {


    }

    public <X> void beforeGetScreenshotAs(OutputType<X> arg0) {


    }

    public void beforeGetText(WebElement arg0, WebDriver arg1) {


    }

    public void beforeSwitchToWindow(String arg0, WebDriver arg1) {


    }


}
