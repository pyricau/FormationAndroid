package com.excilys.formation.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


public class Dessin extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		LinearLayout layout = new LinearLayout(this);
		LayoutParams textViewParams = new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT);
		LayoutParams linearLayoutParams = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
		final TextView textView = new TextView(this);
		layout.setLayoutParams(linearLayoutParams);
		layout.setOrientation(LinearLayout.VERTICAL);
		setContentView(layout);        
		textView.setText("I've got a big monkey");
		layout.addView(textView);
		Button button = new Button(this);
		button.setText("Un bouton");
		button.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				textView.setText("Texte changé !");
			}
		});
		layout.addView(button);
		Button button2 = new Button(this);
		button2.setText("Un autre bouton");
		button2.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				setTitle("I'm a monkey lover");			
			}
		});
		layout.addView(button2);
	}
}