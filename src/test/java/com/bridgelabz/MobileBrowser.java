package com.bridgelabz;

import com.google.common.collect.ImmutableMultimap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class MobileBrowser {
    AndroidDriver driver;
    @BeforeMethod
    public void setUrl() throws InterruptedException, MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("udid","6977caf10904");
        capabilities.setCapability("deviceName","Redmi");
        capabilities.setCapability("platformVersion","8.1.0");
        capabilities.setCapability("appPackage","com.android.chrome");
        capabilities.setCapability("appActivity","org.chromium.android_webview.devui.MainActivity");
        driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
    }
    @Test
    public void xyz() throws InterruptedException {
        driver.get("https://www.amazon.in");
        Thread.sleep(6000);
        WebElement element = driver.findElement(By.name("k"));
        element.sendKeys("Iphone");
        element.click();
    }
}
