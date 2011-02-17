package com.excilys.android.dessiner;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class InterActivity extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.my_third_layout);
		Button button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Uri intentUrl = Uri.parse("tel:0688888888");
				Intent dialIntent = new Intent(Intent.ACTION_DIAL, intentUrl);
				startActivity(dialIntent);
			}
		});
		
		Intent intent = getIntent();
		String param = intent.getStringExtra("paramKey");
		
		TextView tv = (TextView) findViewById(R.id.txt2);
		tv.setText(param);
		
		
	}

}
