package com.excilys.formation.android;

import android.app.Application;
import android.util.Log;

public class MaClasse extends Application {

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		Log.d("MaClasse","onCreate");
	}

	@Override
	public void onTerminate() {
		// TODO Auto-generated method stub
		super.onTerminate();
		Log.d("MaClasse","onTerminate");
	}

	@Override
	public void onLowMemory() {
		// TODO Auto-generated method stub
		super.onLowMemory();
		Log.d("MaClasse","onLowMemory");
	}
	
	

}
