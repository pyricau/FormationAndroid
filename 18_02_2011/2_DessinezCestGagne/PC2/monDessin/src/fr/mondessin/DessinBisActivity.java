package fr.mondessin;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class DessinBisActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.declarative);
		
		findViewById(R.id.button1).setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				((TextView) findViewById(R.id.text)).setText("bla");
				
			}
		});
		
		findViewById(R.id.button2).setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				setTitle("bla");
				
			}
		});
	}

}
