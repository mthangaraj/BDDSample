package scriptrunner;

import actions.CommonActions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import drivers.DriverUtil;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pagefactory.*;
import util.Utility;


public class ScriptRunner {

    WebDriver driver;


    //Espresso login check
    @Given("^Launch chrome browser (.*)$")
    public void initialize2(String driverPropertiesName){
        driver = DriverUtil.getDriver(driverPropertiesName);
    }

    @When("^Fill Manual Form and verify the text (.*)$")
    public void run2(String expected){
        String actual = null;
        try{
            LoginPage loginPage = new LoginPage(driver);
            IntroPage introPage = loginPage.login();
            AccountTypePage accountTypePage = introPage.clickStartSetup();
            ManualFormPage manualFormPage = accountTypePage.chooseManualAccountType();
            actual = manualFormPage.fillManualForm();

            CommonActions.assertEqualsWithGivenText(expected, actual);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Then("^Close chrome driver$")
    public void verify2(){
        driver.quit();
    }






    //@WhatsAppRegister
    @Given("^Launch the whatsapp application (.*)$")
    public void initialize(String driverPropertiesName){
        driver = DriverUtil.getDriver(driverPropertiesName);
    }

    @When("^Accept the T&C and proceed registration$")
    public void run(){
        String actaulStatus = null;
        try{
            WhatsAppRegisterPage loginPage = new WhatsAppRegisterPage(driver);
            actaulStatus = loginPage.validateNavigation();

            CommonActions.assertEqualsWithGivenText("Successfully navigated", actaulStatus);

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    @Then("^Close the driver$")
    public void verify(){
        driver.quit();
    }




    //@WhatsAppRe-Register
    @Given("^Launch app (.*)$")
    public void initialize1(String driverPropertiesName){
        driver = DriverUtil.getDriver(driverPropertiesName);
    }

    @When("^Accept t&c and verify the text for (.*)$")
    public void run1(String expected){
        String actual = null;
        try{
            WhatsAppRegisterPage loginPage = new WhatsAppRegisterPage(driver);
            actual = loginPage.validateNavigation();
            CommonActions.assertEqualsWithGivenText(expected, actual);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Then("^terminate the driver$")
    public void verify1(){
        driver.quit();
    }




    //Muster login
    @Given("^Launch the muster application (.*)$")
    public void initialize3(String driverPropertiesName){
        driver = DriverUtil.getDriver(driverPropertiesName);
    }

    @When("^Accept the TC and click proceed button$")
    public void run3(){
        MLoginPage musterLoginPage;
        try{
            MLandingPage musterLandingPage = new MLandingPage(driver);
            musterLoginPage = musterLandingPage.acceptTermsAndCondition();
            musterLoginPage.login();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Then("^Close the muster driver$")
    public void verify3(){
        driver.quit();
    }


}
