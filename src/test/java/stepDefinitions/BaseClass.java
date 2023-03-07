package stepDefinitions;
//import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.*;

public class BaseClass {
    public static WebDriver driver;
    public static LoginPage lp;

    public AddCustomerPage addCust;

    JavascriptExecutor js = (JavascriptExecutor) driver;

    //Created for generating ramdom String for unique email id
    public static  String randomString(){
//        String generatedString = "ab";
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String generatedString = "";
        int length = 2;
        Random ran = new Random();
        char[] text = new char[length];
        for(int i=0;i<length;i++){
            text[i] = characters.charAt(ran.nextInt(characters.length()));
        }
        for(int i=0;i<text.length;i++){
            generatedString += text[i];
        }
        return(generatedString+"@gmail.com");
    }

    public static void implicitWait(int timeInSecs){
        driver.manage().timeouts().implicitlyWait(timeInSecs, TimeUnit.SECONDS);
    }

    public void scrollToEnd(){
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
    }

    public void scrollToTop(){
        js.executeScript("window.scrollBy(0,0)", "");
    }

}
