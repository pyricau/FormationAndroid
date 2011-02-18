package com.excilys;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class OuebActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.main);
        
        
        Button button2= (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	Intent intent = new Intent(OuebActivity.this, MonService.class);
            	
				startService(intent);
            };
        });
        
        
        Button button= (Button) findViewById(R.id.button1);
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
				Thread thread = new Thread() {

					@Override
					public void run() {
						try {
							String url = "https://ecoles.excilys.com/lms/secure/downloadAvatar.htm?username=fpchalopin";
			            	HttpUriRequest request = new HttpGet(url);
			            	HttpClient client = new DefaultHttpClient();
							
							HttpResponse response = client.execute(request);
							InputStream inputStream = response.getEntity().getContent();


							Context context = getApplicationContext();
							final ImageView imageView = new ImageView(context);
							Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
							imageView.setImageBitmap(bitmap);

							runOnUiThread(new Runnable() {
								public void run() {
									Toast toast = new Toast(getApplicationContext());
									toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
									toast.setDuration(Toast.LENGTH_LONG);
									toast.setView(imageView);
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
				
				thread.start();
            }
    });

    }
}