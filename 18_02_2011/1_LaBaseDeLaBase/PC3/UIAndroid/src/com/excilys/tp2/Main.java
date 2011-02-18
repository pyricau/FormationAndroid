package com.excilys.tp2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Main extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		LayoutParams linearLayoutParams = new LayoutParams(
				LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
		LayoutParams textViewParams = new LayoutParams(
				LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
		final TextView textView = new TextView(this);
		textView.setText("PY est saoul");
		textView.setLayoutParams(textViewParams);

		Button button = new Button(this);
		button.setText("Bouton");
		button.setLayoutParams(textViewParams);
		Button buttonTitle = new Button(this);
		buttonTitle.setText("Bouton titre");
		buttonTitle.setLayoutParams(textViewParams);
		LinearLayout layout = new LinearLayout(this);
		layout.setLayoutParams(linearLayoutParams);
		layout.setOrientation(LinearLayout.VERTICAL);
		layout.addView(textView);
		layout.addView(button);
		layout.addView(buttonTitle);
		setContentView(layout);

		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				textView.setText("désaoulé");

			}
		});

		buttonTitle.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Main.this.setTitle("Nouveau titre");

			}
		});
	}
}