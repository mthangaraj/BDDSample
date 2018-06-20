package actions;

import constant.CommonConstant;
import constant.ErrorConstant;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by ionixx on 4/26/18.
 */
public class CommonActions {

    public static String clickEvent(WebDriver driver, String identifier, String platform){

        String componentStatus = null;
        try{

            if(platform.equalsIgnoreCase(CommonConstant.PLATFORM_ANDROID)){
                driver = (AndroidDriver) driver;
            }else if(platform.equalsIgnoreCase(CommonConstant.PLATFORM_IOS)){
                driver = (IOSDriver) driver;
            }

            By elementFindMethod = ActionHelper.identifierFindMethod(identifier);
            if(ActionHelper.isDisplayed(driver, elementFindMethod)){
                driver.findElement(elementFindMethod).click();
            }else{
                componentStatus = ErrorConstant.NO_ELEMENT_FOUND + identifier;
                Assert.fail(componentStatus);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return componentStatus;
    }


    public static String enterTextEvent(WebDriver driver, String identifier, String input, String platform){

        String componentStatus = null;
        try{

            if(platform.equalsIgnoreCase(CommonConstant.PLATFORM_ANDROID)){
                driver = (AndroidDriver) driver;
            }else if(platform.equalsIgnoreCase(CommonConstant.PLATFORM_IOS)){
                driver = (IOSDriver) driver;
            }

            By elementFindMethod = ActionHelper.identifierFindMethod(identifier);
            if(ActionHelper.isDisplayed(driver, elementFindMethod)){
                driver.findElement(elementFindMethod).sendKeys(input);
            }else{
                componentStatus = ErrorConstant.NO_ELEMENT_FOUND + identifier;
                Assert.fail(componentStatus);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return componentStatus;
    }

    public static String enterTextEventWithClearText(WebDriver driver, String identifier, String input, String platform){

        String componentStatus = null;
        try{

            if(platform.equalsIgnoreCase(CommonConstant.PLATFORM_ANDROID)){
                driver = (AndroidDriver) driver;
            }else if(platform.equalsIgnoreCase(CommonConstant.PLATFORM_IOS)){
                driver = (IOSDriver) driver;
            }

            By elementFindMethod = ActionHelper.identifierFindMethod(identifier);
            if(ActionHelper.isDisplayed(driver, elementFindMethod)){
                driver.findElement(elementFindMethod).clear();
                driver.findElement(elementFindMethod).sendKeys(input);
            }else{
                componentStatus = ErrorConstant.NO_ELEMENT_FOUND + identifier;
                Assert.fail(componentStatus);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return componentStatus;
    }

    public static String clearTextEvent(WebDriver driver, String identifier,String platform){

        String componentStatus = null;
        try{

            if(platform.equalsIgnoreCase(CommonConstant.PLATFORM_ANDROID)){
                driver = (AndroidDriver) driver;
            }else if(platform.equalsIgnoreCase(CommonConstant.PLATFORM_IOS)){
                driver = (IOSDriver) driver;
            }

            By elementFindMethod = ActionHelper.identifierFindMethod(identifier);
            if(ActionHelper.isDisplayed(driver, elementFindMethod)){
                driver.findElement(elementFindMethod).clear();
            }else{
                componentStatus = ErrorConstant.NO_ELEMENT_FOUND + identifier;
                Assert.fail(componentStatus);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return componentStatus;
    }

    public static String getMessageEvent(WebDriver driver, String identifier, String platform){

        String componentStatus = null;
        try{

            if(platform.equalsIgnoreCase(CommonConstant.PLATFORM_ANDROID)){
                driver = (AndroidDriver) driver;
            }else if(platform.equalsIgnoreCase(CommonConstant.PLATFORM_IOS)){
                driver = (IOSDriver) driver;
            }

            By elementFindMethod = ActionHelper.identifierFindMethod(identifier);
            if(ActionHelper.isDisplayed(driver, elementFindMethod)){
                componentStatus = driver.findElement(elementFindMethod).getText();
            }else{
                componentStatus = ErrorConstant.NO_ELEMENT_FOUND + identifier;
                Assert.fail(componentStatus);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return componentStatus;
    }


    public static String scrollDownUntilComponentBecomesClickable(WebDriver driver, String identifier, String platform){
        String componentStatus = null;
        try{

            if(platform.equalsIgnoreCase(CommonConstant.PLATFORM_ANDROID)){
                driver = (AndroidDriver) driver;
            }else if(platform.equalsIgnoreCase(CommonConstant.PLATFORM_IOS)){
                driver = (IOSDriver) driver;
            }

            By elementFindMethod = ActionHelper.identifierFindMethod(identifier);
            ActionHelper.scrollDownUntilComponentBecomesClickable(driver, elementFindMethod);

        }catch(Exception e){
            e.printStackTrace();
        }
        return componentStatus;
    }

    public static String pressTabUntilComponentDisplayed(WebDriver driver, String identifier, String platform){
        String componentStatus = null;
        try{

            if(platform.equalsIgnoreCase(CommonConstant.PLATFORM_ANDROID)){
                driver = (AndroidDriver) driver;
            }else if(platform.equalsIgnoreCase(CommonConstant.PLATFORM_IOS)){
                driver = (IOSDriver) driver;
            }

            By elementFindMethod = ActionHelper.identifierFindMethod(identifier);
            ActionHelper.pressTabUntilComponentDisplayed(driver, elementFindMethod);

        }catch(Exception e){
            e.printStackTrace();
        }
        return componentStatus;
    }

    public static boolean assertEqualsWithGivenText(String expected, String actual){
        boolean isMatches = true;
        try{

            Assert.assertEquals(expected, actual);

        }catch(Exception e){
            e.printStackTrace();
        }

        return isMatches;
    }

    public static boolean verifyEqualsWithGivenText(String expected, String actual){
        boolean isMatches = true;
        try{

            if (!expected.equalsIgnoreCase(actual)){
                isMatches = false;
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return isMatches;
    }
}
