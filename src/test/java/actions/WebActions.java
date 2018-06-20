package actions;

import drivers.DriverUtil;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by ionixx on 4/26/18.
 */
public class WebActions {


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


    public static String actionEnterTextWithClearText(WebDriver driver, String identifier, String input){

        String componentStatus = null;
        try{

           componentStatus = CommonActions.enterTextEventWithClearText(driver, identifier, input, DriverUtil.platform);

        }catch(Exception e){
            e.printStackTrace();
        }
        return componentStatus;
    }

    public static String actionClearText(WebDriver driver, String identifier, String input){
        String componentStatus = null;
        try{

            componentStatus = CommonActions.clearTextEvent(driver, identifier, DriverUtil.platform);

        }catch(Exception e){
            e.printStackTrace();
        }
        return componentStatus;
    }

    public static String actionEnterNumber(WebDriver driver, String identifier, String input){

        String componentStatus = null;
        try{
            System.out.println("Current Identifier   =====>" +identifier);
            System.out.println("Current User Input   =====>" +input);

            CommonActions.pressTabUntilComponentDisplayed(driver, identifier, DriverUtil.platform);

            char[] inputArray = input.toCharArray();
            Robot robot = new Robot();

            for(int index=0; index<inputArray.length; index++) {

                Character inputChar = inputArray[index];
                if (String.valueOf(inputChar).equals("0")) {
                    robot.keyPress(KeyEvent.VK_0);
                    robot.keyRelease(KeyEvent.VK_0);
                    robot.delay(500);
                }else if(String.valueOf(inputChar).equals("1")){
                    robot.keyPress(KeyEvent.VK_1);
                    robot.keyRelease(KeyEvent.VK_1);
                    robot.delay(500);
                }else if(String.valueOf(inputChar).equals("2")){
                    robot.keyPress(KeyEvent.VK_2);
                    robot.keyRelease(KeyEvent.VK_2);
                    robot.delay(500);
                }else if(String.valueOf(inputChar).equals("3")){
                    robot.keyPress(KeyEvent.VK_3);
                    robot.keyRelease(KeyEvent.VK_3);
                    robot.delay(500);
                }else if(String.valueOf(inputChar).equals("4")){
                    robot.keyPress(KeyEvent.VK_4);
                    robot.keyRelease(KeyEvent.VK_4);
                    robot.delay(500);
                }else if(String.valueOf(inputChar).equals("5")){
                    robot.keyPress(KeyEvent.VK_5);
                    robot.keyRelease(KeyEvent.VK_5);
                    robot.delay(500);
                }else if(String.valueOf(inputChar).equals("6")){
                    robot.keyPress(KeyEvent.VK_6);
                    robot.keyRelease(KeyEvent.VK_6);
                    robot.delay(500);
                }else if(String.valueOf(inputChar).equals("7")){
                    robot.keyPress(KeyEvent.VK_7);
                    robot.keyRelease(KeyEvent.VK_7);
                    robot.delay(500);
                }else if(String.valueOf(inputChar).equals("8")){
                    robot.keyPress(KeyEvent.VK_8);
                    robot.keyRelease(KeyEvent.VK_8);
                    robot.delay(500);
                }else if(String.valueOf(inputChar).equals("9")){
                    robot.keyPress(KeyEvent.VK_9);
                    robot.keyRelease(KeyEvent.VK_9);
                    robot.delay(500);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return componentStatus;
    }

    public static String actionClearText(WebDriver driver, String identifier){

        String componentStatus = null;
        try{

            componentStatus = CommonActions.clearTextEvent(driver, identifier, DriverUtil.platform);

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

    public static String actionPressEscapeKey(WebDriver driver){

        String componentStatus = null;
        try{
            Robot robot = new Robot();

            robot.keyPress(KeyEvent.VK_ESCAPE);
            robot.delay(500);
            robot.keyRelease(KeyEvent.VK_ESCAPE);

        }catch (Exception e){
            e.printStackTrace();
        }

        return componentStatus;
    }

    public static String actionWaitForGivenTime(WebDriver driver, int timeInSeconds){

        String componentStatus = null;
        try{
            Thread.sleep(timeInSeconds);

        }catch (Exception e){
            e.printStackTrace();
        }

        return componentStatus;
    }

}
