package com.excilys.tp4;

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

public class Service extends IntentService {

	private Handler handler;

	public Service() {
		super("Toto");
		handler = new Handler();

	}

	@Override
	protected void onHandleIntent(Intent intent) {
		Log.d("tag", "Service Appelé");

		String url = "https://ecoles.excilys.com/lms/secure/downloadAvatar.htm?username=jbriche";
		HttpUriRequest request = new HttpGet(url);
		HttpClient client = new DefaultHttpClient();
		HttpResponse response = null;
		try {
			response = client.execute(request);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			InputStream inputStream = response.getEntity().getContent();
			final Context context = getApplicationContext();
			final ImageView imageView = new ImageView(context);
			Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
			imageView.setImageBitmap(bitmap);
			

			handler.post(new Runnable() {
				@Override
				public void run() {
					final Toast toast = new Toast(context);
					toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
					toast.setDuration(Toast.LENGTH_LONG);
					toast.setView(imageView);
					toast.show();
				}
			});



		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}
}
