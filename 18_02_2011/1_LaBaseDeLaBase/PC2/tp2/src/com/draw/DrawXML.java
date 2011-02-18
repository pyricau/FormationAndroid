package com.draw;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class DrawXML extends Activity {
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);
        
        final TextView textView = (TextView)findViewById(R.id.textView);
        Button button = (Button)findViewById(R.id.button1);
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
				textView.setText("Monkey2");
			
			}
        });
        
        Button button2 = (Button)findViewById(R.id.button2);
        button2.setText("change app name");
        button2.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
//				String title = getString(R.string.app_name);
				setTitle(R.string.app_name2);
			}
        });
        
    }

}
