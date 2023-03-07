package stepDefinitions;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.LoginPage;
public class Hooks extends BaseClass{

//    @Before("@qaEnv")
    @Before()
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + ".//Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        lp = new LoginPage(driver);

    }

    @AfterStep
    public void screenShot(Scenario scenario){

        byte[] fileContent = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(fileContent, "image/png", "pic1");

    }

    @After
    public static void tearDown(Scenario scenario){

        if(scenario.isFailed()){
            System.out.println("Failed");
        }
        driver.quit();
    }

}
