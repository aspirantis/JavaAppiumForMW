package lib;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Platform
{
    private static final String PLATFORM_ANDROID = "android";
    private static final String PLATFORM_IOS = "iOS";
    private static final String PLATFORM_MOBILE_WEB = "mobile_web";
    private static final String AppURL = "http://127.0.0.1:4723";

    private static Platform instance;
    Platform() {}


    public static Platform getInstance()
    {
        if (instance == null) {
            instance = new Platform();
        }
        return instance;
    }

    public RemoteWebDriver getDriver() throws Exception
    {
        URL URL = new URL(AppURL);
        if(this.isAndroid()) {
            return new AndroidDriver(URL, this.getAndroidDesiredCapabilities());
        } else if (this.isIOS()) {
            return new IOSDriver(URL, this.getIOSDesiredCapabilities());
        } else if (this.isMW()) {
            return new ChromeDriver(this.getMWChromeOptions());
        } else {
            throw new Exception("Cannot detect type of the Driver. Platform value " + this.getPlatformVar());
        }
    }



    public boolean isAndroid() {
        return isPlatform(PLATFORM_ANDROID);
    }

    public boolean isIOS() {
        return isPlatform(PLATFORM_IOS);
    }

    public boolean isMW() {
        return isPlatform(PLATFORM_MOBILE_WEB);
    }

    private DesiredCapabilities getAndroidDesiredCapabilities()
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:deviceName", "pixel9proxl");
        capabilities.setCapability("appium:platformVersion", "13.0");
        capabilities.setCapability("appium:appPackage", "org.wikipedia");
        capabilities.setCapability("appium:appActivity", ".main.MainActivity");
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appium:app", "D:\\aspirantis\\JavaAppiumAutomation\\apks\\org.wikipedia.apk");
        capabilities.setCapability("appium:fullReset", true);
        capabilities.setCapability("appium:ignoreHiddenApiPolicyError", true);

        return capabilities;
    }

    private DesiredCapabilities getIOSDesiredCapabilities()
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("appium:deviceName", "iOSTestDevice");
        capabilities.setCapability("appium:platformVersion", "18.0");
        capabilities.setCapability("appium:app", "D:\\aspirantis\\JavaAppiumAutomation\\apks\\Wikipedia.app");
        capabilities.setCapability("appium:automationName", "XCUITest");
        capabilities.setCapability("appium:fullReset", true);
        capabilities.setCapability("appium:ignoreHiddenApiPolicyError", true);

        return capabilities;
    }


//    private ChromeOptions getMWChromeOptions() {
//        Map<String, Object> deviceMetrics = new HashMap<>();
//        deviceMetrics.put("width", 412);
//        deviceMetrics.put("height", 915);
//        deviceMetrics.put("pixelRatio", 3.0);
//
//        Map<String, Object> mobileEmulation = new HashMap<>();
//        mobileEmulation.put("deviceMetrics", deviceMetrics);
//        mobileEmulation.put("userAgent", "Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D) " +
//                "AppleWebKit/535.19 (HTML, like Gecko) Chrome/133.0.6943.127 Mobile Safari/535.19");
//
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--window-size=412,915");
//        chromeOptions.setCapability("platformName", "Windows");
////        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
//        chromeOptions.setCapability("automationName", "chrome");
//        chromeOptions.setCapability("browserName", "chrome");
//        chromeOptions.setCapability("goog:chromeOptions", mobileEmulation);
//
//        return chromeOptions;
//    }

    private ChromeOptions getMWChromeOptions() {
        Map<String, Object> deviceMetrics = new HashMap<String, Object>();
        deviceMetrics.put("width", 412);
        deviceMetrics.put("height", 915);
        deviceMetrics.put("pixelRatio", 3.0);

        Map<String, Object> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceMetrics", deviceMetrics);
        mobileEmulation.put("userAgent", "Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D) " +
                "AppleWebKit/535.19 (HTML, like Gecko) Chrome/133.0.6943.127 Mobile Safari/535.19");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("window-size=412,915");

        return chromeOptions;
    }



    public boolean isPlatform(String my_platform)
    {
        String platform = this.getPlatformVar();
        return my_platform.equals((platform));
    }

    public String getPlatformVar()
    {
        String platform = System.getenv("PLATFORM");
        return platform != null ? platform.toLowerCase() : "";
    }


    private String getEnvPlatform()
    {
        return System.getenv("PLATFORM");
    }

}
