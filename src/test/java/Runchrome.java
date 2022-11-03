import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Runchrome
{
    AppiumDriver driver;

    @BeforeTest
    public  void setup() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("deviceName", "HUAWEI P30 Pro");
        caps.setCapability("udid", "22X0219C11001509");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "12.0.0");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("automationName", "UiAutomator2");

        //caps.setCapability("app", System.getProperty("user.dir")+"/apps/ApiDemos-debug.apk");

        caps.setCapability("chromedriverExecutable","D:\\Appium\\FirstAppiumDemo\\drivers\\chromedriver.exe");

        // add appium server
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
    }

    @Test
    public void click_App_Button()
    {
        //driver.findElement(new AppiumBy.ByAccessibilityId("App")).click();
        driver.navigate().to("http://www.google.com/");
    }

    @AfterTest
    public void teatDown()
    {
        if (null != driver)
        {
            driver.quit();
        }
    }
}
