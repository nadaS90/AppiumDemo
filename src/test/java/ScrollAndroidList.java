import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class ScrollAndroidList
{
    public AppiumDriver driver;
    public AndroidTouchAction actions;

    @BeforeTest
    public  void setup() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformVersion", "11.0");
        caps.setCapability("deviceName", "Android Emulator 1");
        caps.setCapability("app", System.getProperty("user.dir")+"/apps/ApiDemos-debug.apk");

        // add appium server
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
    }
    private void scrollDown()
    {
        Dimension dimension = driver.manage().window().getSize();
        int startPoint = (int) (dimension.getHeight() * 0.9 );
        int endPoint = (int) (dimension.getHeight() * 0.2 );
        actions = new AndroidTouchAction((PerformsTouchActions) driver)
                .press(PointOption.point(0, startPoint))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(0, endPoint))
                .release().perform();
    }

    @Test
    public void Scroll_App_List()
    {
        WebElement views = driver.findElement(new AppiumBy.ByAccessibilityId("Views"));
        //AndroidTouchAction touch = new AndroidTouchAction((PerformsTouchActions) driver);
        //touch.tap(TapOptions.tapOptions().withElement(ElementOption.element(views))).perform();

        //Tap
        actions = new AndroidTouchAction((PerformsTouchActions) driver);
        actions.tap(ElementOption.element(views)).perform();

        //Scroll down
        scrollDown();
        WebElement list = driver.findElement(new AppiumBy.ByAccessibilityId("Lists"));
        actions.tap(ElementOption.element(list)).perform();


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
