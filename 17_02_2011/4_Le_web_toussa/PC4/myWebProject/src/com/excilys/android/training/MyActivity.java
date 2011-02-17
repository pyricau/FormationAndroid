package com.excilys.android.training;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MyActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Button b = (Button) findViewById(R.id.bt1);
		b.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent intent=new Intent(MyActivity.this,MyService.class);
				startService(intent);
			}
		});
	}

	
}
