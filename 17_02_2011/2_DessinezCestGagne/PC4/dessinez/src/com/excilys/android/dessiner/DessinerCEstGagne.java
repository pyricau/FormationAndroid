package com.excilys.android.dessiner;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DessinerCEstGagne extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		LayoutParams linearLayoutParams = new LayoutParams(
				LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);

		LinearLayout layout = new LinearLayout(this);
		layout.setLayoutParams(linearLayoutParams);
		layout.setOrientation(LinearLayout.VERTICAL);
		LayoutParams textViewParams = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
		
		final TextView textView = new TextView(this);
		textView.setText("I've got a big monkey");
		layout.addView(textView);

		Button button = new Button(this);
		button.setText("Click me");
		
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				textView.setText("I've got a little monkey");
			}
		});
		
		layout.addView(button);

		
		Button buttonChangementTitreFenetre = new Button(this);
		buttonChangementTitreFenetre.setText("Change title");
		
		buttonChangementTitreFenetre.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				setTitle("I'm a monkey lover");
			}
		});
		
		layout.addView(buttonChangementTitreFenetre);
		
		
		setContentView(layout);

	}
}