package com.spec.obj.posts;

import org.testng.annotations.Test;

import com.mapp.obj.common.BrowserLaunch;

public class FirstPost_Test extends BrowserLaunch{

	
	
	@Test
	public void createPost() throws InterruptedException{
		FirstPost post=new FirstPost(driver);
		Thread.sleep(3000);
//		assertTrue(post.isNewPostLinkDisplay(), "New Post Link not Displayed");
		post.clickOnNewPost();
//	//	assertTrue(post.isTitleFieldDisplay(), "Title field not displayed");
//		post.waitForTitel();
		post.enterTitle("NEWWW POSSSTTTT");
//	//	assertTrue(post.isPostDescriptionFieldDisplay(), "Description field is not displyed");
//		post.enterDescription("description");
//	//	assertTrue(post.isBodyFieldDisplay(), "Body field is not displayed");
//		post.enterBody("body");
//	//	assertTrue(post.isSaveButtonDisplay(), "Save button not displayed");
		post.clickOnSaveButton();
////		assertTrue(post.isBackButtonDisplay(), "Back button not found");
//		post.clickOnBackButton();
		assertTrue(post.isPostCreated("NEWWW POSSSTTTT"), "Post is not created ");
	//	post.getByXpath();
		post.clickOnSortBytitle();
		Thread.sleep(3000);
		//ok
	}
}
