package com.ebi;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class baseActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
	    Log.d("HelloAndroidWorld", "onCreate");
//    	throw new RuntimeException();
                
    }

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onRestoreInstanceState(savedInstanceState);
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
	}

	@Override
	protected void onResume() {
	    super.onResume();
	    Log.d("HelloAndroidWorld", "onResume");
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		try {
		    Log.d("HelloAndroidWorld", "avt Pause");
			Thread.sleep(5000);
		    Log.d("HelloAndroidWorld", "apr Pause");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	    Log.d("HelloAndroidWorld", "onDestroy");
	}

	@Override
	public void onLowMemory() {
		super.onLowMemory();
	    Log.d("HelloAndroidWorld", "onLowm");
	}
}