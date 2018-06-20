package scriptrunner;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import drivers.DriverUtil;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pagefactory.*;

import java.util.List;


public class ScriptRunnerOne {

    WebDriver driver;


    //Espresso login check
    @Given("^Launch chrome dirver (.*)$")
    public void initialize(String driverPropertiesName){
        driver = DriverUtil.getDriver(driverPropertiesName);
    }

    @And("^login with multiple Username and Password$")
    public void run(DataTable inputTable){
        try{

            List<List<String>> data = inputTable.raw();

            LoginPage loginPage = new LoginPage(driver);

            for(int rowCount = 0; rowCount<data.size(); rowCount++){

                loginPage.actionClearInputsInLoginPage();
                loginPage.actionLoginCheckWithMultipleInpputs(data.get(rowCount).get(0), data.get(rowCount).get(1));
                Thread.sleep(3000);

            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Then("^Close chrome$")
    public void verify(){
        driver.quit();
    }


}
