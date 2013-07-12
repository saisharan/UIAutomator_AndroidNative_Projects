package com.photon.helios.test;

import android.util.Log;

import com.android.uiautomator.core.UiCollection;
import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.core.UiWatcher;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class UILoginTest extends UiAutomatorTestCase{
	protected static final String LOG_TAG = "In UILoginTest";

	public void testLoginValidation() throws UiObjectNotFoundException{
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
	    	
	    	
	    	   	UiObject login_button = new UiObject(new UiSelector()
	    			   .className("android.widget.ImageButton").description("home_login_button"));

	    	if(login_button.exists()){
	    	Log.w(LOG_TAG, "Found the login button");
	    	try {
				login_button.clickAndWaitForNewWindow(50000);
				Login_Activity_test();
			    
	    	} catch (UiObjectNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	return (login_button.waitUntilGone(25000));
	    	}
	    	return false;
	    	}
	    	};
	    	
	    	// Register watcher
	    	UiDevice.getInstance().registerWatcher("Check Login status of app", okCancelDialogWatcher);
	    	 
	    	// Run watcher
	    	UiDevice.getInstance().runWatchers();
	    	 
	    	
	    	
	    	
	    	//UiObject back_button = new UiObject(new UiSelector().textStartsWith("Back"));
	    	//back_button.clickAndWaitForNewWindow();
	         }
	    	 public void Login_Activity_test(){
	    		 /* Creating uiobjects for buttons within login activity
	    		  * 
	    		  */
	    		 UiObject email_id=new UiObject(new UiSelector().className("android.widget.EditText").description("Enter Email ID"));
	    		 UiObject password=new UiObject(new UiSelector().className("android.widget.EditText").description("Enter Password"));
	    		 UiObject login=new UiObject(new UiSelector().description("Login into account").className("android.widget.ImageButton"));
	    		 UiObject cancel=new UiObject(new UiSelector().description("Cancel login").className("android.widget.ImageButton"));
	    		 UiObject register=new UiObject(new UiSelector().description("Register account").className("android.widget.ImageButton"));
				 try {
					email_id.setText("android.tester@photoninfotech.net");
					password.setText("*****");
					/* Click on login button on login page
					 * 
					 */
					if(login.click()){
						sleep(50000);
						UiObject ok_button=new UiObject(new UiSelector().description("OK button"));
						ok_button.clickAndWaitForNewWindow(50000);
						Home_Activity_Test();
					}
				} catch (UiObjectNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	 }
	    	 
	    	 public void Home_Activity_Test() throws UiObjectNotFoundException{
	    		 /* Check for disabled buttons
	    		  * 
	    		  */
	    		 UiObject login_button = new UiObject(new UiSelector().description("home_login_disable_button")
		    			   .className("android.widget.ImageButton"));
	    		 UiObject register_button = new UiObject(new UiSelector().description("home_Register_Disabled_button")
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
	    	
