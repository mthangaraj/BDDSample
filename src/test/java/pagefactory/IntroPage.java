package pagefactory;

import actions.WebActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by ionixx on 5/7/18.
 */
public class IntroPage {

    WebDriver driver;
    static Properties introLocatorProps = new Properties();

    public IntroPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

        try{
            InputStream introLocatorStream = new FileInputStream(System.getProperty("user.dir")+ File.separator+"src"+File.separator+"main"+ File.separator+"java"+File.separator+"locators"+File.separator+"intro_locators.properties");
            introLocatorProps.load(introLocatorStream);
            introLocatorStream.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public AccountTypePage clickStartSetup(){

        try{
            //Wait for 3 seconds
            WebActions.actionWaitForGivenTime(driver, 6000);

            //To close save password popup
            WebActions.actionPressEscapeKey(driver);
            WebActions.actionPressEscapeKey(driver);

            WebActions.actionClick(driver, introLocatorProps.getProperty("start_setup"));

        }catch(Exception e){
            e.printStackTrace();
        }

        return new AccountTypePage(driver);
    }
}
