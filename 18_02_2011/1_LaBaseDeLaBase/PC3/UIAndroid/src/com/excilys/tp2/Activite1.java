package com.excilys.tp2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activite1 extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activite1);
		Linkify.addLinks((TextView) findViewById(R.id.textViewA1), Linkify.ALL);

		Button button = (Button) findViewById(R.id.buttonA1);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Activite1.this, Activite2.class);
				intent.putExtra("paramKey",
						((EditText) findViewById(R.id.editText)).getText()
								.toString());
				startActivity(intent);
			}
		});
	}
}