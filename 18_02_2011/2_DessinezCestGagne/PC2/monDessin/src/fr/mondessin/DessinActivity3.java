package fr.mondessin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DessinActivity3 extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);





		setContentView(R.layout.declarative2);
		Linkify.addLinks((TextView)findViewById(R.id.text2), Linkify.ALL);
		
		findViewById(R.id.button).setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Intent intent = new Intent(DessinActivity3.this, DessinActivity.class);
				String chaine=((EditText)findViewById(R.id.edit)).getText().toString();
				intent.putExtra("paramKey",chaine );
				startActivity(intent);
			}
		});
		
	

		
		
		
	}
}