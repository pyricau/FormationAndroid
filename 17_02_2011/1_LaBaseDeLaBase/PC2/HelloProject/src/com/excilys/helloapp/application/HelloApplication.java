package com.excilys.helloapp.application;

import android.app.Application;
import android.util.Log;

public class HelloApplication extends Application {

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		Log.i("HelloApplication","onCreate");
	}

	@Override
	public void onTerminate() {
		// TODO Auto-generated method stub
		super.onTerminate();
		Log.i("HelloApplication","onTerminate");
	}

	@Override
	public void onLowMemory() {
		// TODO Auto-generated method stub
		super.onLowMemory();
		Log.i("HelloApplication","onLowMemory");
	}

}
