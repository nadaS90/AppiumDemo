import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class SwipeOption
{
    public AppiumDriver driver;
    public AndroidTouchAction actions;


    @BeforeTest
    public void setup() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformVersion", "11.0");
        caps.setCapability("deviceName", "Android Emulator 1");
        caps.setCapability("app", System.getProperty("user.dir")+"/apps/ApiDemos-debug.apk");

        // add appium server
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
    }


    @Test
    public void dragAnDrop()
    {
        WebElement views = driver.findElement(new AppiumBy.ByAccessibilityId("Views"));
        actions = new AndroidTouchAction((PerformsTouchActions) driver);
        actions.tap(ElementOption.element(views)).perform();

        WebElement gallery = driver.findElement(new AppiumBy.ByAccessibilityId("Gallery"));
        actions = new AndroidTouchAction((PerformsTouchActions) driver);
        actions.tap(ElementOption.element(gallery)).perform();

        WebElement photos = driver.findElement(new AppiumBy.ByAccessibilityId("1. Photos"));
        actions = new AndroidTouchAction((PerformsTouchActions) driver);
        actions.tap(ElementOption.element(photos)).perform();

        WebElement firstPic = (WebElement) driver.findElements(By.className("android.widget.ImageView")).get(0);
        actions.press(ElementOption.element(firstPic)).waitAction()
                .moveTo(PointOption.point(-400, 6000))
                .release().perform();




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
