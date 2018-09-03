package com.mapp.obj.user;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Login {
	
	public WebDriver driver;
	
	public Login(WebDriver driver){
		this.driver=driver;
	}
	
	
	
	//Element locator of the fields and button
	By signinIcon=By.cssSelector("a[id='btn-signin']");
	By username1=By.cssSelector("div[id='form-field-username']");
	By username=By.cssSelector("input[id='field-username']");
	By username2=By.id("field-username");
	By password2=By.name("password");
	By password=By.cssSelector("input[id='field-password']");
	By usernameAndPawword=By.cssSelector("label[class='form--field--label ng-scope']");
    By signinButton=By.cssSelector("Button[id='signin-btn']");
    
    By collectMenu=By.cssSelector("a[id='collect']");
    By HomeMenu=By.cssSelector("a[target='_self']");
    By yourCollection=By.linkText("/yaktest/collection/");
    
    //For Error Message Locator 
    By allError=By.cssSelector("span[class='ng-binding']");
    
    
    // verify the whether all the fields are present or not------------------------------------------------------------
    public boolean isSiginIconDisplay(){
    	try{
    		return driver.findElement(signinIcon).isDisplayed();
    	}catch(NoSuchElementException e){
    		return false;
    	}
    }
    
    public boolean isUsernameFieldDisplay(){
    	try{
    		driver.findElement(username1).click();
    	return	driver.findElement(username).isDisplayed();
    	}catch(NoSuchElementException e){
    		return false;
    	}
    }
    public boolean isPasswordFieldDisplay(){
    	try{
    		return driver.findElement(password).isDisplayed();
    	}catch(NoSuchElementException e){
    		return false;
    	}
    }
    public boolean isSiginButtonDisplay(){
    	try{
    		return driver.findElement(signinButton).isDisplayed();
    	}catch(NoSuchElementException e){
    		return false;
    	}
    }
    
    
    // Perform Action and Enter the data ------------------------------------------------------------------------------
    public void clickOnSiginIcon(){
    	try{
    		driver.findElement(signinIcon).click();
    	}catch(NoSuchElementException e){
    		
    	}catch(StaleElementReferenceException e){
    		
    	}
    }
    public void enterUsername(String usernames){
    	try{
    		driver.findElement(username).click();
    		driver.findElement(username).sendKeys(usernames);
    	
    	}catch(NoSuchElementException e){
    		e.printStackTrace();
    	}
    }
    public void enterUsername2(String usernames){//if we dont use isusernamedisplay,then we need to click and enter
    	try{
    		driver.findElement(username1).click();
    		driver.findElement(username).sendKeys(usernames);
    	

    	}catch(NoSuchElementException e){
    		
    	}
    }
    public void enterPassword(String passwords){
    	try{
    		driver.findElement(password).sendKeys(passwords);
    		
    	}catch(NoSuchElementException e){
    		
    	}
    }
    public void clickOnSiginButton(){
    	try{
    		driver.findElement(signinButton).click();
    	}catch(NoSuchElementException e){
    		
    	}
    }
    
    //Verify the values is entered or not------------------------------------------------------------------------------
    
    public boolean isUsernameEntered(String username){
    	try{
    		return driver.findElement(this.username).getAttribute("value").equals(username);
    	}catch(NoSuchElementException e){
    		return false;
    	}
    }
    
    public boolean isPasswordEntered(String password){
    	try{
    		return driver.findElement(this.password).getAttribute("value").equals(password);
    	}catch(NoSuchElementException e){
    		return false;
    	}
    }

    // Validate the Error Message for Invalid Email ,Invalid User and Invalid Password----------------------------------

	public boolean isUnregistedEmailIDOrUsernameErrorEqual(String unRegistedEmailIDOrUsernameErrorMessage){
		try{
			List<WebElement> el=driver.findElements(allError);	
			for(int i=0;i<el.size();i++){
				System.out.println("Index="+i+"Value="+el.get(i).getText());
			}
		    return	el.get(0).getText().equals(unRegistedEmailIDOrUsernameErrorMessage);	    
			}catch(NoSuchElementException e){
				return false;
			}
	}
	public boolean isIncorrectPasswordErrorEqual(String IncorrectPasswordError){
		try{
			List<WebElement> el=driver.findElements(allError);	
			for(int i=0;i<el.size();i++){
				System.out.println("Index="+i+"Value="+el.get(i).getText());
			}
		    return	el.get(1).getText().equals(IncorrectPasswordError);	    
			}catch(NoSuchElementException e){
				return false;
			}
	}
	
	public boolean isHomeMenuDisplay(){
		try{
			System.out.println(driver.findElement(HomeMenu).getText());
		return driver.findElement(HomeMenu).isDisplayed();	
		}catch(NoSuchElementException e){
			return false;
		}
	}
	public boolean isCollectMenuDisplay(){
		try{
			System.out.println(driver.findElement(collectMenu).getText());
		return driver.findElement(collectMenu).isDisplayed();	
		}catch(NoSuchElementException e){
			return false;
		}
	}
	// custom login for different user
	
	public void waitforusernamefield(){
		try{
			WebDriverWait wait=new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.elementToBeClickable(username));
		}catch(NoSuchElementException e){
			
		}catch(TimeoutException e){
			
		}
	}
	
	//custom login for one time login only 
	
	public void loginuser(String usernames,String passwords) throws InterruptedException{
		try{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(signinIcon).click();Thread.sleep(2000);
		driver.findElement(username1).click();
		driver.findElement(username).sendKeys(usernames);
		driver.findElement(password).sendKeys(passwords);
		clickOnSiginButton();//Thread.sleep(5000);
	}catch(TimeoutException e){
		
	}catch(NoSuchElementException e){
		System.out.println("Username or Password Field Element not found");
	}
	}
	
	

	


	
	// this method is design for testAccountSetting , If for the user password is updated then this method should enter updated password
	public void reEnterUpdatedPasswordAndLogin(String IncorrectPasswordError,String updatedPassword){
		try{
			  if(driver.findElement(collectMenu).isDisplayed()==true){
				  System.out.println("OK");
			  }	
			}catch(Exception e){
			
				List<WebElement> el=driver.findElements(allError);	
				for(int i=0;i<el.size();i++){
					System.out.println("Index="+i+"Value="+el.get(i).getText());
				}
			    el.get(1).getText().equals(IncorrectPasswordError);	  
			    driver.findElement(password).clear();
			    driver.findElement(password).sendKeys(updatedPassword);
			    driver.findElement(signinButton).click();
			    
			}
		
	}
	
    public boolean isLoginPageDisplaying(){
    	try{
    		return driver.findElement(signinIcon).isDisplayed();
    	}catch(NoSuchElementException e){
    		return false;
    	}
    }
	
    
    // this login method is used where only one login is needed like BuYCedits

	
	
	
	
	
	
}
