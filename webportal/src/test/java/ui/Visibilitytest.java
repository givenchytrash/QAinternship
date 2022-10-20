package ui;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Visibilitytest {
	WebDriver drv;

	@Test
	public void vistest()
	{	
	System.setProperty("webdriver.chrome.driver", "D:\\SDriver\\chromedriver.exe");
	drv = new ChromeDriver();
	drv.get("https://www.asos.com/men");
	try {
	drv.findElement(By.xpath("//d"));
	} catch (WebDriverException e) {
	System.out.println("An exceptional case.");
	}
}	
}
