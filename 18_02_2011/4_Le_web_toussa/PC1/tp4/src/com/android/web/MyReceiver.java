package com.android.web;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		
		Log.i("Broadcast", "ok received");
		NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
		int icon = R.drawable.icon;
		String statusText = "Hello";
		long when = System.currentTimeMillis(); 
		Notification notification = new Notification(icon, statusText, when);
		notificationManager.notify(42, notification);
	}

}
