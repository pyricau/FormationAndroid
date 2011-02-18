package com.draw;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.util.Linkify;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActivityTextView extends Activity {
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main4);
        
        TextView textview = (TextView)findViewById(R.id.textViewReceiver);
        final Intent intent = getIntent();
        textview.setText(intent.getStringExtra("paramKey")) ;
        
        Button button = (Button)findViewById(R.id.button3);
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	Uri intentUrl = Uri.parse("tel:"+intent.getStringExtra("paramKey"));
            	Log.d("ActivityTextView",intentUrl.toString());
            	Intent intent2 = new Intent(Intent.ACTION_DIAL, intentUrl);
            	startActivity(intent2);


			}
        });

        TextView textviewCliquable = (TextView)findViewById(R.id.textViewCliquable);
        textviewCliquable.setText("http://www.google.fr");
        Linkify.addLinks(textviewCliquable, Linkify.ALL);
        
        
    }

}
