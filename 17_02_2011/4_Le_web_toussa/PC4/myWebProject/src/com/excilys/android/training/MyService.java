package com.excilys.android.training;

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

public class MyService extends IntentService{

	private Handler handler;
	
	public MyService(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public MyService() {
		super("MyService");		
		handler = new Handler();
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		Log.i("MyService", "Appel de onHandleIntent");

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

			handler.post(new Runnable() {
				
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

}
