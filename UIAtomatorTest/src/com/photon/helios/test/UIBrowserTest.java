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

public class UIBrowserTest extends UiAutomatorTestCase{
	
	public void testBrowseVerification() throws UiObjectNotFoundException{
		
    final String LOG_TAG = "In UIBrowserTest";	
    
/*	getUiDevice().pressHome();
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
    sleep(50000);
	*/
	//Define watcher
    
    UiWatcher okCancelDialogWatcher = new UiWatcher() {
    	@Override
    	public boolean checkForCondition() {
    	
    	
    	UiObject browser_button = new UiObject(new UiSelector().description("home_browse_btn")
    			   .className("android.widget.ImageButton"));

    	if(browser_button.exists()){
    	Log.w(LOG_TAG, "Found the browser button");
    	try {
			browser_button.clickAndWaitForNewWindow(50000);
			Browser_Activity_test();
		    
    	} catch (UiObjectNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return (browser_button.waitUntilGone(25000));
    	}
    	return false;
    	}
    
    	 
    	};
    	// Register watcher
    	UiDevice.getInstance().registerWatcher("Check Browser status of app", okCancelDialogWatcher);
    	 
    	// Run watcher
    	UiDevice.getInstance().runWatchers();
    	
    	
	}	
	public void Browser_Activity_test() throws UiObjectNotFoundException{
		UiObject Tabbar=new UiObject(new UiSelector().description("Tabbar"));
		if(Tabbar.exists()){
			System.out.println("Tabbar exists");
		}
		sleep(50000);
		/*Get Category Item
		 * 
		 */
		UiScrollable listView = new UiScrollable(new UiSelector().className(android.widget.ListView.class.getName()));
		listView.setMaxSearchSwipes(100);
		//listView.scrollTextIntoView("Computers");
		listView.waitForExists(50000);
		UiObject listViewItem = listView.getChildByText(new UiSelector()
		        .className(android.widget.TextView.class.getName()), "Computers");
		listViewItem.clickAndWaitForNewWindow(50000);
		sleep(80000);
		/*Get Product Item
		 * 
		 */
		UiScrollable productView = new UiScrollable(new UiSelector().className(android.widget.ListView.class.getName()));
		productView.setMaxSearchSwipes(100);
		//listView.scrollTextIntoView("Computers");
		productView.waitForExists(50000);
		UiObject productItem = productView.getChildByInstance(new UiSelector()
		        .className(android.widget.TextView.class.getName()), 1);
		productItem.clickAndWaitForNewWindow(50000);
		sleep(50000);
		UiObject addToCart_button = new UiObject(new UiSelector().description("Add_to_Cart")
	 			   .className("android.widget.ImageView"));
		addToCart_button.clickAndWaitForNewWindow(30000);
		UiObject updateCart_button = new UiObject(new UiSelector().description("update_cart_button")
	 			   .className("android.widget.ImageButton"));
		updateCart_button.clickAndWaitForNewWindow(30000);
		UiObject viewCart_button = new UiObject(new UiSelector().description("View Cart")
	 			   .className("android.widget.ImageButton"));
		viewCart_button.clickAndWaitForNewWindow(30000);
		UiObject checkout_button = new UiObject(new UiSelector().description("Checkout")
	 			   .className("android.widget.ImageButton"));
		checkout_button.clickAndWaitForNewWindow(50000);
		Checkout_Activity_Test();
		
	}
    	 public void Checkout_Activity_Test() throws UiObjectNotFoundException{
    		/*Declaring delivery info
    		 *  
    		 */
    	     sleep(50000);
			 UiScrollable scrollview = new UiScrollable(new UiSelector().className("android.widget.ScrollView").scrollable(true));
			 scrollview.waitForExists(50000);
		     scrollview.setAsVerticalList();
    		
			// Form Filling Starts here 
    		 UiObject firstName=scrollview.getChildByDescription(new  UiSelector().className("android.widget.EditText"),"First Name");
    		 UiObject lastName=scrollview.getChildByDescription(new UiSelector().className("android.widget.EditText"),"Last Name");
    		 UiObject companyName=scrollview.getChildByDescription(new UiSelector().className("android.widget.EditText"),"company");
    		 UiObject address1=scrollview.getChildByDescription(new UiSelector().className("android.widget.EditText"),"Address1");
    		 UiObject address2=scrollview.getChildByDescription(new UiSelector().className("android.widget.EditText"),"Address2");
    		 UiObject city=scrollview.getChildByDescription(new UiSelector().className("android.widget.EditText"),"City");
    		 UiObject state=scrollview.getChildByDescription(new UiSelector().className("android.widget.EditText"),"State");
    		 UiObject country=scrollview.getChildByDescription(new UiSelector().className("android.widget.EditText"),"Country");
    		 UiObject zipcode=scrollview.getChildByDescription(new UiSelector().className("android.widget.EditText"),"zipcode");
    		 UiObject phone=scrollview.getChildByDescription(new UiSelector().className("android.widget.EditText"),"phone"); 
    		 /*Filling up the form
    		  * 
    		  */
    		 scrollview.scrollIntoView(firstName);
    		 firstName.setText("Anderson");
    		 scrollview.scrollIntoView(lastName);
    		 lastName.setText("Major");
    		 scrollview.scrollIntoView(companyName);
    		 companyName.setText("Photon");
    		 address1.setText("Helios");
    		 address2.setText("california");
    		 city.setText("Newyark");
    		 state.setText("USA");
    		 country.setText("US");
    		 zipcode.setText("000332");
    		 phone.setText("9943113592");
    		 /*Click checkbox for billing info
    		  * 
    		  */
    		 UiObject checkbox=new UiObject(new UiSelector().className(android.widget.CheckBox.class.getName()));
    		 if (checkbox.isCheckable()){
    			 checkbox.click();
    		 }
    		 UiObject radiobox=new UiObject(new UiSelector().className(android.widget.RadioButton.class.getName()));
    		 radiobox.click();
    		 UiObject commentBox=new UiObject(new UiSelector().className(android.widget.EditText.class.getName()));
    		 commentBox.setText("Nice");
    		 UiObject reviewButton=new UiObject(new UiSelector().className(android.widget.ImageButton.class.getName()));
    		 reviewButton.clickAndWaitForNewWindow(50000);
    	 }
} 	 

