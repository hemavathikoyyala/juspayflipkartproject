package com.JuspayProject;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartPayment {

    public static void main(String[] args) throws InterruptedException, AWTException {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.flipkart.com/");
        String mainWindowHandle = driver.getWindowHandle();
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.xpath("//input[@class='r4vIwl BV+Dqf']")).sendKeys("8989925050");
        driver.findElement(By.xpath("//button[@class='QqFHMw twnTnD _7Pd1Fp']")).click();
        Thread.sleep(30000);
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("mouse wired mouse");
        Thread.sleep(3000);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(10000);
        driver.findElement(By.xpath("//img[@alt='DELL MS 116-BK Wired Optical Mouse']")).click();
        Set<String> allWindows = driver.getWindowHandles();
        for (String windowHandle : allWindows) {
            if (!mainWindowHandle.equals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break; 
            }
        }
        WebElement element = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[1]/button")); 
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button/span[text()='Place Order']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/div/div[1]/div[2]/div/div/div/div[1]/label[1]/div[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"CNTCT736C7F4DBCB6406B96EA2BB93\"]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"to-payment\"]/button")).click();
        WebElement element1 = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/div/div[1]/div[4]/div/div/div[2]/div/label[2]/div[1]"));
        js.executeScript("arguments[0].scrollIntoView(true);", element1);
        element1.click();
        driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/div/div[1]/div[4]/div/div/div[2]/div/label[2]/div[2]/div/div/div[2]/button")).click();
        
        driver.quit();

}}