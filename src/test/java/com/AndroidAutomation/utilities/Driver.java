package com.AndroidAutomation.utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Driver {
    private Driver() {
    }
    private static AppiumDriver driver;
    public static AppiumDriver get(){
        if (driver==null){
            String platform = ConfigurationReader.get("platform");
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            switch (platform){
                case "android":
                    desiredCapabilities.setCapability("platformName", "Android");
                    desiredCapabilities.setCapability("platformVersion", "7.0");
                    desiredCapabilities.setCapability("deviceName", "Pixel_2");
                    desiredCapabilities.setCapability("automationName", "UiAutomator2");
                    desiredCapabilities.setCapability("app", System.getProperty("user.dir")+"/apidemos.apk");
                    try {
                        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
                    }catch (MalformedURLException e){
                        e.printStackTrace();
                    }
                    break;
                case "chrome":
                    desiredCapabilities.setCapability("platformName","Android");
                    desiredCapabilities.setCapability("platformVersion","7.0");
                    desiredCapabilities.setCapability("deviceName","Pixel_2");
                    desiredCapabilities.setCapability("automationName","UiAutomator2");
                    desiredCapabilities.setCapability("browserName","chrome");
                    try {
                        WebDriverManager.chromedriver().version("2.23").setup();
                        desiredCapabilities.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, WebDriverManager.chromedriver().getBinaryPath());
                        RemoteWebDriver driver = new RemoteWebDriver(new URL("http:localhost:4723/wd/hub"), desiredCapabilities);
                    }catch (MalformedURLException e){
                        e.printStackTrace();
                    }
                    break;
                default:
            }
        }
        return driver;
    }
    public static void closeDriver() {
        if (driver!=null){
            driver.quit();
            driver=null;
        }
    }
}