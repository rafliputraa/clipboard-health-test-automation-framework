package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import Utility.ConstantVariables;
import org.openqa.selenium.firefox.FirefoxOptions;
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

        //Use Of Singleton Concept and Initilize webDriver
        if(driver == null)
        {
            if(ConstantVariables.browserName.equalsIgnoreCase("chrome"))
            {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            else if(ConstantVariables.browserName.equalsIgnoreCase("chrome-headless"))
            {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.setHeadless(true);
                driver=new ChromeDriver(options);
            }
            else if(ConstantVariables.browserName.equalsIgnoreCase("firefox"))
            {
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
            }
            else if(ConstantVariables.browserName.equalsIgnoreCase("firefox-headless"))
            {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions options = new FirefoxOptions();
                options.setHeadless(true);
                driver=new FirefoxDriver();
            }
            else if(ConstantVariables.browserName.equalsIgnoreCase("IE"))
            {
                WebDriverManager.iedriver().setup();
                driver=new EdgeDriver();
            }

            logger = Logger.getLogger("EasyLogger");

        }

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
