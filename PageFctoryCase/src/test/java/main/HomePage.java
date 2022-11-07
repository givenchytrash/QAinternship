package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	private WebDriver driver;
	
	//woman page button
	@FindBy(xpath = "/html/body/div[2]/div/div[2]/header/div[3]/div/div[1]/div/div/ul/li[1]/a")
	private WebElement womanpage;
	
	//new winter jackets on sale
	@FindBy(xpath = "/html/body/div[2]/div/main/section[3]/ul/li[1]/a/div[1]/div/img")
	private WebElement wintercloth;
	
	//search field input
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/header/div[3]/div/div[1]/div/div/div/form/div/input")
	private WebElement searchfield;
	
	//confirm button
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/header/div[3]/div/div[1]/div/div/div/form/div/button[2]")
	private WebElement confirmsearch;
	
	//brand list
	@FindBy(xpath = "/html/body/div[1]/div/main/div/div/div[2]/div/div/div[1]/ul/li[6]/div/button")
	private WebElement brandselector;
	
	//chosen brand
	@FindBy(xpath = "/html/body/div[1]/div/main/div/div/div[2]/div/div/div[1]/ul/li[6]/div/div/div/ul/li[1]/div/label/div")
	private WebElement brand;
	
	//return to main page
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/header/div[3]/div/div[1]/div/div/a")
	private WebElement mainpage;
	
	public HomePage (WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickwoman()
	{
		womanpage.click();
		wintercloth.click();
	}
	
	public void jacket_search()
	{
		searchfield.sendKeys("Winter woman jacket");
		confirmsearch.click();
	}
	
	public void brandselection()
	{
		brandselector.click();
		brand.click();
	}
	
	public void mainpagereturn()
	{
		mainpage.click();
	}
}
