package com.draw;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Drawing extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutParams linearLayoutParams = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
        LinearLayout layout = new LinearLayout(this);
        layout.setLayoutParams(linearLayoutParams);
        layout.setOrientation(LinearLayout.VERTICAL);
        setContentView(layout);
        
        LayoutParams textViewParams = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
        final TextView textview = new TextView(this);
        Button button = new Button(this);
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
				textview.setText("Monkey2");
			
			}
        });
        
        Button button2 = new Button(this);
        button2.setText("change app name");
        button2.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
//				String title = getString(R.string.app_name);
				setTitle(R.string.app_name2);
			}
        });

        textview.setLayoutParams(textViewParams);
        
        textview.setText("Monkey");
        layout.addView(textview);
        layout.addView(button);
        layout.addView(button2);
        
        
    }
}