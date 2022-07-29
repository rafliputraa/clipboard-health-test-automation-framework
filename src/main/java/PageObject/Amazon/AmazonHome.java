package PageObject.Amazon;

import Base.TestBase;
import Utility.ConstantVariables;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AmazonHome extends TestBase {

    public AmazonHome() {
        ConstantVariables.URl = "https://www.amazon.in/";
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "nav-hamburger-menu")
    private WebElement btn_hamburger_menu;

    public void click_hamburger_menu() {
        btn_hamburger_menu.click();
        new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateTo_HomePage() {
        driver.get(ConstantVariables.URl);
    }
}
