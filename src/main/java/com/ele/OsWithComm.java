package com.ele;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import utils.BaseIOSTest;

import java.io.File;

/**
 * Created by zhangletian on 2017/11/15.
 */
public class   OsWithComm extends BaseIOSTest {
    private static Logger Log = Logger.getLogger(OsWithComm.class.getName());
    @BeforeClass
    public static void beforeClass() throws Exception {

        //appium.node.js.exec.path
        System.setProperty(AppiumServiceBuilder.NODE_PATH ,
                "/Users/zhangletian/.nvm/versions/node/v9.2.0/bin/node");

        System.setProperty(AppiumServiceBuilder.APPIUM_PATH ,
                "/Users/zhangletian/.nvm/versions/node/v9.2.0/bin/appium");
        service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().withIPAddress("127.0.0.1").usingPort(4723));
        service.start();
        if(service==null && !service.isRunning())
         {
            Log.info(!service.isRunning());
            service.stop();
            throw new AppiumServerHasNotBeenStartedLocallyException("An appium server node is not started!");
        }
        File appDir = new File("src/main/resources");
        File app = new File(appDir, "TestApp.app.zip");
//        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.2.1");
//        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "quli");
//        //desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/zhangletian/Downloads/ios_8dc3f0fd21a74c34da0eccb999477cf0.ipa.zip");
//        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM, "IOS");
//        desiredCapabilities.setCapability(MobileCapabilityType.UDID, "dd39071ff4c2dd6200b0018fb9618b549f0cda7a");
//        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
//        desiredCapabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "me.ele.ios.eleme");
//        desiredCapabilities.setCapability("appiumVersion", "1.7.0-beta");
//        desiredCapabilities.setCapability("name", "LT");
//        desiredCapabilities.setCapability(IOSMobileCapabilityType.LAUNCH_TIMEOUT, 500000);
//        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 5000);
//        URL sauceUrl = new URL("http://0.0.0.0:4723/wd/hub");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, 11.1);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone Simulator");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
        //sometimes environment has performance problems
        capabilities.setCapability(IOSMobileCapabilityType.LAUNCH_TIMEOUT, 500000);
        capabilities.setCapability(IOSMobileCapabilityType.SHOW_IOS_LOG,"True");
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

        driver = new IOSDriver<>(service.getUrl(), capabilities);
    }
}
