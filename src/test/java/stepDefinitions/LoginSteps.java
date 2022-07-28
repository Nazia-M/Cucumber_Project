package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;

public class Steps extends BaseClass{

    @Given("User Launch Chrome browser")
    public void user_Launch_Chrome_browser() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + ".//Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        lp = new LoginPage(driver);
    }

    @When("User opens URL {string}")
    public void user_opens_URL(String url) throws InterruptedException {
        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(5000);
    }

    @When("User enters Email as {string} and Password as {string}")
    public void user_enters_Email_as_and_Password_as(String email, String password) {
        lp.setUserName(email);
        lp.setPassword(password);
    }

    @When("Click on Login")
    public void click_on_Login() throws InterruptedException {
        Thread.sleep(5000);
        lp.clickLogin();
    }

    @Then("Page Title should be {string}")
    public void page_Title_should_be(String title) {
        if (driver.getPageSource().contains("Login was unsuccessful"))
        {
            driver.close();
            Assert.assertTrue(false);
        }
        else
        {
            Assert.assertEquals(title, driver.getTitle());
        }
    }

    @When("User click on Log out link")
    public void user_click_on_Log_out_link() {
        lp.clickLogout();
    }

    @Then("close browser")
    public void close_browser() {
        driver.quit();

    }

    //Customers feature step definitions
    @Then("User can view Dashboard")
    public void user_can_view_dashboard() {
        addCust = new AddCustomerPage(driver);
        Assert.assertEquals("Dashboard / nopCommerce administration",addCust.getPageTitle());
    }
    @When("User clicks on Customers Menu")
    public void user_clicks_on_customers_menu() {
        addCust.clickOnCustomerMenu();
        implicitWait(5);

    }
    @When("click on customers Menu Item")
    public void click_on_customers_menu_item() {
        addCust.clickOnCustomerMenuItem();
        implicitWait(5);
    }
    @When("click on Add new button")
    public void click_on_add_new_button() {
        addCust.clickOnAddNew();
        implicitWait(5);
    }

    @Then("User can view Add new customer page")
    public void user_can_view_add_new_customer_page() {
        Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getPageTitle());
    }
    @When("User enters customer info")
    public void user_enters_customer_info() {
        addCust.setEmail(randomString());
        addCust.setPassword("test123");
        addCust.setFirstName("Kiya");
        addCust.setLastName("Kim");
        addCust.setGender();
        addCust.setDOB("7/12/2022");
        addCust.setCompanyName("Hyundai");
        addCust.setTaxExempt();
//        addCust.setNewsLetter();

    }
//    @When("click on Save button")
//    public void click_on_save_button() {
//
//    }
//    @Then("User can view confirmation message {string}")
//    public void user_can_view_confirmation_message(String string) {
//    }

}