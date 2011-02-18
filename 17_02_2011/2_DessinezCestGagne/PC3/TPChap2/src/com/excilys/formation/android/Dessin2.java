package com.excilys.formation.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Dessin2 extends Activity {

	private TextView textView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main2);
		Button button1 = (Button) findViewById(R.id.button1);
		Button button2 = (Button) findViewById(R.id.button2);
		textView = (TextView) findViewById(R.id.txt);
		button1.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				textView.setText("Texte changé!");

			}
		});
		button2.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				setTitle("Youhouuuu");
			}
		});
	}

}
