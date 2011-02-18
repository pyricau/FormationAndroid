package com.ebi;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class NewActivity extends Activity {

	TextView text;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.newlayout);
		
		Button button1 = (Button) findViewById(R.id.button1);
		Button button2 = (Button) findViewById(R.id.button2);
		text = (TextView) findViewById(R.id.textView1);

		button1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				text.setText("le bouton a ete clique");
			}
		});

		button2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				setTitle("Notre super appli :)");
			}
		});
	}

}
