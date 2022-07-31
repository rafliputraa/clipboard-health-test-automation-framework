package Base;

import Utility.ParamManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import Utility.ConstantVariables;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver  = null;

    public static WebDriverWait wait;

    public static Logger logger;

    public static WebDriver initilize() throws MalformedURLException {

        ParamManager paramManager = new ParamManager();
        paramManager.setParameter("browser");

        String browserName = ConstantVariables.browserName;
        //Use Of Singleton Concept and Initilize webDriver
        if(driver == null)
        {
            if(browserName.equalsIgnoreCase("chrome"))
            {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            else if(browserName.equalsIgnoreCase("chrome-headless"))
            {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors","--disable-extensions","--no-sandbox","--disable-dev-shm-usage");
                driver=new ChromeDriver(options);
            }
            else if(browserName.equalsIgnoreCase("firefox"))
            {
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
            }
            else if(browserName.equalsIgnoreCase("firefox-headless"))
            {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--headless");
                options.addArguments("--disable-web-security");
                options.addArguments("--allow-running-insecure-content");
                driver=new FirefoxDriver(options);
            }
            else if(browserName.equalsIgnoreCase("internet-explorer"))
            {
                WebDriverManager.iedriver().setup();
                driver=new EdgeDriver();
            }
        }

        //Define the logger
        logger = Logger.getLogger("EasyLogger");
        logger.debug("Browser: " + browserName);

        //Perform Basic Operations
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return driver;
    }
    public static void quit()
    {
        driver.quit();
        driver=null; // to destroy the driver object after quit operation
    }
    public void close()
    {
        driver.close();
        driver=null;  // to destroy the driver object after quit operation
    }
    public static void openurl(String URL)
    {
        driver.get(URL);
    }
}
