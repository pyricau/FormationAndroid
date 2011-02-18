package com.excilys;

import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class ToastActivity extends Activity {
	
	EditText edit;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    

		Button bouton = (Button) findViewById(R.id.button1);
		bouton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				EditText edit = (EditText) findViewById(R.id.textToast);
				Toast.makeText(getApplicationContext(),
						edit.getText().toString(), Toast.LENGTH_LONG).show();
			}
		});

		
		Button bouton2 = (Button) findViewById(R.id.button2);
		bouton2.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
				int icon = R.drawable.icon;
				String statusText = "Hello"; 
				long when = System.currentTimeMillis(); 
				Notification notification = new Notification(icon, statusText, when);
				
				Context context = getApplicationContext(); 
				String contentTitle = "My notification"; 
				String contentText = "En cours";
				Intent notificationIntent = new Intent(ToastActivity.this, Activity2.class); 
				PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notificationIntent, 0); 
				notification.setLatestEventInfo(context, contentTitle, contentText, contentIntent);
				notification.flags ^= Notification.FLAG_AUTO_CANCEL;
				notificationManager.notify(42, notification);
			}
		});

	
		
		ListView listView = (ListView) findViewById(R.id.listView1);
		
		List<String> values = Arrays.asList("Who", "Will Move", "The Fruit Juice");
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				String item = (String) parent.getItemAtPosition(position);
				
				Bundle bundle = new Bundle();
				bundle.putString("key", item);
				
				showDialog(44, bundle);
			}
		});

		edit = new EditText(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.monmenu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Toast.makeText(getApplicationContext(), "coucou", Toast.LENGTH_SHORT).show();
		return true;
	}
    
	@Override
	public boolean onSearchRequested() {
		showDialog(42);
		return true;
	}
	
	
	@Override
	protected Dialog onCreateDialog(int id, Bundle args) {
		AlertDialog.Builder builder= new AlertDialog.Builder(this);
		builder.setTitle("test");
		builder.setView(edit);
		builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface di, int which) {
				Toast.makeText(getApplicationContext(),
						edit.getText().toString(), Toast.LENGTH_LONG).show();
			}
		});
		
		builder.setNegativeButton("Annuler", null);
		return builder.create();
	}
	
	@Override
	protected void onPrepareDialog(int id, Dialog dialog, Bundle args) {
		edit.setText(args.getString("key"));
	}
}