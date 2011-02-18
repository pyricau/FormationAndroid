package com.excilys.formation.dessin;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends Activity{

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second);

		final TextView sexyView = (TextView) findViewById(R.id.sexyText);
		
		TextView linksView = (TextView) findViewById(R.id.links);
		Linkify.addLinks(linksView, Linkify.ALL);
		
		Intent intent = getIntent();
		String intentString = intent.getStringExtra("maSuperString");
		
		sexyView.setText(intentString);
		
		Button sexyButton = (Button) findViewById(R.id.sexyButton);
		sexyButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Uri uri = Uri.parse("tel:0123456789");
				Intent secondIntent = new Intent(Intent.ACTION_DIAL, uri);
				startActivity(secondIntent);
			}
		});
		
	}
}
