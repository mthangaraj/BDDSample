package drivers;

import constant.CommonConstant;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

/**
 * Created by ionixx on 4/26/18.
 */
public class DriverUtil {

    public static WebDriver driver = null;
    static Properties props = new Properties();
    public static String platform = null;


    public static void loadConfig(String filePath){

        try{
            InputStream inputStream = new FileInputStream(filePath);
            props.load(inputStream);
            inputStream.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static WebDriver getDriver(String driverPropertiesName){

        try{
            loadConfig(System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+ File.separator+"java"+File.separator+"browserConfig"+File.separator+driverPropertiesName);
            driver = chooseDriver(props.getProperty("platform"));
            platform = props.getProperty("platform");


        }catch(Exception e){
            e.printStackTrace();
        }
        return driver;
    }


    private static WebDriver chooseDriver(String platform){

        try{

            if(platform.equalsIgnoreCase(CommonConstant.PLATFORM_WEB)) {

                if (props.getProperty("browser").equalsIgnoreCase(CommonConstant.CHROME_BROWSER)) {

                    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "driver" + File.separator + props.getProperty("driver_name"));

                    ChromeOptions options = new ChromeOptions();

                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-dev-shm-usage");

                    driver = new ChromeDriver(options);
                    driver.manage().window().maximize();
                    driver.get(props.getProperty("url"));
                } else if (props.getProperty("browser").equalsIgnoreCase(CommonConstant.FIREFOX_BROWSER)) {

                    driver = new FirefoxDriver();

                }
            }
            else if(platform.equalsIgnoreCase(CommonConstant.PLATFORM_ANDROID)){
                File app = new File(System.getProperty("user.dir") + File.separator +"src"+File.separator+"main"+File.separator+"resources"+File.separator+props.getProperty("apk"));

                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("app", app.getAbsolutePath());
                capabilities.setCapability("noReset", props.getProperty("noreset"));
                capabilities.setCapability("BROWSER_NAME", props.getProperty("browser"));
                capabilities.setCapability("VERSION", props.getProperty("version"));
                capabilities.setCapability("deviceName", props.getProperty("device_name"));
                capabilities.setCapability("platformName", props.getProperty("platform"));
                capabilities.setCapability("appPackage", props.getProperty("app_package"));
                capabilities.setCapability("appActivity", props.getProperty("app_activity"));
                //capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 500000);
                capabilities.setJavascriptEnabled(true);
                //driverUrl = props.getProperty("platform");
                //driverUrl = driverUrl.replace("Port", devicePort);

                driver = (AndroidDriver)new AndroidDriver(new URL(props.getProperty("url")), capabilities);

            }
            else if(platform.equalsIgnoreCase(CommonConstant.PLATFORM_IOS)){

                int wdaDevicePort = 8000 + (int)(Math.random() * ((9000 - 8000) + 1));

                File app = new File(System.getProperty("user.dir") + File.separator +"src"+File.separator+"main"+
                        File.separator+"resources"+File.separator+props.getProperty("apk"));
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, props.getProperty("browser"));
                capabilities.setCapability(MobileCapabilityType.VERSION, props.getProperty("version"));
                capabilities.setCapability(MobileCapabilityType.PLATFORM, props.getProperty("platform"));
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, props.getProperty("device_name"));
                capabilities.setCapability(MobileCapabilityType.NO_RESET, props.getProperty("noreset"));
                capabilities.setCapability(MobileCapabilityType.FULL_RESET, props.getProperty("fullreset"));
                capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
                capabilities.setCapability(MobileCapabilityType.UDID, props.getProperty("udid"));
                capabilities.setCapability("wdaLocalPort", wdaDevicePort);
                capabilities.setCapability("app", app.getAbsolutePath());

                driver = new IOSDriver(new URL(props.getProperty("url")), capabilities);

            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return driver;

    }

}
