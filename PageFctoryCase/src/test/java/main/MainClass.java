package main;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MainClass {
	
	WebDriver driver;
	HomePage objhomepage;
	
	@BeforeTest
	public void Setup()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\SDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("https://www.asos.com/men/");
		driver.manage().window().maximize();
	}
	
	@Test (priority = 1)
	public void WinterSection()
	{
		objhomepage = new HomePage(driver);
		objhomepage.getWinterClothes();
	}
	
	@Test (priority = 2)
	public void SelectProduct()
	{
		objhomepage = new HomePage(driver);
		objhomepage.getProduct();
		Select Size = new Select(driver.findElement(By.xpath("//*[@id=\"main-size-select-0\"]")));
		Size.selectByVisibleText("M - Chest 40");
		objhomepage.clickSave();
	}
	
	@Test (priority = 3)
	public void MySavedProducts()
	{
		objhomepage = new HomePage(driver);
		objhomepage.clickMySaved();
	}
	
	@Test (priority = 4)
	public void ChangeCountry()
	{
		objhomepage = new HomePage(driver);
		objhomepage.clickShipping();
		
		Select country = new Select(driver.findElement(By.xpath("//*[@id=\"country\"]")));
		country.selectByVisibleText("Canada");
		
		objhomepage.clickAccept();
	}
}
