package org.windowsaccess;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsHandleAll {

	public static void main(String[] args) throws AWTException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sri_a\\eclipse-workspace\\WindowsHand\\driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.snapdeal.com");

		driver.manage().window().maximize();

		WebElement search = driver.findElement(By.id("inputValEnter"));

		search.sendKeys("iphone x mobile");
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

		WebElement iphone = driver.findElement(By.xpath("//*[@id=\"8646911931879848272\"]/div[3]/div[1]/a/div[1]"));
		iphone.click();

		// get parent window id
		String parent = driver.getWindowHandle();
		System.out.println("parent");
		// get child window
		Set<String> allhandles = driver.getWindowHandles();
		System.out.println(allhandles);
		// iterate the set
		for (String x : allhandles) {
			if (!parent.equals(x)) {
				driver.switchTo().window(x);
			}
		}
		WebElement tc = driver.findElement(By.xpath("//a[contains(text(),'T&C')]"));
		tc.click();
		// parent window
		driver.switchTo().defaultContent();
		
		Set<String> all3 = driver.getWindowHandles();
		
		System.out.println(all3);
		
		//copy set to list
		ArrayList li = new ArrayList();
		li.add(all3);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
        
		
	}

}
