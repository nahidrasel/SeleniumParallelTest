package Reporting;

import Base.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class ExtentReport{
    public static WebDriver driver;

    public ExtentReport(WebDriver driver) {
        super();
    }

    public static void screenshotCapture(){
        try{
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDirectory = System.getProperty("user.dir");
        FileUtils.copyFile(scrFile, new File(currentDirectory + "/screenshots/" + System.currentTimeMillis() + ".png"));
    }
        catch (Exception e) {
        e.printStackTrace();
    }
    }
}
