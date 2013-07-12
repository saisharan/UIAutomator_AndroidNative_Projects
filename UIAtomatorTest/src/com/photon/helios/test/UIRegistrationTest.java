package com.photon.helios.test;

import android.util.Log;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.core.UiWatcher;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class UIRegistrationTest extends UiAutomatorTestCase{

	public void testRegistration()throws UiObjectNotFoundException{
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
	    	
	    	
	    		 UiObject register_button = new UiObject(new UiSelector().className("android.widget.ImageButton").description("home_register_btn"));

	    	if(register_button.exists()){
	    	Log.w("Inside the registration Activity", "Found the registration button");
	    	try {
	    		register_button.clickAndWaitForNewWindow(5000);
				Registration_Activity_test();
			    
	    	} catch (UiObjectNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	return (register_button.waitUntilGone(25000));
	    	}
	    	return false;
	    	}
	    	};
	    	
	    	// Register watcher
	    	UiDevice.getInstance().registerWatcher("Check Registration status of app", okCancelDialogWatcher);
	    	 
	    	// Run watcher
	    	UiDevice.getInstance().runWatchers();
	}
	public void Registration_Activity_test() throws UiObjectNotFoundException{
		sleep(3000); 
		UiScrollable registerItem = new UiScrollable(new UiSelector()
		   .className("android.widget.ScrollView").scrollable(true));
		 registerItem.setAsVerticalList();
		 
		   /* Registration info for account creation
		    * 
		    */
		    UiObject firstName=registerItem.getChildByDescription(new UiSelector().className("android.widget.EditText"), "Enter First Name");
		    UiObject lastName=registerItem.getChildByDescription(new UiSelector().className("android.widget.EditText"), "Enter Last Name");
		    UiObject emailId=registerItem.getChildByDescription(new UiSelector().className("android.widget.EditText"), "Enter Email ID");
		    UiObject password=registerItem.getChildByDescription(new UiSelector().instance(1).className("android.widget.EditText"), "Enter Password");
		    UiObject confirmPass=registerItem.getChildByDescription(new UiSelector().instance(2).className("android.widget.EditText"), "Confirm Password");	    		    
		    /*Buttons in register page
		     * 
		     */
		    UiObject register_button=registerItem.getChildByDescription(new UiSelector().className("android.widget.ImageButton"), "Register button");
			try {
				if(firstName.exists()){
					firstName.setText("Ben");
				}
			     
				//firstName.setText("Ben");
				lastName.setText("Holden");
				emailId.setText("android.tester@photoninfotech.net");
				password.setText("1234");
				registerItem.scrollToEnd(1);
				confirmPass.setText("1234");
				assertTrue("Entered wrong registration info", register_button.clickAndWaitForNewWindow(3000));
				sleep(5000);
               //Check homeactivity functions properly
				Home_Activity_Test();
			} catch (UiObjectNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		                 
	 }
	public void Home_Activity_Test() throws UiObjectNotFoundException{
		 /* Check for disabled buttons
		  * 
		  */
		 UiObject login_button = new UiObject(new UiSelector().description("home_login_disable_btn")
   			   .className("android.widget.ImageButton"));
		 UiObject register_button = new UiObject(new UiSelector().description("home_register_disable_btn")
   			   .className("android.widget.ImageButton"));
        if(login_button.exists()){
       	 if(login_button.isClickable()==false){
       		System.out.println("The login button is disabled");
       	 }
        if(register_button.exists()){
       	 if(register_button.isClickable()==false){
       		 System.out.println("The register button is disabled");
       	 }
        }
        }
	}
}
