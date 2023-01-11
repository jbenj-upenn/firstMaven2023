package com.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;

public class HWTests09Jan2023 {

    WebDriver dr;

    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","E:\\Softwares\\chromedriver.exe");
    }

    @Test
    public void homeworkTests() throws InterruptedException {
        WebDriverManager.edgedriver().setup();

        // Object of a driver
        dr = new EdgeDriver();

        // .get() method
        dr.get("https://www.michaelmanagement.com");

        // .maximize
        dr.manage().window().maximize();

        // .getClass() method
        System.out.println(".getClass(): " + dr.getClass()); //returns class org.openqa.selenium.chrome.ChromeDriver

        // .getCurrentUrl() method
        System.out.println(".getCurrentUrl(): " + dr.getCurrentUrl()); //returns URL hyperlink; returns error if browser is closed before execution is complete

        // .getPageSource() method
        boolean b = dr.getPageSource().contains("Access");
        boolean b2 = dr.getPageSource().contains("alsdfkj");
        System.out.println(".getPageSource().contiains(\"Access\": " + b); //true
        System.out.println(".getPageSource().contains(\"alsdfkj\": " +b2); //false

        // .getTitle() method; returns String
        String title = dr.getTitle();
        System.out.println(".getTitle(): " + title); //returns SAP Online Training - Courses & Access | Michael Management

        // .getText() method; returns String; used extensively to verify messages, labels, errors, and other text display
        String text = dr.findElement(By.id("announcement")).getText(); //use Dev tools to find an element's id on the target site
        System.out.println(text); //returns "We use cookies to ensure you get the best browsing experience on our site. Find out how we use cookies and how to change your settings."
                                    // "Got it!"

        // .getAttribute() method
//        WebElement text2 = dr.findElement(By.id("#alt")); //not sure what to enter here as argument
//        System.out.println(text2); //returns NoSuchElementException

        // .findElement(By.linkText("text")).click();
        dr.findElement(By.linkText("Browse Courses")).click(); //clicks the link and goes to that page

        Thread.sleep(2000);

        // .navigate().back(); method
        dr.navigate().back(); //clicks back arrow

        Thread.sleep(2000);

        // .findElement(By.partialLinkText("text")).click();
        dr.findElement(By.partialLinkText("SAP")).click(); //clicks any links with part of the text argument present

        Thread.sleep(2000);

        // .navigate().to("https://url.com");
        dr.navigate().to("https://www.michaelmanagement.com");

        Thread.sleep(2000);

        // .navigate().refresh()
        dr.navigate().refresh(); //refresh the page

        // SELECT dropdown, select Search input field, enter input, click enter
        dr.findElement(By.cssSelector(".navbar-toggler")).click();
        dr.findElement(By.cssSelector("input[placeholder='Search Courses']")).sendKeys("JavaScript");
        dr.findElement(By.cssSelector("input[placeholder='Search Courses']")).sendKeys(Keys.ENTER);

        Thread.sleep(2000);

        // Return to main page
        dr.navigate().to("https://www.michaelmanagement.com");

        Thread.sleep(2000);

        // Return true if chat is enabled
        boolean chat = dr.findElement(By.id("zsiq_agtpic")).isEnabled();
        System.out.println("Chat enabled: " + chat);

        // Testing chat message
        dr.findElement(By.id("zsiq_agtpic")).click();
        // Error below because these elements depend on opening the chat?
        Thread.sleep(2000);

//        dr.findElement(By.cssSelector("input[placeholder='Enter your name (Required)']")).sendKeys("Josh");
//        dr.findElement(By.cssSelector("input[placeholder='Enter your name (Required)']")).sendKeys(Keys.ENTER);
//        dr.findElement(By.cssSelector("input[placeholder='Enter your email address (Required)']")).sendKeys("jbenjamin@michaelmanagement.com");
//        dr.findElement(By.cssSelector("input[placeholder='Enter your email address (Required)']")).sendKeys(Keys.ENTER);
//        dr.findElement(By.cssSelector("input[placeholder='Type your message and hit Enter']")).sendKeys("Selenium Testing");
//        dr.findElement(By.cssSelector("input[placeholder='Type your message and hit Enter']")).sendKeys(Keys.ENTER);

        // .sleep(in milliseconds)
        Thread.sleep(5000);

        // .close() or .quit(); .close() closes current browser; .quit() closes all browsers opened by program
        dr.close();
    }

}
