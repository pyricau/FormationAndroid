package com.excilys.web;

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
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().build());
        setContentView(R.layout.web_android);
        
        Button button = (Button) findViewById(R.id.myButton);
        button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				final Thread thread = new Thread(new Runnable() {
					@Override
					public void run() {
						try {
							String url = "https://ecoles.excilys.com/lms/secure/downloadAvatar.htm?username=jbriche";
							HttpUriRequest request = new HttpGet(url);
							HttpClient client = new DefaultHttpClient();
							HttpResponse response = client.execute(request);
							final InputStream inputStream = response.getEntity().getContent();
							runOnUiThread(new Runnable() {
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

						} catch(IOException e){
							e.printStackTrace();
						} catch(IllegalArgumentException e){
							e.printStackTrace();
						}
						
					}
				});
				thread.start();
			}
		});
        
        Button buttonService = (Button) findViewById(R.id.myServiceButton);
        buttonService.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intentService = new Intent(WebActivity.this,MyIntentService.class);
				startService(intentService);
			}
		});
        
        Button buttonafter = (Button) findViewById(R.id.myButtonBis);
        buttonafter.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.i("WebAndroid","Je fais autre chose!!!");
			}
		});
        
    }

    
    
    
}