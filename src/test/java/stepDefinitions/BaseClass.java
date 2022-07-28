package stepDefinitions;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;

import java.util.concurrent.TimeUnit;

public class BaseClass {
    public static WebDriver driver;
    public LoginPage lp;

    public AddCustomerPage addCust;

    //Created for generating ramdom String for unique email id
    public static  String randomString(){
        String generatedString = RandomStringUtils.randomAlphabetic(5);
        return(generatedString+"@gmail.com");
    }

    //Implicitly Wait
    public static void implicitWait(int timeInSecs){
        driver.manage().timeouts().implicitlyWait(timeInSecs, TimeUnit.SECONDS);
    }
}
