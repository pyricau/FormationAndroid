package com.excilys.android.training;


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
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MyWebActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().build());
        super.onCreate(savedInstanceState); 
        
        setContentView(R.layout.main);
        
        Button button = (Button) findViewById(R.id.bt1);
        button.setOnClickListener(new OnClickListener() {
			
        	
        	
			public void onClick(View v) {
				Runnable thread = new Runnable() {
					
					public void run() {
						String url = "https://ecoles.excilys.com/lms/secure/downloadAvatar.htm?username=fpchalopin";
						HttpUriRequest request = new HttpGet(url);
						HttpClient client = new DefaultHttpClient();
						HttpResponse response;
						try {
							response = client.execute(request);
							InputStream inputStream = response.getEntity().getContent();
							Context ctxt = getApplicationContext();
							final ImageView image = new ImageView(ctxt);
							Bitmap bmp = BitmapFactory.decodeStream(inputStream);
							image.setImageBitmap(bmp);
							
							runOnUiThread(new Runnable() {
								
								public void run() {
									Context ctxt = getApplicationContext();
									Toast toast = new Toast(ctxt);
									toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
									toast.setDuration(Toast.LENGTH_LONG);
									toast.setView(image);
									toast.show();
								}
							});
							
						} catch (ClientProtocolException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
						
					}
				};

				Thread th = new Thread(thread);
				th.start();
				
				
				
			}
		});
        
        
    }
}