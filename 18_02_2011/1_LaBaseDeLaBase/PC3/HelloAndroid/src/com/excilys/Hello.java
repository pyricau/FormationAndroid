package com.excilys;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class Hello extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
        
    	setContentView(R.layout.main);
        Log.i("HelloAndroidWorld", "onCreate");
    }
    
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("HelloAndroidWorld", "onStart"); 
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("HelloAndroidWorld", "onResume"); 
    }
    
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("HelloAndroidWorld", "onRestart"); 
    }
    
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("HelloAndroidWorld", "onPause");
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("HelloAndroidWorld", "onStop"); 
    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("HelloAndroidWorld", "onDestroy"); 
    }


	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onRestoreInstanceState(savedInstanceState);
        Log.d("HelloAndroidWorld", "onRestoreInstanceState"); 
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
        Log.d("HelloAndroidWorld", "onSaveInstanceState"); 

	}   
    
    
}