package stepDefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.LoginPage;

import java.awt.*;
import java.util.List;

public class LoginSteps extends BaseClass{

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
        Thread.sleep(2000);
    }

    @When("User enters Email as {string} and Password as {string}")
    public void user_enters_Email_as_and_Password_as(String email, String password) {
        lp.setUserName(email);
        lp.setPassword(password);
    }

    @When("User enters Email as email and Password as pass")
    public void user_enters_email_as_email_and_password_as_pass(io.cucumber.datatable.DataTable dataTable) {
        List<List<String>> data = dataTable.asLists();
        String email = data.get(0).get(0);
        String password = data.get(0).get(1);
        lp.setUserName(email);
        lp.setPassword(password);
    }

    @When("Click on Login")
    public void click_on_Login() throws InterruptedException {
        Thread.sleep(2000);
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


}