package com.excilys.web;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpResponse;
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

public class MyIntentService extends IntentService {
	
	private Handler handler;

	public MyIntentService() {
		super("");
		handler = new Handler();
	}
	
	@Override
	protected void onHandleIntent(Intent intent) {
		Log.i("WebAndroid","Mon service a fait quelque chose!!!!");
		final InputStream inputStream; 
		try {
			String url = "https://ecoles.excilys.com/lms/secure/downloadAvatar.htm?username=jbriche";
			HttpUriRequest request = new HttpGet(url);
			HttpClient client = new DefaultHttpClient();
			HttpResponse response = client.execute(request);
		    inputStream = response.getEntity().getContent();
		} catch(IOException e){
			e.printStackTrace();
			return;
		} catch(IllegalArgumentException e){
			e.printStackTrace();
			return;
		}
//		final InputStream is2 =inputStream;
		handler.post(new Runnable() {
			@Override
			public void run() {
				Context context = getApplicationContext();
				ImageView imageView = new ImageView(context);
				Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
				imageView.setImageBitmap(bitmap);
				Toast toast = new Toast(context);
				toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
				toast.setDuration(Toast.LENGTH_LONG);
				toast.setView(imageView);
				toast.show();
			}
		});
		
	}

}
