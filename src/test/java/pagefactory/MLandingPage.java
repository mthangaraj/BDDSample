package pagefactory;

import actions.IOSActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class MLandingPage {

    WebDriver driver;
    static Properties landingProps = new Properties();

    public MLandingPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

        try{
            InputStream inputStream = new FileInputStream(System.getProperty("user.dir")+ File.separator+"src"+File.separator+"main"+ File.separator+"java"+File.separator+"locators"+File.separator+"muster_landing_locators.properties");
            landingProps.load(inputStream);
            inputStream.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public MLoginPage acceptTermsAndCondition(){
        String actaul = null;
        try{
            IOSActions.actionClick(driver, landingProps.getProperty("proceed"));

        }catch(Exception e){
            e.printStackTrace();
        }
        return new MLoginPage(driver);
    }

}
