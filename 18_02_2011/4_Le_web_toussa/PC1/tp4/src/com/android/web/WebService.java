package com.android.web;

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
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.Toast;

public class WebService extends IntentService {
	public Handler handler;
	
	public WebService(String name) {
		super(name);
		handler=new Handler();
		// TODO Auto-generated constructor stub
	}
	
	public WebService(){super("WebService");
	handler=new Handler();
	}
	
	@Override
	protected void onHandleIntent(Intent intent) {
		final ImageView imageView = new ImageView(getApplicationContext());
		try {
		   	String url = "https://ecoles.excilys.com/lms/secure/downloadAvatar.htm?username=jbriche";
    		HttpUriRequest request = new HttpGet(url);
    		HttpClient client = new DefaultHttpClient();
    		HttpResponse response;
			response = client.execute(request);
			InputStream inputStream = response.getEntity().getContent();   		
    		Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
    		imageView.setImageBitmap(bitmap);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		handler.post(new Runnable() {
		        public void run() {
					Toast toast = new Toast(getApplicationContext());
					toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
					toast.setDuration(Toast.LENGTH_LONG);
					toast.setView(imageView);
					toast.show();

		        }
		});

	}

}
