package com.android.web;

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
import android.os.StrictMode;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class WebActivity extends Activity implements Runnable {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
				.detectNetwork().build());

		setContentView(R.layout.main);
		Button button1 = (Button) findViewById(R.id.button1);
		
		
		button1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {

				Thread t = new Thread(WebActivity.this);
				t.start();
			
			}

		});
		
		Button button2 = (Button) findViewById(R.id.button2);
		button2.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {

				Intent intent = new Intent(WebActivity.this, WebService.class);
				startService(intent);

			
			}

		});
	}

	private void downloadImage() throws IOException, ClientProtocolException {
		String url = "https://ecoles.excilys.com/lms/secure/downloadAvatar.htm?username=jbriche";
		HttpUriRequest request = new HttpGet(url);
		HttpClient client = new DefaultHttpClient();
		HttpResponse response;
		response = client.execute(request);
		InputStream inputStream = response.getEntity().getContent();
		final Context context = getApplicationContext();
		final ImageView imageView = new ImageView(context);
		Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
		imageView.setImageBitmap(bitmap);

		this.runOnUiThread(new Runnable() {

			public void run() {
				Toast toast = new Toast(context);
				toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
				toast.setDuration(Toast.LENGTH_LONG);
				toast.setView(imageView);
				toast.show();

			}
		});

	}

	public void run() {
		try {
			downloadImage();
		} catch (ClientProtocolException e) {
			Log.e("Log error web", "dl failed");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}