package com.excilys.formation.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MaClasse extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main3);
		final Intent intent = new Intent(this,MaClasse2.class);
		final EditText et=(EditText)findViewById(R.id.et);
		Button button = (Button)findViewById(R.id.button1);
		button.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				intent.putExtra("leTexte", et.getText().toString());
				startActivity(intent);
			}
		});
		
		
	}


	
}
