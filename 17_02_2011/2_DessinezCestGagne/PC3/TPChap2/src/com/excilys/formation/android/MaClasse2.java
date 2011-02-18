package com.excilys.formation.android;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MaClasse2 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main4);
		TextView tv= (TextView)findViewById(R.id.txt);
		Button button2 = (Button) findViewById(R.id.button2);
		Intent intent=getIntent();
		final String param=intent.getStringExtra("leTexte");
		tv.setText(param);
		Log.i("MaClasse2","Param :"+param);
		button2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Uri intentUrl = Uri.parse("tel:"+param);
				Log.i("MaClasse2","intentUrl "+intentUrl.toString());
				Intent intent2=new Intent(Intent.ACTION_DIAL, intentUrl);
				startActivity(intent2);
				
			}
		});
		
	}


	
}
