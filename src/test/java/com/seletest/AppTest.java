package com.seletest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.*;
import javafx.scene.effect.ColorInput;

public class AppTest 
{
    WebDriver driver;

    @BeforeTest
    public void setup()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://taiko.dev/");
        driver.manage().window().maximize();
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
