import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidBuiltInAppDemo
{
    public AppiumDriver driver;

    @BeforeTest
    public  void setup() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("udid", "22X0219C11001509");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformVersion", "12.0.0");
        caps.setCapability("deviceName", "HUAWEI P30 Pro");
        caps.setCapability("appPackage","com.huawei.calculator");
        caps.setCapability("appActivity",".Calculator");
        // add appium server
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
    }

    @Test
    public void Click_Btn_Test()
    {
        driver.findElement(By.id("digit_1")).click();
        driver.findElement(new AppiumBy.ByAccessibilityId("plus")).click();
        driver.findElement(By.id("digit_5")).click();
        driver.findElement(new AppiumBy.ByAccessibilityId("equals")).click();

        Assert.assertEquals(driver.findElement(By.id("com.huawei.calculator:id/formula")).getText(), "6");
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
