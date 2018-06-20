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
public class AccountTypePage {

    WebDriver driver;
    static Properties accountTypeLocatorProps = new Properties();

    public AccountTypePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

        try{
            InputStream accountTypeLocatorStream = new FileInputStream(System.getProperty("user.dir")+ File.separator+"src"+File.separator+"main"+ File.separator+"java"+File.separator+"locators"+File.separator+"accounttype_locators.properties");
            accountTypeLocatorProps.load(accountTypeLocatorStream);
            accountTypeLocatorStream.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public ManualFormPage chooseManualAccountType(){
        ManualFormPage manualFormPage;
        try{
            WebActions.actionClick(driver, accountTypeLocatorProps.getProperty("manual"));

        }catch (Exception e){
            e.printStackTrace();
        }

        return new ManualFormPage(driver);
    }
}
