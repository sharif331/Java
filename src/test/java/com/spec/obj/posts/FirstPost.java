package com.spec.obj.posts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstPost {
	
	
	
	public WebDriver driver;
	
	public FirstPost(WebDriver driver){
		this.driver=driver;
	}
	
	//Locator
	
	By _sortByTitle=By.linkText("Sort by title");//wrong
	By _sortByDescription=By.linkText("/posts?sort_by=description&sort_order=asc");
	By _sortByBody=By.linkText("");
	
	//By _newPost=By.linkText("/posts/new");
	By _newPost=By.cssSelector("a[href='/posts/new']");
	By _titleTextBox=By.id("post_title");
//	By _titleTextBox=By.cssSelector("input[id='post_title']");
	By _postDescriptionTextBox=By.cssSelector("input[id='post_description']");
	By _bodyTextBox=By.cssSelector("textarea[id='post_body']");
	By _saveButton=By.cssSelector("input[name='commit']");
	By _backButton=By.linkText("Back");
	
	
	
	
	public void getURL(){
		System.out.println(driver.getCurrentUrl());
	}
	
	
	
	
	
	//  Verify the elements 
	public boolean isNewPostLinkDisplay(){
		try{
			return driver.findElement(_newPost).isDisplayed();
		}catch(NoSuchElementException e){
			return false;
		}
	}
	public boolean isTitleFieldDisplay(){
		try{
			return driver.findElement(_titleTextBox).isDisplayed();
		}catch(NoSuchElementException e){
			return false;
		}
	}
	public boolean isPostDescriptionFieldDisplay(){
		try{
			return driver.findElement(_postDescriptionTextBox).isDisplayed();
		}catch(NoSuchElementException e){
			return false;
		}
	}
	public boolean isBodyFieldDisplay(){
		try{
			return driver.findElement(_bodyTextBox).isDisplayed();
		}catch(NoSuchElementException e){
			return false;
		}
	}
	public boolean isSaveButtonDisplay(){
		try{
			return driver.findElement(_saveButton).isDisplayed();
		}catch(NoSuchElementException e){
			return false;
		}
	}
	public boolean isBackButtonDisplay(){
		try{
			return driver.findElement(_backButton).isDisplayed();
		}catch(NoSuchElementException e){
			return false;
		}
	}
	
	// Wait---------------------------
	
	public void waitForTitel(){
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(_titleTextBox));
	}
	
	// Perform Action ------------------------------------------------------
	
	public void clickOnNewPost(){
		try{
			driver.findElement(_newPost).click();
		}catch(NoSuchElementException e){
			System.out.println("New Post Link not found");
		}catch(StaleElementReferenceException e){
			
		}
	}
	public void enterTitle(String title){
		try{
			driver.findElement(_titleTextBox).click();
			driver.findElement(_titleTextBox).sendKeys(title);
		}catch(NoSuchElementException e){
			System.out.println("Unbale to enter the title");
		}
	}
	
	public void enterDescription(String description){
		try{
			driver.findElement(_postDescriptionTextBox).sendKeys(description);
		}catch(NoSuchElementException e){
			System.out.println("Unbale to enter the title");
		}
	}
	public void enterBody(String body){
		try{
			driver.findElement(_bodyTextBox).sendKeys(body);
		}catch(NoSuchElementException e){
			System.out.println("Unbale to enter the title");
		}
	}
	public void clickOnSaveButton(){
		try{
			driver.findElement(_saveButton).click();
		}catch(NoSuchElementException e){
			System.out.println("Unable to click on Save button");
		}
	}
	public void clickOnBackButton(){
		try{
			driver.findElement(_backButton).click();
		}catch(NoSuchElementException e){
			System.out.println("Unable to click on Save button");
		}
	}
	
	
	// Verification of the New Post
	
	
	public boolean isPostCreated(String title){
		
		WebElement table=driver.findElement(By.tagName("tbody"));
		List<WebElement> row=table.findElements(By.tagName("tr"));
		for(int i=0;i<row.size();i++){
			
			List<WebElement> column=row.get(i).findElements(By.tagName("td"));
			
//			for(int j=0;j<column.size();j++){
//				if(column.get(i).getText().equals(title)){
//					return true;
//				}
			
		if(	column.get(0).getText().equals(title)){
			System.out.println(column.get(0).getText());
			return true;
		}
				
			}
			
//		}
		return false;
		
	}

	public void clickOnSortBytitle(){
		driver.findElement(_sortByTitle).click();
	}
	
	
	
	
	
	
	

}
