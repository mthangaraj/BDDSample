package pagefactory;

import actions.AndroidActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by ionixx on 4/26/18.
 */
public class WhatsAppRegisterPage {

    WebDriver driver;
    static Properties loginProps = new Properties();

    public WhatsAppRegisterPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

        try{
            InputStream inputStream = new FileInputStream(System.getProperty("user.dir")+ File.separator+"src"+File.separator+"main"+ File.separator+"java"+File.separator+"locators"+File.separator+"whatapppage_locators.properties");
            loginProps.load(inputStream);
            inputStream.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public String validateNavigation(){
        String actaul = null;
        try{
            AndroidActions.actionClick(driver, loginProps.getProperty("accept"));
            AndroidActions.actionClick(driver, loginProps.getProperty("not_now"));
            AndroidActions.actionHideKeyboard(driver);
            actaul = "Successfully navigated";
           // AndroidActions.actionClick(driver, loginProps.getProperty("country"));
           // AndroidActions.actionClick(driver, loginProps.getProperty("search"));
           // AndroidActions.actionEnterText(driver, loginProps.getProperty("search_bar"), "India");

        }catch(Exception e){
            e.printStackTrace();
        }
        return actaul;
    }


}
