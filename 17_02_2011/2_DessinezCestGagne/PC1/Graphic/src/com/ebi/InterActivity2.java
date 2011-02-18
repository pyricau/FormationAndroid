package com.ebi;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class InterActivity2 extends Activity {

	String param;
	TextView smsText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.interlayout2);

		Intent intent = getIntent();
		param = intent.getStringExtra("texte");

		TextView tv = (TextView) findViewById(R.id.textView1);
		tv.setText(param);

		Button butCall = (Button) findViewById(R.id.button1);
		Button butSms = (Button) findViewById(R.id.sms);
		smsText = (TextView) findViewById(R.id.smsText);

		butCall.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				Intent intent = new Intent(Intent.ACTION_VIEW);
				intent.putExtra("sms_body", smsText.getText());
				intent.setData(Uri.parse("sms:"));
				startActivity(intent);
			}
		});

		butCall.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Uri intentUrl = Uri.parse("tel:" + param);
				Intent intent = new Intent(Intent.ACTION_DIAL, intentUrl);
				startActivity(intent);
			}
		});

	}
}
