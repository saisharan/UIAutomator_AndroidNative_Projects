package com.photon.helios.test;

import android.util.Log;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.core.UiWatcher;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class UISpecialOfferTest extends UiAutomatorTestCase
{protected static final String LOG_TAG = "In UISpecialOfferTest";

public void testtSpecialOffersTest() throws UiObjectNotFoundException{
	/*getUiDevice().pressHome();
	//Shows all apps on screen
	UiObject allAppsButton = new UiObject(new UiSelector().description("Apps"));
	// Simulate a click to bring up the All Apps screen.
    allAppsButton.clickAndWaitForNewWindow();
    UiObject appsTab = new UiObject(new UiSelector().text("Apps"));
    appsTab.click();
    //swipe to check all apps for eshop
    UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(true));
    //set swipe mode to horizontal
    appViews.setAsHorizontalList();
    // Create a UiSelector to find the Native Eshop app and simulate
    // a user click to launch the app.
    UiObject apiDemoApp = appViews.getChildByText(new UiSelector().className(android.widget.TextView.class.getName()), "Native_Eshop");
    apiDemoApp.clickAndWaitForNewWindow();
    sleep(50000);*/
    
    //Define watcher
    
    UiWatcher okCancelDialogWatcher = new UiWatcher() {
    	@Override
    	public boolean checkForCondition() {
    	
    	sleep(50000);
    	UiObject spoffer_button = new UiObject(new UiSelector().description("home_offers_btn")
    			   .className("android.widget.ImageButton"));

    	if(spoffer_button.exists()){
    	Log.w(LOG_TAG, "Found the special offer button");
    	try {
    		spoffer_button.clickAndWaitForNewWindow(50000);
			Special_Offer_Activity_test();
		    
    	} catch (UiObjectNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return (spoffer_button.waitUntilGone(25000));
    	}
    	return false;
    	}
    	};
    	
    	// Register watcher
    	UiDevice.getInstance().registerWatcher("Check Login status of app", okCancelDialogWatcher);
    	 
    	// Run watcher
    	UiDevice.getInstance().runWatchers();    	
    	   	
    	
         }
    	 public void Special_Offer_Activity_test() throws UiObjectNotFoundException{
    		 UiScrollable productView = new UiScrollable(new UiSelector().className(android.widget.ListView.class.getName()));
    			productView.setMaxSearchSwipes(100);
    			//listView.scrollTextIntoView("Television");
    			productView.waitForExists(50000);
    			UiObject productItem = productView.getChildByInstance(new UiSelector()
    			        .className(android.widget.TextView.class.getName()), 1);
    			productItem.clickAndWaitForNewWindow(50000);
    			sleep(80000);
    			UiObject reviewButton=new UiObject(new UiSelector().className(android.widget.ImageButton.class.getName()).description("Submit Review"));
    			reviewButton.clickAndWaitForNewWindow(30000);
    			UiObject post=new UiObject(new UiSelector().className(android.widget.EditText.class.getName()).description("Post review"));
    			post.setText("Nice");
    			UiObject ratingbar=new UiObject(new UiSelector().className(android.widget.RatingBar.class.getName()));
    			ratingbar.click();
    			ratingbar.click();
    			ratingbar.click();
    			UiObject review=new UiObject(new UiSelector().className(android.widget.ImageButton.class.getName()).description("Review button"));
    			review.clickAndWaitForNewWindow(50000);
    			
    	 }  

 }
