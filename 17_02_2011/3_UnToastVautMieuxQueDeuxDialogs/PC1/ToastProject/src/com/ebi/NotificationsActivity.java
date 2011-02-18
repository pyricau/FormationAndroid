package com.ebi;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class NotificationsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		setContentView(R.layout.list);
		
		int icon = R.drawable.icon;
		String statusText = "Hello";
		long when = System.currentTimeMillis();
		
		Notification notification = new Notification(icon, statusText, when);
		Context context = getApplicationContext();
		String contentTitle = "My notification";
		String contentText = "Hello World!";
		Intent notificationIntent = new Intent(this, ToastActivity.class);
		PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);
		notification.setLatestEventInfo(context, contentTitle, contentText, contentIntent);
		notificationManager.notify(42, notification); 


	}
}
