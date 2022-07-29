package PageObject.Amazon;

import Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BrowseResult extends TestBase {

    public BrowseResult() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//span[@class='a-size-base a-color-base'][normalize-space()='Samsung']")
    private WebElement checkbox_filter_samsung;

    @FindBy(how = How.ID, using = "a-autoid-0-announce")
    private WebElement button_dropdown_sort_by;

    @FindBy(how = How.ID, using = "s-result-sort-select_2")
    private WebElement li_price_high_to_low;

    @FindBy(how = How.XPATH, using = "(//span[@class='a-price-whole'])[2]")
    private WebElement span_product_price;

    public void click_checkbox_filter_samsung() {
        checkbox_filter_samsung.click();
    }

    public void click_button_dropdown_sort_by() {
        button_dropdown_sort_by.click();
    }

    public void click_li_price_high_to_low() {
        li_price_high_to_low.click();
    }

    public void click_span_product_price() {
        span_product_price.click();
    }

}
