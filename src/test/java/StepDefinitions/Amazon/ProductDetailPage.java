package StepDefinitions.Amazon;

import Base.TestBase;
import PageObject.Amazon.AmazonHome;
import PageObject.Amazon.BrowseResult;
import PageObject.Amazon.ProductDetail;
import PageObject.Amazon.SideBar;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;

public class ProductDetailPage extends TestBase {

    private AmazonHome homePage;
    private SideBar sideBar;
    private BrowseResult browseResult;
    private ProductDetail productDetail;

    @Given("the user is on the Amazon Page")
    public void the_user_is_on_the_amazon_page() {
        homePage = new AmazonHome();
        homePage.navigateTo_HomePage();
        TestBase.logger.debug("the user is on the Amazon Page");
    }

    @When("he click on Hamburger Menu")
    public void he_click_on_hamburger_menu() {
        homePage.click_hamburger_menu();
        TestBase.logger.debug("he click on Hamburger Menu");
    }

    @When("click on TV, Appliances and Electronics under Shop by Department sections")
    public void click_on_tv_appliances_and_electronics_under_shop_by_department_sections() {
        sideBar = new SideBar();
        sideBar.click_tv_appliances_electronics_button();
        TestBase.logger.debug("click on TV, Appliances and Electronics under Shop by Department sections");
    }

    @When("click on Televisions under Tv, Audio & Cameras sub sections")
    public void click_on_televisions_under_tv_audio_cameras_sub_sections() {
        sideBar.click_televisions_button();
        TestBase.logger.debug("click on Televisions under Tv, Audio & Cameras sub sections");
    }

    @When("check the filter for Brand Samsung")
    public void check_the_filter_for_brand_samsung() {
        browseResult = new BrowseResult();
        browseResult.click_checkbox_filter_samsung();
        TestBase.logger.debug("check the filter for Brand Samsung");
    }

    @When("sort the filter result with price from high to low")
    public void sort_the_filter_result_with_price_from_high_to_low() {
        browseResult.click_button_dropdown_sort_by();
        browseResult.click_li_price_high_to_low();
        TestBase.logger.debug("sort the filter result with price from high to low");
    }

    @When("click the second highest priced item")
    public void click_the_second_highest_priced_item() {
        browseResult.click_span_product_price();
        TestBase.logger.debug("click the second highest priced item");
    }

    @When("switch to the product detail opened in new tab")
    public void switch_to_the_product_detail_opened_in_new_tab() {
        ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        TestBase.logger.debug("switch to the product detail opened in new tab");
    }

    @Then("the detail product section named with {string}")
    public void the_detail_product_section_named_with(String string) {
        productDetail = new ProductDetail();
        logger.debug("the detail product section named with: " + productDetail.getTextOfH1LabelDescription());
        Assert.assertEquals("About this item", productDetail.getTextOfH1LabelDescription());
    }
}
