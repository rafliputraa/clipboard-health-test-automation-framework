package PageObject.Amazon;

import Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProductDetail extends TestBase {

    public ProductDetail() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//h1[normalize-space()='About this item']")
    private WebElement h1_label_description;

    public String getTextOfH1LabelDescription() {
        return h1_label_description.getText();
    }

}
