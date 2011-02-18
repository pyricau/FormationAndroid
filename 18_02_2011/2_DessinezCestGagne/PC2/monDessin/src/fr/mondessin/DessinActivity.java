package fr.mondessin;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DessinActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        LinearLayout linearLayout = new LinearLayout(this);
        
        LayoutParams linearLayoutParams = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
        linearLayout.setLayoutParams(linearLayoutParams);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        
        setContentView(linearLayout);

        final TextView textView = new TextView(this);
        
        LayoutParams textViewParams = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
        
        linearLayout.addView(textView, textViewParams);
        
        Intent intent=getIntent();
        
        textView.setText(intent.getStringExtra("paramKey"));
        
        Button button = new Button(getBaseContext());
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	Uri intentUrl = Uri.parse("tel:"+textView.getText().toString());
            	Intent intent = new Intent(Intent.ACTION_DIAL, intentUrl);  
            	startActivity(intent);
            }
        });

        button.setText("OK");
        
        linearLayout.addView(button);
        
        Button button2 = new Button(getBaseContext());
        button2.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	setTitle("I'm a monkey lover");
            }
        });

        button2.setText("OK bis");
        
        linearLayout.addView(button2);
    }
}