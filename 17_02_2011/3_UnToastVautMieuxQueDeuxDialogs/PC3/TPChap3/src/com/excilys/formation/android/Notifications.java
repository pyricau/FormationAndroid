package com.excilys.formation.android;
import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class Notifications extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.notifmain);
		
		Button button  = (Button) findViewById(R.id.mybutton);
		button.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
				
			}
		});
		
	}
	
	
}
