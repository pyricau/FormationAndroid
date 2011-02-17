package com.excilys.android.dessiner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Drawer2 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.my_second_layout);
		Button button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				EditText text = (EditText)findViewById(R.id.txt1);
				
				
				Intent intent = new Intent(Drawer2.this,InterActivity.class);
				intent.putExtra("paramKey", text.getText().toString());
				startActivity(intent);
			}
		});
		
		Button button2 = (Button) findViewById(R.id.button2);
		button2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				setTitle(R.string.title2);
			}
		});
		
		
	}
}
