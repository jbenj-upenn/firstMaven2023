package com.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstTest {
    @Test
    public void firstTest() throws InterruptedException {

        //the three lines below open the browser
        //use .edgedriver() and EdgeDriver() to open the page in Edge instead of Chrome
        //WedDriver is an interface that has many methods
        //We name the object "driver" and access methods with driver.methodName();

        //WEBDRIVER COMMANDS can be categorized as:
        //Browser commands;
        //Get commands;
        //Navigation commands;
        //Web element commands;
        //Action commands, and;
        //Result commands

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(); //this is the browser; .chromedriver() must match ChromeDriver()
        driver.get("https://www.softwaretestinghelp.com/");
        Thread.sleep(2000);
        driver.manage().window().maximize();
        driver.quit();

        //POSSIBLE ACTIVITIES TO TEST:
        //open site
        //type
        //click
        //scroll
        //zoom in
        //open browser (above)
        //close browser
        //right click
        //select from dropdown
        //go back and forth
        //refresh
        //open multiple tabs
        //maximize
        //drag and drop
        //copy and paste
        //screenshot

    }
}
