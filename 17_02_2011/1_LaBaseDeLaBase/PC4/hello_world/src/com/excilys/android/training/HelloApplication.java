package com.excilys.android.training;

import android.app.Application;
import android.util.Log;

public class HelloApplication extends Application {
	
	@Override
	public void onCreate() {
		super.onCreate();
		Log.d("HelloApplication","onCreate()");
	}

	@Override
	public void onLowMemory() {
		super.onLowMemory();
		Log.d("HelloApplication","onLowMemory()");
	}
	
	
	@Override
	public void onTerminate() {
		super.onTerminate();
		Log.d("HelloApplication","onTerminate()");
	}
}
