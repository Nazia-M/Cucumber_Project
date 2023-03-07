package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.testng.Assert;
import pageObjects.AddCustomerPage;
import utilities.LoggerHelper;

public class AddNewCustomer extends BaseClass{

    Logger log = LoggerHelper.getLogger(LoggerHelper.class);

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

        scrollToEnd();
        implicitWait(5000);
        log.info("scrollToEnd");

        addCust.setNewsLetter();
        implicitWait(5000);
        log.info("setNewsLetter");

//        addCust.customerRole("Administrators");
//        implicitWait(5000);
//        log.info("customerRole");

        implicitWait(3000);
        log.info("implicitWait");

//        addCust.managerOfVendor("Vendor 2");
//        implicitWait(5000);
//        log.info("managerOfVendor");

        implicitWait(3000);
        log.info("implicitWait");

        addCust.active();
        implicitWait(5000);
        log.info("active");

        addCust.adminComment("Request for Approval of the New Customer");
        implicitWait(5000);
        log.info("adminComment");

        scrollToTop();
        implicitWait(5000);
        log.info("scrollToTop");
    }

    @When("click on Save button")
    public void click_on_save_button() {
        addCust.save();
        log.info("save");
    }

    @Then("User can view confirmation message {string}")
    public void user_can_view_confirmation_message(String msg) {

        String msg1 = addCust.getSuccessfulText();

        if(msg1.contains(msg)){
            log.info("Success Message Confirmed");
        }
        else{
            log.info("Message is :"+msg1);
        }
        log.info("user_can_view_confirmation_message");

    }
}
