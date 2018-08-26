package com.spec.obj.posts;

import org.testng.annotations.Test;


public class FirstPost_Test extends BrowserLaunch{

	
	
	@Test
	public void createPost() throws InterruptedException{
		FirstPost post=new FirstPost(driver);
		Thread.sleep(3000);
		post.getURL();
//		assertTrue(post.isNewPostLinkDisplay(), "New Post Link not Displayed");
//		post.clickOnNewPost();
		Thread.sleep(3000);
		post.getPage();
//	//	assertTrue(post.isTitleFieldDisplay(), "Title field not displayed");
		//post.waitForTitel();
		//post.enterTitle("NEW TE");
//	//	assertTrue(post.isPostDescriptionFieldDisplay(), "Description field is not displyed");
		//post.enterDescription("001");
//	//	assertTrue(post.isBodyFieldDisplay(), "Body field is not displayed");
		//post.enterBody("From JLenkins");
	//	assertTrue(post.isSaveButtonDisplay(), "Save button not displayed");
	//	post.clickOnSaveButton();
////		assertTrue(post.isBackButtonDisplay(), "Back button not found");
//		post.clickOnBackButton();
	//	assertTrue(post.isPostCreated("NEW TEST"), "Post is not created ");
	//	post.getByXpath();
	//	post.clickOnSortBytitle();
		post.getURL();
		Thread.sleep(3000);
		//ok
	}
}
