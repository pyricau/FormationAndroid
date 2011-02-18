package com.ebi;

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

public class MyService extends IntentService {
	
	InputStream inputStream;
	private Handler handler;

	public MyService() {
		super("");
		
		handler = new Handler();

	}

	public MyService(String name) {
		super(name);
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		Log.d("SERVICE", "YEAAAAAAAAH!!!!");
		String url = "https://ecoles.excilys.com/lms/secure/downloadAvatar.htm?username=fpchalopin";
		HttpUriRequest request = new HttpGet(url);
		HttpClient client = new DefaultHttpClient();
		HttpResponse response;
		
		try {
			response = client.execute(request);
			inputStream = response.getEntity().getContent();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		handler.post(new Runnable() {
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
