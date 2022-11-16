package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	
	private WebDriver driver;
	
	//find winter clothes button
	@FindBy(xpath = "//*[@id=\"chrome-app-container\"]/section[2]/ul/li[2]/a/div[1]/div/img")
	private WebElement winclotesButton;
	
	//find winter clothes --> product click
	@FindBy(id = "product-203619219")
	private WebElement cardiganButton;
	
	//find product --> save it for later button
	@FindBy(xpath = "//*[@id=\"save-for-later-portal-203619219\"]/button")
	private WebElement saveButton;
	
	//find saved --> my saved products button
	@FindBy (xpath = "//*[@id=\"chrome-sticky-header\"]/div[1]/div/ul/li[2]/a")
	private WebElement mysavedButton;
	
	//find my saved products --> country shipping button
	@FindBy (xpath = "//*[@id=\"chrome-footer\"]/footer/div[1]/div[3]/div/div/div/button")
	private WebElement shippingButton;
	
	//find country shipping --> accept new country button
	@FindBy (xpath = "//*[@id=\"chrome-modal-container\"]/div[1]/div[2]/div/div/section/form/div[3]/button")
	private WebElement acceptButton;
	
	public HomePage (WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void getWinterClothes()
	{
		winclotesButton.click();
	}
	
	public void getProduct()
	{
		cardiganButton.click();
	}
	
	public void clickSave()
	{
		saveButton.click();
	}
	
	public void clickMySaved()
	{
		mysavedButton.click();
	}
	
	public void clickShipping()
	{
		shippingButton.click();
	}
	
	public void clickAccept()
	{
		acceptButton.click();
	}
}
