package ui;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
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
		
		System.setProperty("webdriver.chrome.driver", "D:\\SDriver\\chromedriver.exe");
		drv = new ChromeDriver();
		drv.get("https://www.asos.com/men");
		drv.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test(priority = 1)
	public void testTitle()
	{
		//assert title on site
		String expectedtitle = "Men's Clothes | Shop for Men's Fashion | ASOS";
		String actualtitle = drv.getTitle();
		Assert.assertEquals(actualtitle, expectedtitle);
		drv.manage().window().maximize();
	}
	
	@Test(priority = 2)
	public void hyperlinkTest() 
	{
		//hyperlink test
		WebElement womanpage = drv.findElement(By.linkText("WOMEN"));
		womanpage.click();
		drv.navigate().back(); //back to men section
	}
	
	@Test(priority = 3)
	public void ShippingCancel() 
	{
		drv.findElement(By.xpath("//*[@id=\"chrome-welcome-mat\"]/div/div/div[2]/button[1]")).click();
		drv.findElement(By.xpath("//*[@id=\"chrome-modal-container\"]/div[1]/div[2]/div/div/section/button")).click();
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
	public void SneakerTest() 
	{
		//sneaker choice
		drv.findElement(By.xpath("//*[@id=\"product-22501627\"]/a/div[1]/img")).click();
		Select NikeWaffle = new Select(drv.findElement(By.xpath("//*[@id=\"main-size-select-0\"]")));
		NikeWaffle.selectByVisibleText("UK 6");
		drv.findElement(By.xpath("//*[@id=\"product-add-button\"]/span[2]")).click();
	}
	
	@Test(priority = 6)
	public void inst() {
		//back to mainpage
		drv.findElement(By.xpath("//*[@id=\"chrome-sticky-header\"]/div[1]/div/div/a")).click();
		WebElement instpage = drv.findElement(By.linkText("Instagram")); //hyperlink to instagram
		instpage.click();
		
	}
}


//correctivity check
/*String expt = "Nike Sneakers";WebElement actt = driver.findElement(By.xpath("//*[@id=\"search-term-banner\"]/p[2]"));
Assert.assertEquals(expt, actt);
*/