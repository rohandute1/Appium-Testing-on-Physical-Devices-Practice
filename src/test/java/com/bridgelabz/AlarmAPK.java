package com.bridgelabz;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AlarmAPK {
    AndroidDriver driver;
    @BeforeTest
    public void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("udid","6977caf10904");
        capabilities.setCapability("deviceName","Redmi");
        capabilities.setCapability("platformVersion","8.1.0");
        capabilities.setCapability("appPackage","com.android.deskclock");
        capabilities.setCapability("appActivity","com.android.deskclock.DeskClockTabActivity");
        driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        WebElement agree = driver.findElement(By.id("android:id/button1"));
        agree.click();
        System.out.println("It is Starting");
    }
    @Test(priority = 1)
    public void setAlarm() throws InterruptedException {
        // Assuming 'driver' is initialized and available in the class

        // Create TouchAction instance
        TouchAction touch = new TouchAction(driver);

        // Wait for 3 seconds
        Thread.sleep(3000);

        // Tap on a specific point to open the alarm settings
        touch.tap(PointOption.point(538, 1944)).perform();

        // Wait for 3 seconds
        Thread.sleep(3000);

        // Find the element you want to press i.e. Hour
        WebElement hourElement = driver.findElement(By.id("com.android.deskclock:id/hour"));
        hourElement.click();

        // Scroll up to change the hour
        int startX = hourElement.getLocation().getX() + hourElement.getSize().getWidth() / 2;
        int startY = hourElement.getLocation().getY() + hourElement.getSize().getHeight() / 2;
        int endY = startY - 600;

        touch.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(startX, endY)).release().perform();

        // Find the element you want to press on minute
        WebElement minute = driver.findElement(By.id("com.android.deskclock:id/minute"));
        hourElement.click();

        // Scroll up to change minute
        int startXMin = minute.getLocation().getX() + minute.getSize().getWidth() / 2;
        int startYMin = minute.getLocation().getY() + minute.getSize().getHeight() / 2;
        int endYMin = startYMin - 530;

        touch.press(PointOption.point(startXMin, startYMin)).waitAction((WaitOptions.waitOptions(Duration.ofMillis(500))) )
                .moveTo(PointOption.point(startXMin, endYMin)).release().perform();

        // Find the element you want to press on AMPM
        WebElement amPM = driver.findElement(By.id("com.android.deskclock:id/amPm"));
        hourElement.click();

        // Scroll up to change AM to PM
        int startXAMPM = amPM.getLocation().getX() + amPM.getSize().getWidth() / 2;
        int startYAMPM = amPM.getLocation().getY() + amPM.getSize().getHeight() / 2;
        int endYAMPM = startYAMPM - 530;

        touch.press(PointOption.point(startXAMPM, startYAMPM)).waitAction((WaitOptions.waitOptions(Duration.ofMillis(500))) )
                .moveTo(PointOption.point(startXAMPM, endYAMPM)).release().perform();

        //Click on confirm button to set alarm
        WebElement confirm = driver.findElement(AppiumBy.accessibilityId("Confirm"));
        confirm.click();
    }
}
