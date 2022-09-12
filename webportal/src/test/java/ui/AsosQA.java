package ui;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AsosQA {
	
	@Test
	public void TitleTest() throws InterruptedException
	{
		
		System.setProperty("webdriver.chrome.driver", "D:\\SDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.asos.com/men");
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		
		//assert title on site
		String expectedtitle = "Men's Clothes | Shop for Men's Fashion | ASOS";
		String actualtitle = driver.getTitle();
		Assert.assertEquals(actualtitle, expectedtitle);
		driver.manage().window().maximize();
		
		//hyperlink test
		WebElement womanpage = driver.findElement(By.linkText("WOMEN"));
		womanpage.click();
		driver.navigate().back(); //back to men section
		Thread.sleep(3000); //waiting
		driver.findElement(By.xpath("//*[@id=\"chrome-welcome-mat\"]/div/div/div[2]/button[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"chrome-modal-container\"]/div[1]/div[2]/div/div/section/button")).click();
		Thread.sleep(3000); //waiting
	
		//search test
		driver.findElement(By.xpath("//*[@id=\"chrome-search\"]")).sendKeys("Nike sneakers");
		driver.findElement(By.xpath("//*[@id=\"chrome-sticky-header\"]/div[1]/div/div/div/form/div/button[2]")).click();
		
		//scrolling down
		JavascriptExecutor j = (JavascriptExecutor) driver;
	    j.executeScript("window.scrollBy(0,350)");
	    
		//visibility test
		Boolean Display = driver.findElement(By.xpath("//*[@id=\"product-22501627\"]/a/div[1]/img")).isDisplayed();
		System.out.println("Element displayed is :"+Display);
		
		//sneaker choice
		Thread.sleep(3000); //waiting
		driver.findElement(By.xpath("//*[@id=\"product-22501627\"]/a/div[1]/img")).click();
		Select NikeWaffle = new Select(driver.findElement(By.xpath("//*[@id=\"main-size-select-0\"]")));
		NikeWaffle.selectByVisibleText("UK 6");
		driver.findElement(By.xpath("//*[@id=\"product-add-button\"]/span[2]")).click();
		Thread.sleep(3000); //waiting
		
		//back to mainpage
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"chrome-sticky-header\"]/div[1]/div/div/a")).click();
		WebElement instpage = driver.findElement(By.linkText("Instagram")); //hyperlink to instagram
		instpage.click();
		
	}
}



//correctivity check
/*String expt = "Nike Sneakers";WebElement actt = driver.findElement(By.xpath("//*[@id=\"search-term-banner\"]/p[2]"));
Assert.assertEquals(expt, actt);
*/