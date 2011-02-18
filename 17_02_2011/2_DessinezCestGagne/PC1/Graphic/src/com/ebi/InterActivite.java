package com.ebi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class InterActivite extends Activity {

	EditText edit;

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.interlayout);

		edit = (EditText) findViewById(R.id.editText1);
		Button but = (Button) findViewById(R.id.button1);

		but.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(), InterActivity2.class);
				intent.putExtra("texte", edit.getText().toString());
				startActivity(intent);
			}
		});

		TextView links = (TextView) findViewById(R.id.txtLinks);
		Linkify.addLinks(links, Linkify.ALL);
	}
}
