package runner;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.junit.runner.RunWith;
import org.testng.annotations.*;
import util.Utility;

import java.io.File;
import java.lang.management.ManagementFactory;

//@CucumberOptions(features = {"src/main/resources/features"}, tags = {"~@ignored"}, glue = {"scriptrunner"},
@CucumberOptions(features = {"src/test/resources/features"}, tags = {"@Fourth"}, glue = {"scriptrunner"},
                plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/output/report.html"},
                monochrome = false)


public class TestRunner {

    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass
    public void before() {

        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());

    }

    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());

        Reporter.loadXMLConfig(System.getProperty("user.dir")+ File.separator+"src" +
                File.separator+"main"+File.separator+"resources"+File.separator+"extent-config");

        Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
        Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
        Reporter.setSystemInfo("Machine", 	"Ubuntu" + "64 Bit");
        Reporter.setSystemInfo("Selenium", "2.53");
        Reporter.setSystemInfo("Maven", "3.5.2");
        Reporter.setSystemInfo("Java Version", "1.8");
    }

    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }

    @AfterClass
    public void sendMail()
    {
        testNGCucumberRunner.finish();
    }

    @AfterSuite
    public void test(){
        //to send test report mail
        Utility.sendTestReportMail();
    }
}

