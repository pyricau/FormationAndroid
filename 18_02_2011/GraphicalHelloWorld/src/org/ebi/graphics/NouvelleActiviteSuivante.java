package org.ebi.graphics;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class NouvelleActiviteSuivante extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.nouvelle_activite_suivante);
		
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		TextView myText = (TextView) findViewById(R.id.myNewText);
		Intent intent = getIntent();
		final String number = intent.getStringExtra("paramKey");
		myText.setText(number);
		
		Button phoneButton = (Button) findViewById(R.id.phoneButton);
        phoneButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Uri intentUrl = Uri.parse("tel:"+number);
				Intent intent = new Intent(Intent.ACTION_DIAL, intentUrl);
				startActivity(intent);
			}
		});
	}
}
