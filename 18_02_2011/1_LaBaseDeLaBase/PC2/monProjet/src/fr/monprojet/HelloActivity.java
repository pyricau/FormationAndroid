package fr.monprojet;

import java.lang.reflect.Field;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class HelloActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        try {
			Field declaredField = Activity.class.getDeclaredField("mCalled");
			declaredField.setAccessible(true);
			declaredField.setBoolean(this, true);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        setContentView(R.layout.main);
        Log.i("HelloAndroidWorld", "You don't understand, I want a sheet on the bed");
    }

	@Override
	protected void onPause() {
		super.onPause();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Log.i("HelloAndroidWorld", "pause");
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		Log.i("HelloAndroidWorld", "restore");
	}

	@Override
	protected void onStart() {
		super.onStart();
		Log.i("HelloAndroidWorld", "start");
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		Log.i("HelloAndroidWorld", "restart");
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.i("HelloAndroidWorld", "resume");
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		Log.i("HelloAndroidWorld", "save");
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.i("HelloAndroidWorld", "stop");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.i("HelloAndroidWorld", "destroy");
	}
    
    
}