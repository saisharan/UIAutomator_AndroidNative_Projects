package com.photon.helios.mainActivity;
import android.test.FlakyTest;
import android.test.suitebuilder.annotation.LargeTest;
import android.util.Log;
import android.view.KeyEvent;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.github.rtyley.android.screenshot.celebrity.Screenshots;
import com.photon.helios.test.UILoginTest;
import com.photon.helios.test.UIRegistrationTest;
import com.photon.helios.test.UIBrowserTest;
import com.photon.helios.test.UISpecialOfferTest;

public class MainActivity extends UiAutomatorTestCase {
    
    private static final int TIMEOUT_DURING_APP_SEARCH = 50000;
	private static final int MAX_SEARCH_SWIPES_IN_APP_MENU = 15;
    private static final int TEST_TOLERANCE = 3;
    private String currentTestName;
    private int currentScreenshotIndex;
    private UILoginTest Login;
    private UIRegistrationTest Register;
    private UIBrowserTest Browse;
    private UISpecialOfferTest SplOffers;
	//private String Login=Login;
    
    private static final String TAG = "****MainActivity TestCase****";
    
    private void setCurrentTestName(String testName) {
        this.currentScreenshotIndex = 0;
        this.currentTestName = testName;
        
    }

   private void takeScreenshot(String name) {
        getUiDevice().waitForIdle();
        Screenshots.poseForScreenshotNamed(currentTestName + "_" + currentScreenshotIndex++ + "_"
            + name);
    }
   
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        unlockEmulator();
    }


    
    // LoginTestCase implementation
    @LargeTest
    @FlakyTest(tolerance = TEST_TOLERANCE)
    public void testLoginVerification() throws UiObjectNotFoundException {
    	
       try
       {
    	setCurrentTestName("testLoginVerification");
    	startAppOnEmulator();
    	Log.i(TAG,"testLoginVerification------Start");
    	Login=new UILoginTest();
    	Login.testLoginValidation();
    	Log.i(TAG,"testLoginVerification------End");
        Screenshots.poseForScreenshotNamed(currentTestName);
       }
       catch (UiObjectNotFoundException e)
       {
    	   e.printStackTrace();
    	   Screenshots.poseForScreenshotNamed(currentTestName);
       }
      }
  // Registration Verification
    @LargeTest
    @FlakyTest(tolerance = TEST_TOLERANCE)
    public void testRegistration() throws UiObjectNotFoundException {
    	  try
          {
       	setCurrentTestName("testRegistration");
		startAppOnEmulator();
       	Log.i(TAG,"testRegistration------Start");
       	Register=new UIRegistrationTest();
       	Register.testRegistration();
       	Log.i(TAG,"testRegistration------End");
          
          }
          catch (UiObjectNotFoundException e)
          {
       	   e.printStackTrace();
		   Screenshots.poseForScreenshotNamed(currentTestName);
       	   //takeScreenshot("Registration");
          }
        }
    //Browse testcase implementation
    @LargeTest
    @FlakyTest(tolerance = TEST_TOLERANCE)
    public void testsBrowseVerification() throws UiObjectNotFoundException {
    	

    	   try
           {
        	setCurrentTestName("testsBrowseVerification");
			startAppOnEmulator();
        	Log.i(TAG,"testsBrowseVerification------Start");
        	Browse=new UIBrowserTest();
        	Browse.testBrowseVerification();
        	Log.i(TAG,"testsBrowseVerification------End");
           
           }
           catch (UiObjectNotFoundException e)
           {
        	   e.printStackTrace();
			   Screenshots.poseForScreenshotNamed(currentTestName);
        	  //takeScreenshot("Browse");
           }
          
        }
    //Special Offers Testcase implementation 
    @LargeTest
    @FlakyTest(tolerance = TEST_TOLERANCE)
    public void testtSpecialOffersTest() throws UiObjectNotFoundException {
    	

    	   try
           {
        	setCurrentTestName("testtSpecialOffersTest");
			startAppOnEmulator();
        	Log.i(TAG,"testtSpecialOffersTest------Start");
        	SplOffers=new UISpecialOfferTest();
        	SplOffers.testtSpecialOffersTest();
        	Log.i(TAG,"testtSpecialOffersTest------End");
           
           }
           catch (UiObjectNotFoundException e)
           {
        	   e.printStackTrace();
        	   //takeScreenshot("SpecialOffers");
           }
          
        }
  
    
   

    private void startAppOnEmulator() throws UiObjectNotFoundException {
        // Simulate a short press on the HOME button.
    	getUiDevice().pressHome();
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
	    UiObject apiDemoApp = appViews.getChildByText(new UiSelector().className(android.widget.TextView.class.getName()), "AndroidNativeEshop");
	    apiDemoApp.clickAndWaitForNewWindow();
	    sleep(50000);
	    
    }
    private void unlockEmulator() {
        getUiDevice().pressKeyCode(KeyEvent.KEYCODE_SOFT_LEFT);
        getUiDevice().pressKeyCode(KeyEvent.KEYCODE_SOFT_RIGHT);
        getUiDevice().pressKeyCode(KeyEvent.KEYCODE_MENU);
        getUiDevice().pressKeyCode(KeyEvent.KEYCODE_MENU);
    }
    
    
    @Override
    protected void tearDown() throws Exception {
      
        // Simulate a short press on the HOME button.
        getUiDevice().pressHome();
        super.tearDown();
    }
}
   



