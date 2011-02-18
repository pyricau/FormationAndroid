package org.ebi.graphics;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class XMLTrail extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.trail);
		Button sexyButton = (Button) findViewById(R.id.sexyButton);
        sexyButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				((TextView)findViewById(R.id.myText)).setText("Le texte a changé");
			}
		});
	}
}
