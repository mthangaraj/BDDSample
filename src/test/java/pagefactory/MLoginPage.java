package pagefactory;

import actions.IOSActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class MLoginPage {

    WebDriver driver;
    static Properties loginProps = new Properties();

    public MLoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

        try{
            InputStream inputStream = new FileInputStream(System.getProperty("user.dir")+ File.separator+"src"+File.separator+"main"+ File.separator+"java"+File.separator+"locators"+File.separator+"muster_login_locators.properties");
            loginProps.load(inputStream);
            inputStream.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public String login(){
        String actaul = null;
        try{
            IOSActions.actionClick(driver, loginProps.getProperty("alert_ok"));

        }catch(Exception e){
            e.printStackTrace();
        }
        return actaul;
    }

}
