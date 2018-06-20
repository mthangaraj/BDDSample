package pagefactory;

import actions.WebActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by ionixx on 4/26/18.
 */
public class LoginPage {

    WebDriver driver;
    static Properties loginLocatorProps = new Properties();
    static Properties loginInputProps = new Properties();

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

        try{
            InputStream locatorStream = new FileInputStream(System.getProperty("user.dir")+ File.separator+"src"+File.separator+"main"+ File.separator+"java"+File.separator+"locators"+File.separator+"login_locators.properties");
            InputStream inputStream = new FileInputStream(System.getProperty("user.dir")+ File.separator+"src"+File.separator+"main"+ File.separator+"java"+File.separator+"userinputs"+File.separator+"login_inputs.properties");
            loginLocatorProps.load(locatorStream);
            loginInputProps.load(inputStream);
            inputStream.close();
            locatorStream.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public IntroPage login(){

        try{
            WebActions.actionEnterText(driver, loginLocatorProps.getProperty("username"), loginInputProps.getProperty("username"));
            WebActions.actionEnterText(driver, loginLocatorProps.getProperty("password"), loginInputProps.getProperty("password"));
            WebActions.actionClick(driver, loginLocatorProps.getProperty("login"));
        }catch(Exception e){
            e.printStackTrace();
        }

        return new IntroPage(driver);
    }

    public void actionLoginCheckWithMultipleInpputs(String username, String password){

        try{
            WebActions.actionEnterText(driver, loginLocatorProps.getProperty("username"), username);
            WebActions.actionEnterText(driver, loginLocatorProps.getProperty("password"), password);
            WebActions.actionClick(driver, loginLocatorProps.getProperty("login"));
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public void actionClearInputsInLoginPage(){
        try{
            WebActions.actionClearText(driver,loginLocatorProps.getProperty("username"));
            WebActions.actionClearText(driver,loginLocatorProps.getProperty("password"));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
