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
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.get("https://www.asos.com/men/");
		driver.manage().window().maximize();
	}
	
	@Test(priority = 1)
	public void navigate_to_woman_page()
	{
		objhomepage = new HomePage(driver);
		objhomepage.clickwoman();
	}
	
	@Test(priority = 2)
	public void find_new_jacket() throws InterruptedException
	{
		objhomepage = new HomePage(driver);
		objhomepage.jacket_search();
	}
	
	@Test(priority = 3)
	public void brandselection() throws InterruptedException 
	{
		objhomepage = new HomePage(driver);
		objhomepage.brandselection();
	}
	
	@Test(priority = 4)
	public void mainpge()
	{
		objhomepage = new HomePage(driver);
		objhomepage.mainpagereturn();
	}
}
