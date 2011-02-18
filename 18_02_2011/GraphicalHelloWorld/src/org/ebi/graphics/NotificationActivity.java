package org.ebi.graphics;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class NotificationActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.notification);
		
		Button button = (Button)findViewById(R.id.sexyButton);
		
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
				
				int icon = R.drawable.icon; 
				String statusText = "Hello"; 
				long when = System.currentTimeMillis(); 
				Notification notification = new Notification(icon, statusText, when);
				
				Context context = getApplicationContext();
				String contentTitle = "My notification";
				String contentText = "Hello World!";
				Intent notificationIntent = new Intent(NotificationActivity.this, NotificationActivity.class);
				PendingIntent contentIntent = PendingIntent.getActivity(NotificationActivity.this, 0, notificationIntent, 0);
				notification.setLatestEventInfo(context, contentTitle, contentText, contentIntent);
				
				notificationManager.notify(14,notification);
				
			}
		});
		
		

	}

}
