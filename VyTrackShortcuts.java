package com.HomeAssignments;

import com.Utlities.BrowserFactory;

import com.day4.library;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class VyTrackShortcuts {

    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {

        testVyTrackDashboard();
        testVyTrackShortcuts();

    }

    public static void testVyTrackDashboard(){

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("http://qa2.vytrack.com/user/login");
        driver.findElement(By.name("_username")).sendKeys("salesmanager270");
        driver.findElement(By.name("_password")).sendKeys("UserUser123");
        driver.findElement(By.name("_submit")).click();

       String actual =  driver.getTitle();
       String expected = "Dashboard";

       if(actual.contains(expected)){
           System.out.println("Passed");
           System.out.println(actual + " page is displayed");
       }else{
           System.out.println("Failed");
           System.out.println("This page title is " + actual);
           System.out.println("Expected page is " + expected);
       }




        library.sleep(4);

    }

    public static void testVyTrackShortcuts(){

        library.sleep(2);
        driver.findElement(By.cssSelector("[class='dropdown header-dropdown-shortcut header-utility-dropdown']")).click();
        library.sleep(2);
        driver.findElement(By.xpath("//a[text()='See full list']")).click();

        library.sleep(2);

        driver.findElement(By.xpath("//a[text()='Opportunities']")).click();
        library.sleep(1);
        String actualOpp = driver.getTitle();
        String expectedOpp = "Opportunities";

        if(actualOpp.contains(expectedOpp)){
            System.out.println("Passed");
            System.out.println(actualOpp + " page is displayed");
        }else{
            System.out.println("Failed");
            System.out.println("This page title is " + actualOpp);
            System.out.println("Expected page is " + expectedOpp);
        }
        library.sleep(2);
        driver.findElement(By.cssSelector("[class='dropdown header-dropdown-shortcut header-utility-dropdown']")).click();
        library.sleep(2);

        try{
           String serviceLog =  driver.findElement(By.xpath("//*[@id=\"container\"]/div[2]/div/table/tbody/tr[28]/td[1]/a")).getText();
            System.out.println(serviceLog);
        }catch (Exception e){
            System.out.println("Failed");
            System.out.println("Vehicle Serivce Log is not located on Shortcut icon, thus cannot perform further actions");
        }

        library.sleep(4);
        driver.quit();
    }


}
