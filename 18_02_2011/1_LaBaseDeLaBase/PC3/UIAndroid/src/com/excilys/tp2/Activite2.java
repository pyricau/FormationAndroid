package com.excilys.tp2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Activite2 extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent intent = getIntent();
		setContentView(R.layout.activite2);
		((TextView) findViewById(R.id.textViewA2)).setText(intent
				.getStringExtra("paramKey"));


		Button button = (Button) findViewById(R.id.buttonA2);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Uri intentURL = Uri.parse("tel:"
						+ ((TextView) findViewById(R.id.textViewA2)).getText());
				Intent intent = new Intent(Intent.ACTION_DIAL, intentURL);

				startActivity(intent);
			}
		});
	}
}