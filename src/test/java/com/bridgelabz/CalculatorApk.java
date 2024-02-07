package com.bridgelabz;

import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.Immutable;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class CalculatorApk {
    AndroidDriver driver;
//    @BeforeTest
//    public void setup() throws MalformedURLException, InterruptedException {
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Redmi");
//        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
//        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");
//        capabilities.setCapability("chromeOptions", ImmutableMap.of("w3c",false));
//        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
//    }
    @BeforeMethod
    public void setup() throws MalformedURLException {
        DesiredCapabilities dc= new DesiredCapabilities();
        dc.setCapability("platformName","Android");
        dc.setCapability("udid","6977caf10904");
        dc.setCapability("deviceName","Redmi");
        dc.setCapability("platformVersion","8.1.0");
        dc.setCapability("appPackage","com.miui.calculator");
        dc.setCapability("appActivity","com.miui.calculator.cal.CalculatorActivity");
        driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),dc);
        WebElement agree = driver.findElement(By.id("android:id/button1"));
        agree.click();
        System.out.println("It is Starting");
    }
    @Test(priority = 1)
    public void addition() throws InterruptedException {
        Thread.sleep(3000);
        WebElement seven = driver.findElement(By.id("com.miui.calculator:id/btn_7_s"));
        seven.click();
        WebElement plus = driver.findElement(AppiumBy.accessibilityId("plus"));
        plus.click();
        WebElement three = driver.findElement(By.id("com.miui.calculator:id/btn_3_s"));
        three.click();
        WebElement equal = driver.findElement(AppiumBy.accessibilityId("equals"));
        equal.click();
    }
    @Test(priority = 2)
    public void multiply(){
        WebElement eight = driver.findElement(By.id("com.miui.calculator:id/btn_8_s"));
        eight.click();
        WebElement multiply = driver.findElement(AppiumBy.accessibilityId("multiply"));
        multiply.click();
        WebElement nine = driver.findElement(By.id("com.miui.calculator:id/btn_9_s"));
        nine.click();
        WebElement equal = driver.findElement(AppiumBy.accessibilityId("equals"));
        equal.click();
    }
    @Test(priority = 3)
    public void division(){

    }
    @AfterTest
    public void exit_APK(){
        driver.quit();
    }
}
