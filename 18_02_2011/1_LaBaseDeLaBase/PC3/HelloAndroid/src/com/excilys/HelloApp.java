package com.excilys;

import android.app.Application;
import android.util.Log;

public class HelloApp extends Application {

	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
        Log.d("HelloApp", "onCreate"); 

	}
	
	@Override
	public void onTerminate() {
		// TODO Auto-generated method stub
		super.onTerminate();
        Log.d("HelloApp", "onTerminate"); 
	}
	
	@Override
	public void onLowMemory() {
		// TODO Auto-generated method stub
		super.onLowMemory();
        Log.d("HelloApp", "onLowMemory"); 

	}
	

}
