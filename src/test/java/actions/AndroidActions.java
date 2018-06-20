package actions;

import drivers.DriverUtil;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

/**
 * Created by ionixx on 4/30/18.
 */
public class AndroidActions {

    public static String actionClick(WebDriver driver, String identifier){

        String componentStatus = null;
        try{
            componentStatus = CommonActions.clickEvent(driver, identifier, DriverUtil.platform);

        }catch(Exception e){
           e.printStackTrace();
        }
        return componentStatus;
    }

    public static String actionEnterText(WebDriver driver, String identifier, String input){

        String componentStatus = null;
        try{

            componentStatus = CommonActions.enterTextEvent(driver, identifier, input, DriverUtil.platform);

        }catch(Exception e){
            e.printStackTrace();
        }
        return componentStatus;
    }

    public static String actionGetMessage(WebDriver driver, String identifier){

        String componentStatus = null;
        try{
            componentStatus = CommonActions.getMessageEvent(driver, identifier, DriverUtil.platform);

        }catch(Exception e){
            e.printStackTrace();
        }
        return componentStatus;
    }

    public static String actionHideKeyboard(WebDriver driver){
        String componentStatus = null;
        try{
            getAndroidDriver(driver).hideKeyboard();
        }catch(Exception e){
            //e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        return componentStatus;
    }

    private static AndroidDriver getAndroidDriver(WebDriver driver){
        AndroidDriver androidDriver = null;
        try{
            androidDriver = (AndroidDriver) driver;

        }catch (Exception e){
            e.printStackTrace();
        }

        return androidDriver;
    }
}
