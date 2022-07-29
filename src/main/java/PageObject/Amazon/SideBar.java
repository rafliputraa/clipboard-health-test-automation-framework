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

public class SideBar extends TestBase {

    public SideBar() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CSS, using = ".hmenu-item[data-menu-id='9']")
    private WebElement btn_tv_appliances_electronics;

    @FindBy(how = How.XPATH, using = "//a[normalize-space()='Televisions']")
    private WebElement btn_televisions;

    public void click_tv_appliances_electronics_button() {
        wait.until(ExpectedConditions.elementToBeClickable(btn_tv_appliances_electronics));
        btn_tv_appliances_electronics.click();
    }

    public void click_televisions_button() {
        wait.until(ExpectedConditions.elementToBeClickable(btn_televisions));
        btn_televisions.click();
    }
}
