
/* 
Sampad Rout
 */

package com.seletest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.*;

public class AppTest 
{
    WebDriver driver;

    @BeforeTest
    public void setup()
    {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        
        options.setHeadless(true);
        options.addArguments("--window-size=1325x744");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox"); // Bypass OS security model
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-extensions");
        options.addArguments("--remote-debugging-port=9222");

        driver = new ChromeDriver(options);

        driver.get("https://taiko.dev/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void doctest () {
        driver.findElement(By.linkText("Documentation")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://docs.taiko.dev/");
        Assert.assertEquals(driver.findElement(By.xpath("//*[contains(text(), 'Introductory')]")).getText(), "Introductory");
    }
    @AfterTest
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}