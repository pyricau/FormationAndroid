package com.draw;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class ActivityEdit extends Activity {
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main3);
        
        final EditText editText = (EditText)findViewById(R.id.editText);
        Button button = (Button)findViewById(R.id.button1);
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	Intent intent = new Intent(v.getContext(), ActivityTextView.class);
            	intent.putExtra("paramKey", editText.getText().toString());
            	startActivity(intent);

			}
        });
        
    }

}
