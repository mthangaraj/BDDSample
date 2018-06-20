package actions;

import drivers.DriverUtil;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

/**
 * Created by ionixx on 4/30/18.
 */
public class IOSActions {

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
            getIOSDriver(driver).hideKeyboard();
        }catch(Exception e){
            //e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        return componentStatus;
    }

    private static IOSDriver getIOSDriver(WebDriver driver){
        IOSDriver iosDriver = null;
        try{
            iosDriver = (IOSDriver) driver;

        }catch (Exception e){
            e.printStackTrace();
        }

        return iosDriver;
    }
}
