package Utilities;

import Base.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import static java.lang.System.getProperty;
import static jdk.internal.org.jline.utils.Log.warn;
import static org.apache.commons.lang3.ThreadUtils.sleep;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;
import static sun.security.jgss.GSSToken.debug;
import static sun.security.ssl.SSLLogger.info;


public class pageUtils extends BaseTest {
    WebDriverWait wait;

    public pageUtils(WebDriver driver) {
        super(driver);
    }

    public void waitForElementToDisplay(WebElement element, String elementName, int timeOut, int attempts) {
        Boolean SuccessResult = false;
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        for (int i = 1; i <= attempts; i++) {
            try {
                System.out.println("Waiting for Element " + elementName + " to display for " + timeOut + " :Attempt " + i);
                wait.until(ExpectedConditions.visibilityOf(element));
                SuccessResult = true;
                break;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        if (!SuccessResult) {
            Assert.fail("Couldn't wait for element: " + element);
        }
    }

    public void waitForPageFullyLoaded() {
        waitForPageFullyLoaded(120);
    }

    public void waitForPageFullyLoaded(int seconds) {
        new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public void waitForElementToBePresent(WebElement element, String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(textToBePresentInElement(element, text));
        System.out.println(String.format("Wait for %s to be present to %s", 60));
    }

    public String getCurrentDateTime(String pattern) {
        //example of pattern: "yyyy-MM-dd'T'HH:mm:ss.SSSZ"

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, new Locale("en", "NZ"));
        String date = simpleDateFormat.format(new Date());
        return date;
    }

    public String getRandomString(int length) throws NoSuchAlgorithmException {
        char[] alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = SecureRandom.getInstanceStrong();
        for (int i = 0; i < length; i++) {
            char c = alphabets[random.nextInt(alphabets.length)];
            sb.append(c);
        }
        sb.replace(0, 1, String.valueOf(Character.toUpperCase(sb.charAt(0))));
        return sb.toString();
    }

    public void sendKeys(By by, String text, String elementName) {
        try {
            sendKeys((By) driver.findElement(by), text, elementName);
            debug("Text '" + text + "' entered in " + elementName + ".");
        } catch (WebDriverException e) {
            warn("sendKeys(" + elementName + ") failed");
        }
    }

    public void scrollIntoView(WebElement webElement, String webElementName) {
        info("Scrolling to move '" + webElementName + "' to the middle of the screen");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: \"center\"});", webElement);
    }

    public void waitElementToDisappear(WebElement webElement, int maxAttempts, String elementName) throws InterruptedException {
        while (isElementDisplayed(webElement) && maxAttempts > 0) {
            warn("Waiting for element " + elementName + " to disappear. Attempts remaining: " + maxAttempts);
            sleep(Duration.ofSeconds(1));
            maxAttempts--;
        }
    }

    public boolean isElementDisplayed(WebElement webElement) {
        try {
            return webElement.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void mouseOver(By webElement, String elementName) {
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(webElement);
        action.moveToElement(we).moveToElement(driver.findElement(webElement)).click().build().perform();
        debug("Element " + elementName + "clicked");
    }

    public void moveToElement(By webElement, String elementName) throws InterruptedException {
        sleep(Duration.ofSeconds(3));
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(webElement);
        action.moveToElement(we).moveToElement(driver.findElement(webElement)).build().perform();
        debug("Move to " + elementName);
    }

    public void waitForElementToClear(By webElement, String elementName, int TimeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TimeOutInSeconds));
        System.out.println(String.format("Wait for %s to disappear up to %s", elementName, TimeOutInSeconds));
        long startTime = System.currentTimeMillis();
        wait.until(invisibilityOfElementLocated(webElement));
        long durationMs = System.currentTimeMillis() - startTime;
        System.out.println(String.format("%s actually took %s milliseconds to disappear", elementName, durationMs));
    }

    public boolean itemIsSelected(By webElement) {
        if (driver.findElement(webElement).isSelected()) {
            System.out.println("Element is Selected");
            return true;
        } else {
            return false;
        }
    }

    public boolean itemIsEnabled(By webElement) {
        if (driver.findElement(webElement).isEnabled()) {
            System.out.println("Element is Enabled");
            return true;
        } else {
            return false;
        }
    }

    public boolean itemIsExisting(By webElement) {
        if (driver.findElements(webElement).size() != 0) {
            System.out.println("Element is Existing");
            return true;
        } else {
            return false;
        }
    }

    public void ClearInputForElement(By webElement) {
        String value = driver.findElement(webElement).getAttribute("value");
        int count = value.length();
        while (!(count == 0)) {
            driver.findElement(webElement).sendKeys(Keys.BACK_SPACE);
            count--;
        }
    }

    public void validateCompleteFileDownloaded(String currentFileName) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        String dloadFolderPath = getProperty("C:\\nahidpractice\\SeleniumJavaAutomationPack1\\ConfigFiles\\config.properties");
        System.out.println(dloadFolderPath);
        File DLOADFile = getLatestFileFromDirectory(dloadFolderPath);
        String expFName = DLOADFile.getName();
        System.out.println(expFName);
        File actualFile = new File(dloadFolderPath + expFName);
        System.out.println(actualFile);
        wait.until((ExpectedCondition<Boolean>) webDriver -> actualFile.exists());
        if (actualFile.exists())
            actualFile.delete();
        info("actualFile " + currentFileName + " has been downloaded Successfully");
    }

    private File getLatestFileFromDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();
        if (files == null || files.length == 0) {
            return null;
        }
        File lastModifiedFile = files[0];
        for (int i = 1; i < files.length; i++) {
            if (lastModifiedFile.lastModified() < files[i].lastModified()) {
                lastModifiedFile = files[i];
            }
    }
        return lastModifiedFile;
}
    public void pressTabButton() throws AWTException, InterruptedException {
        Robot rob = new Robot();
        rob.keyPress(KeyEvent.VK_TAB);
        rob.keyRelease(KeyEvent.VK_TAB);
        Thread.sleep(500);
    }
}
