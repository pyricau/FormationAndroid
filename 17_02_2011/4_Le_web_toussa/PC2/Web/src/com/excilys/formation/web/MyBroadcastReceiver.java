package com.excilys.formation.web;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;


public class MyBroadcastReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, final Intent intent) {
		Log.i("MyBroadcastReceiver", "nouveau package installé : " + intent.getDataString());
//		
//		new Thread(){
//			public void run() {
//				
//				Log.i("MyBroadcastReceiver", "nouveau package installé"+intent.toString());
//			};
//			
//		}.start();
	}

}
