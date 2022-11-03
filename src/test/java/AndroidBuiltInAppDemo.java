import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidBuiltInAppDemo
{
    AppiumDriver driver;

    @BeforeTest
    public  void setup() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("udid", "22X0219C11001509");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformVersion", "12.0.0");
        caps.setCapability("deviceName", "HUAWEI P30 Pro");
        caps.setCapability("appPackage","com.huawei.calculator");
        caps.setCapability("appActivity","com.huawei.calculator.Calculator");
        // add appium server
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
    }

    @Test
    public void Click_Btn_Test()
    {

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
