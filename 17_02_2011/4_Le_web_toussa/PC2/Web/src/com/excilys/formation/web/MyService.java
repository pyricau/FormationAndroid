package com.excilys.formation.web;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.Toast;

public class MyService extends IntentService {
	
	private Handler handler;
	
	public MyService(){
		super("ilu");
		handler = new Handler();
		Log.i("MyService", "ctor sans param");
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		Log.i("MyService", "methode onHandleIntent");
		
		String url = "https://ecoles.excilys.com/lms/secure/downloadAvatar.htm?username=jbriche";
		HttpUriRequest request = new HttpGet(url);
		HttpClient client = new DefaultHttpClient();
		HttpResponse response;
		try {
			response = client.execute(request);
			InputStream inputStream = response.getEntity().getContent();
			final Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
			
			class MyRunnable implements Runnable {
				public void run() {
					Context context = getApplicationContext();
					ImageView imageView = new ImageView(context);
					imageView.setImageBitmap(bitmap);

					Toast toast = new Toast(context);
					toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
					toast.setDuration(Toast.LENGTH_LONG);
					toast.setView(imageView);
					toast.show();
				}
			}
			
			handler.post(new MyRunnable());
			

		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
