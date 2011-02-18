package com.excilys.android.training;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		
		Log.i("onReceive", intent.toString());
		Log.i("intent.getData()", intent.getData().toString());
		
		
		Notification notif = new Notification(R.drawable.icon, "hello", System.currentTimeMillis());
		Intent starter = new Intent(context, MyActivity.class);
		PendingIntent contentIntent = PendingIntent.getActivity(context, 0, starter, 0);
		notif.setLatestEventInfo(context, "my notif", "text", contentIntent);
		NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
		
		manager.notify(42, notif);
		
	}

}
