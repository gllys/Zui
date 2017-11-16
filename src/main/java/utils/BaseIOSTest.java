package utils;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.annotations.AfterClass;


/**
 * Created by zhangletian on 2017/11/15.
 */
public class BaseIOSTest {

    protected static AppiumDriverLocalService service;
    protected static IOSDriver<IOSElement> driver;

    /**
     * finishing.
     */
    @AfterClass
    public static void afterClass() {
        if (driver != null) {
            driver.quit();
        }
        if (service != null) {
            service.stop();
        }
    }
}
