package com.excilys.web;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class Receiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
		
		int icon = R.drawable.icon; 
		String statusText = "Rajout nouvelle appli"; 
		long when = System.currentTimeMillis(); 
		Notification notification = new Notification(icon, statusText, when);
		
		String contentTitle = intent.getData().getSchemeSpecificPart();
		String contentText ="" ;
		Intent notificationIntent = new Intent(context, WebActivity.class);
		PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notificationIntent, 0);
		notification.setLatestEventInfo(context, contentTitle, contentText, contentIntent);
		
		notificationManager.notify(14,notification);

	}

}
