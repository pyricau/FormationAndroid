package com.ebi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class Broadcast extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
//		NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
//				
//		String contentTitle = "My notification";
//		String contentText = "Hello World!";		
//		Intent notificationIntent = intent;		
//		PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notificationIntent, 0);
//		
//		int icon = R.drawable.icon;
//		String statusText = "Hello";
//		long when = System.currentTimeMillis();
//		Notification notification = new Notification(icon, statusText, when);
//		
//		notification = new Notification(icon, "Notification", when);
//		notification.setLatestEventInfo(context, contentTitle, contentText, contentIntent);
//		notificationManager.notify(42, notification);
		Log.d("TOTO", "TOTOTOTOTOTOTOTO");

	}

}
