package com.excilys.tp4;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyInstallReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// int icon = R.drawable.icon;
		// String statusText = "Hello";
		// long when = System.currentTimeMillis();
		// Notification notification = new Notification(icon, statusText, when);
		// NotificationManager notificationManager = (NotificationManager)
		// context
		// .getSystemService(Context.NOTIFICATION_SERVICE);
		// String contentTitle = "My notification";
		// String contentText = "Hello World!";
		// // PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
		// // intent, 0);
		// // notification.setLatestEventInfo(context, contentTitle,
		// contentText,
		// // contentIntent);
		// notificationManager.notify(42, notification);
		Log.d("tag", "avant");
		try {
			Thread.sleep(150000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Log.d("tag", "apres");
	}

}
