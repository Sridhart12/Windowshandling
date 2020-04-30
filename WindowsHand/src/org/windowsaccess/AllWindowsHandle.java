package org.windowsaccess;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AllWindowsHandle {
	
	public static void main(String[] args) throws InterruptedException
	{
	 
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\sri_a\\eclipse-workspace\\WindowsHand\\driver\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("http://toolsqa.com/automation-practice-switch-windows/");
	driver.manage().window().maximize();
	
	String parentWindowHandle = driver.getWindowHandle();
	System.out.println("Parent window's handle -> " + parentWindowHandle);
	WebElement clickElement = driver.findElement(By.id("button1"));
	 
	for(int i = 0; i < 3; i++)
	{
	clickElement.click();
	Thread.sleep(3000);
	}
	 
	Set<String> allWindowHandles = driver.getWindowHandles();
	 
	for(String handle : allWindowHandles)
	{
	System.out.println("Window handle - > " + handle);
	}

}
}