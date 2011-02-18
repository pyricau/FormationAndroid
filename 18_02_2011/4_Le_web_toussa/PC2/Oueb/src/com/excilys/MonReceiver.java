package com.excilys;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MonReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		NotificationManager notificationManager = (NotificationManager)  context.getSystemService(Context.NOTIFICATION_SERVICE);
		int icon = R.drawable.icon; 
		String statusText = "Hello"; 
		long when = System.currentTimeMillis(); 
		Notification notification = new Notification(icon, statusText, when);
		String contentTitle = "My notification"; 
		String contentText = "Hello World!";
		Intent notificationIntent = new Intent(context, OuebActivity.class); 
		PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notificationIntent, 0); 
		notification.setLatestEventInfo(context, contentTitle, contentText, contentIntent);
		notificationManager.notify(42, notification); 

	/*	try {
			Log.i("bouh", "booh");
			Thread.sleep(15000);
			Log.i("fou", "booh");
			Toast.makeText(context, "coucou", Toast.LENGTH_LONG).show();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}

}
