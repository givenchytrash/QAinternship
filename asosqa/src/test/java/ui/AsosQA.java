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

public class AsosQA {
	WebDriver drv;
	
	@BeforeSuite
	public void Setup() throws InterruptedException
	{
		//setting up chrome browser driver
		System.setProperty("webdriver.chrome.driver", "D:\\SDriver\\chromedriver.exe");
		drv = new ChromeDriver();
		drv.get("https://www.asos.com/men");
		drv.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test(priority = 1)
	public void testTitle() throws InterruptedException
	{
		//assert title on site
		String expectedtitle = "Men's Clothes | Shop for Men's Fashion | ASOS";
		String actualtitle = drv.getTitle();
		Assert.assertEquals(actualtitle, expectedtitle);
		drv.manage().window().maximize();
		//exception checking if banner is displayed
		try {
			drv.findElement(By.xpath("//*[@id=\"chrome-app-container\"]/section[1]/div")).isDisplayed();
			} catch (WebDriverException e) {
			System.out.println("There is no such element on this page..."); 
			}
	}
	
	@Test(priority = 2)
	public void hyperlinkTest() throws InterruptedException 
	{
		//testing link to the women page
		WebElement womanpage = drv.findElement(By.linkText("WOMEN"));
		womanpage.click();
		drv.navigate().back();
		Thread.sleep(3000);
	}
	
	@Test(priority = 3)
	public void ShippingCancel() throws InterruptedException 
	{
		drv.findElement(By.xpath("//*[@id=\"chrome-welcome-mat\"]/div/div/div[2]/button[1]")).click();
		drv.findElement(By.xpath("//*[@id=\"chrome-modal-container\"]/div[1]/div[2]/div/div/section/button")).click();
		Thread.sleep(5000);
	}
	
	@Test(priority = 4)
	public void SearchTest() 
	{
		//search test
		drv.findElement(By.xpath("//*[@id=\"chrome-search\"]")).sendKeys("Nike sneakers");
		drv.findElement(By.xpath("//*[@id=\"chrome-sticky-header\"]/div[1]/div/div/div/form/div/button[2]")).click();
		
		//scrolling down
		JavascriptExecutor j = (JavascriptExecutor) drv;
	    j.executeScript("window.scrollBy(0,350)");
	    
		//visibility test
		Boolean Display = drv.findElement(By.xpath("//*[@id=\"product-22501627\"]/a/div[1]/img")).isDisplayed();
		System.out.println("Element displayed is :"+Display);
	}
	
	@Test(priority = 5)
	public void SneakerTest() throws InterruptedException 
	{
		//product choice
		drv.findElement(By.xpath("//*[@id=\"product-22501627\"]/a/div[1]/img")).click();
		Select NikeWaffle = new Select(drv.findElement(By.xpath("//*[@id=\"main-size-select-0\"]")));
		NikeWaffle.selectByVisibleText("UK 6");
		drv.findElement(By.xpath("//*[@id=\"product-add-button\"]/span[2]")).click();
		Thread.sleep(5000);
	}
	
	@Test(priority = 6)
	public void inst() {
		//back to mainpage
		drv.findElement(By.xpath("//*[@id=\"chrome-sticky-header\"]/div[1]/div/div/a")).click();
		drv.findElement(By.className("_1cQFCx2")).click();
		drv.navigate().back();
		WebElement instpage = drv.findElement(By.linkText("Instagram")); //hyperlink to instagram
		instpage.click();
		
	}
}