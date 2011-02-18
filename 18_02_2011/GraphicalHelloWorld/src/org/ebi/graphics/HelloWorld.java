package org.ebi.graphics;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HelloWorld extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout lLayout = new LinearLayout(this);
        lLayout.setOrientation(LinearLayout.VERTICAL);
        LayoutParams linearLayoutParams = new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT);
        
        final TextView textView = new TextView(this);
        LayoutParams textViewParams = new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT);
		textView .setText("blaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		textView.setLayoutParams(textViewParams);
		
        lLayout.addView(textView);
        
        Button button = new Button(this);
        button.setText("Click me!");
        button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				textView.setText("Le texte a changé");
				
			}
		});
        
        lLayout.addView(button);
		
        lLayout.setLayoutParams(linearLayoutParams);
        setContentView(lLayout);
 
    }
}