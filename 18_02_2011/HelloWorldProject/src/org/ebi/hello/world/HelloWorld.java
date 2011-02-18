package org.ebi.hello.world;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class HelloWorld extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Log.i("HelloWorld", "You don't understand, I want a sheet on the bed");
	}

	@Override
	protected void onStart() {
		super.onStart();
		Log.i("HelloWorld", "Je suis dans la méthode toto onStart");
	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.i("HelloWorld", "Je suis dans la méthode onPause");
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		Log.i("HelloWorld", "Je suis dans la méthode onRestart");
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.i("HelloWorld", "Je suis dans la méthode onResume");
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub

		Log.i("HelloWorld", "Je suis dans la méthode onDestroy");
		super.onDestroy();
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		Log.i("HelloWorld", "Je suis dans la méthode onSave");
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onRestoreInstanceState(savedInstanceState);
		Log.i("HelloWorld", "Je suis dans la méthode onRestore");
	}

}
