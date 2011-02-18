package com.excilys.toasts;

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

public class NotifActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.notif_layout);
		
		Button btn = (Button) findViewById(R.id.butNotif);
		btn.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
				int icon = android.R.drawable.alert_dark_frame;
				String statusText = "Hello";
				long when = System.currentTimeMillis();
				Notification notification = new Notification(icon, statusText, when);
				
				Context context = getApplicationContext();
				String contentTitle = "My notification";
				String contentText = "Hello World!";
				Intent notificationIntent = new Intent(context, MainActivity.class);
				PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notificationIntent, 0);
				notification.setLatestEventInfo(context, contentTitle, contentText, contentIntent);


				notificationManager.notify(420, notification);
			}
		});
		
	}
}
