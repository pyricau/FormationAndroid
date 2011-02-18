package org.ebi.graphics;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class NouvelleActivite extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.nouvelle_activite);
		Button sexyButton = (Button) findViewById(R.id.sexyButton);
        sexyButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				EditText myEditText = (EditText) findViewById(R.id.myEditText);
				Intent intent = new Intent(NouvelleActivite.this, NouvelleActiviteSuivante.class);
				intent.putExtra("paramKey", myEditText.getText().toString());
				startActivity(intent);
			}
		});
	}
}
