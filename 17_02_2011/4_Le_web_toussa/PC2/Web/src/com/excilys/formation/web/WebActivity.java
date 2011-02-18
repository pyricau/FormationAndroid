package com.excilys.formation.web;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class WebActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
				.detectNetwork().penaltyLog().build());

		Button btnTelecharger = (Button) findViewById(R.id.btnWeb);
		btnTelecharger.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				new MyThread().start();
			}
		});
		
		Button btnService = (Button) findViewById(R.id.btnService);
		btnService.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Log.i("WebActivity", "methode onClick");
				Intent intent = new Intent(WebActivity.this, MyService.class);
				startService(intent);
			}
		});
	}
	
	class MyThread extends Thread {
		@Override
		public void run() {
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
				
				runOnUiThread(new MyRunnable());
				

			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}