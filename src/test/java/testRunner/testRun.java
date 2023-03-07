package testRunner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
(
                features = ".//Features",
                glue="stepDefinitions",
                dryRun=false,
                monochrome=false,
                plugin= {"pretty",
                        "html:target/cucumber-reports/cucumber-html-report.html",
                        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
//                tags = "@qaEnv and not @ProdEnv and @dataTable"
)
public class testRun extends AbstractTestNGCucumberTests {
}
