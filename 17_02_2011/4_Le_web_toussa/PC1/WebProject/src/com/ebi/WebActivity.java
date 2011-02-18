package com.ebi;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpResponse;
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
		StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
				.penaltyDeath()
				.detectNetwork().build());
		
		class go implements Runnable {
			public void run() {
				String url = "https://ecoles.excilys.com/lms/secure/downloadAvatar.htm?username=fpchalopin";
				HttpUriRequest request = new HttpGet(url);
				HttpClient client = new DefaultHttpClient();
				HttpResponse response;		
				try {					
					response = client.execute(request);
					InputStream inputStream = response.getEntity().getContent();
					Context context = getApplicationContext();
					ImageView imageView = new ImageView(context);
					Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
					imageView.setImageBitmap(bitmap);
					Toast toast = new Toast(context);
					toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
					toast.setDuration(Toast.LENGTH_LONG);
					toast.setView(imageView);
					toast.show();
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}				
			}
			
		}
////		new Thread(new go()).start();
//		
//		runOnUiThread(new go());		



		
		setContentView(R.layout.service);
		
		Button b = (Button) findViewById(R.id.click);
		
		b.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(WebActivity.this, MyService.class);
				startService(intent);				
			}
		});

	}
}