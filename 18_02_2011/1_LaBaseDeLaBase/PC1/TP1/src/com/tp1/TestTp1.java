package com.tp1;

import android.app.Application;
import android.util.Log;

public class TestTp1 extends Application {

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		 Log.d("HelloWorld","onCreate Application");
	}

	@Override
	public void onTerminate() {
		// TODO Auto-generated method stub
		super.onTerminate();
		 Log.d("HelloWorld","onTerminate Application");
	}

	@Override
	public void onLowMemory() {
		// TODO Auto-generated method stub
		super.onLowMemory();
		 Log.d("HelloWorld","onLowMemory Application");
	}

}
