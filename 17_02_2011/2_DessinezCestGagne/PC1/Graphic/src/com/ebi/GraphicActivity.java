package com.ebi;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.*;

public class GraphicActivity extends Activity {
    TextView textView;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout layout = new LinearLayout(this);
        LayoutParams linearLayoutParams = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
        layout.setLayoutParams(linearLayoutParams);
        layout.setOrientation(LinearLayout.VERTICAL);
        
        textView = new TextView(this);
        textView.setText("I'm the best");
        LayoutParams textViewParams = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
        layout.addView(textView, textViewParams);
        
        Button but = new Button(this);
        but.setText("bouton a cliquer");
        but.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				textView.setText("le bouton a ete clique");
			}
    });

        LayoutParams butParams = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
        layout.addView(but, butParams);
        
        Button but2 = new Button(this);
        but2.setText("changer le titre de la fenetre");
        but2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				setTitle("Notre super appli :)");
			}
    });

        LayoutParams but2Params = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
        layout.addView(but2, but2Params);
        
        setContentView(layout);
    }
}