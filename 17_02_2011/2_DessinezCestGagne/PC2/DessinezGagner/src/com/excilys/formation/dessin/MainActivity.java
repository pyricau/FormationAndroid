package com.excilys.formation.dessin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final EditText editText = (EditText) findViewById(R.id.mainEditText);
        final Button button = (Button) findViewById(R.id.mainButton);
        
        button.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				final Intent intent = new Intent(MainActivity.this, SecondActivity.class);
		        intent.putExtra("maSuperString", editText.getText().toString());
		        startActivity(intent);
			}
		});
    }
}