package Base;

import PageObjectModel.*;
import Utilities.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.time.Duration;


public class BaseTest {
    public WebDriver driver;
    private String browserName;
    protected homePage homepage;
    protected payeePage payeepage;
    public PropertyUtils pro;
    public EventFiringWebDriver eventFiringWebdriver;
    public WebDriverEventListener WebdriverEventListener;

    public BaseTest(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public BaseTest() {

        pro = new PropertyUtils();
    }
    @Parameters("browser")
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) {
        browserName= browser;
        driverInitialization();

        homepage = new homePage(driver);
        payeepage = new payeePage(driver);
    }

    public void driverInitialization() throws RuntimeException {
        if (driver == null) {
            try {
                pro.PropertiesReader();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        if (browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
        } else if (browserName.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (pro.pro.getProperty("browser").equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else if (pro.pro.getProperty("browser").equalsIgnoreCase("safari")) {
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
        }
        eventFiringWebdriver = new EventFiringWebDriver(driver);
        WebdriverEventListener = new WebDriverEventListener(driver);
        eventFiringWebdriver.register(WebdriverEventListener);
        driver = eventFiringWebdriver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(pro.pro.getProperty("testUrl"));
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
        System.out.println("Tear down Successfully completed");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
