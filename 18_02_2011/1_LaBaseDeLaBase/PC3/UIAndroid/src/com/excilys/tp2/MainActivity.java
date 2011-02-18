package com.excilys.tp2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.declarative);

		Button button = (Button) findViewById(R.id.button);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				((TextView) findViewById(R.id.textView)).setText("désaoulé");

			}
		});

		Button buttonTitle = (Button) findViewById(R.id.buttonTitle);
		buttonTitle.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				setTitle("Nouveau titre");

			}
		});
	}
}