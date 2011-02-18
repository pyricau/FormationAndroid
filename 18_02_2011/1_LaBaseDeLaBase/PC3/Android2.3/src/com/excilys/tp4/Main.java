package com.excilys.tp4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;

public class Main extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
				.penaltyDeath().detectNetwork().build());

		LayoutParams linearLayoutParams = new LayoutParams(
				LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
		LayoutParams textViewParams = new LayoutParams(
				LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);

		LinearLayout layout = new LinearLayout(this);
		layout.setLayoutParams(linearLayoutParams);
		layout.setOrientation(LinearLayout.VERTICAL);

		Button button = new Button(this);
		button.setText("NOTIFIER");

		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Main.this, Service.class);
				startService(intent);

			}
		});

		layout.addView(button);
		setContentView(layout);

	}
}