package actions;

import io.appium.java_client.MobileDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by ionixx on 4/30/18.
 */
public class ActionHelper {

    public static boolean isDisplayed(WebDriver driver, By elementFindMethod){

        boolean isDisplayed = true;
        try{

            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(elementFindMethod));
           // driver.findElement(elementFindMethod).isDisplayed();

        }catch (Exception e){
            return false;
        }
        return isDisplayed;
    }

    public static boolean scrollDownUntilComponentBecomesClickable(WebDriver driver, By elementFindMethod){

        boolean isClickable = true;
        try{

            driver.findElement(elementFindMethod).click();


        }catch (Exception e){
            try{
                Robot robot = new Robot();

                robot.keyPress(KeyEvent.VK_DOWN);
                robot.keyRelease(KeyEvent.VK_DOWN);

                scrollDownUntilComponentBecomesClickable(driver, elementFindMethod);
            }catch (Exception e1){

            }

        }
        return isClickable;
    }

    public static boolean pressTabUntilComponentDisplayed(WebDriver driver, By elementFindMethod){

        boolean isDisplayed = true;
        try{

            driver.findElement(elementFindMethod).click();


        }catch (Exception e){
            try{
                Robot robot = new Robot();

                robot.keyPress(KeyEvent.VK_TAB);
                robot.keyRelease(KeyEvent.VK_TAB);

                pressTabUntilComponentDisplayed(driver, elementFindMethod);
            }catch (Exception e1){

            }

        }
        return isDisplayed;
    }


    public static By identifierFindMethod(String locator){

        try{
            String locatorType = locator.split("-")[0];
            String locatorName = locator.split("-")[1];

            if ("id".equals(locatorType)) {
                return By.id(locatorName);
            } else if ("name".equals(locatorType)) {
                return By.name(locatorName);
            } else if ("xpath".equals(locatorType)) {
                return By.xpath(locatorName);
            } else if ("cssSelector".equals(locatorType)) {
                return By.cssSelector(locatorName);
            } else if ("class".equals(locatorType)) {
                return By.className(locatorName);
            } else if ("linkText".equals(locatorType)) {
                return By.linkText(locatorName);
            } else if ("partialLinkText".equals(locatorType)) {
                return By.partialLinkText(locatorName);
            } else if ("tagName".equals(locatorType)) {
                return By.tagName(locatorName);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
