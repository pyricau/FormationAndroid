package com.excilys.android.training;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MyHelloWorldScreen extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Log.i("Hello Android World", "onCreate()");
    }
    
    @Override
    protected void onStart() {
    	super.onStart();
    	Log.i("Hello Android World", "onStart()");
    }
    
    @Override
    protected void onRestart() {
    	super.onRestart();
    	Log.i("Hello Android World", "onRestart()");
    }
    
    @Override
    protected void onResume() {
    	super.onResume();
    	Log.i("Hello Android World", "onResume()");
    }
    
    @Override
    protected void onPause() {
    	super.onPause();
    	Log.i("Hello Android World", "onPause()");
    	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	Log.i("Hello Android World", "onPause() finisehd");
    	
    }
    
    @Override
    protected void onStop() {
    	super.onStop();
    	Log.i("Hello Android World", "onStop()");
    }
    
    @Override
    protected void onDestroy() {
    	super.onDestroy();
    	Log.i("Hello Android World", "onDestroy()");
    }
    
    @Override
    protected void onSaveInstanceState(Bundle outState) {
    	super.onSaveInstanceState(outState);
    	Log.i("Hello Android World", "onSaveInstanceState()");
    }
    
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
    	super.onRestoreInstanceState(savedInstanceState);
    	Log.i("Hello Android World", "onRestoreInstanceState()");
    }
}