package com.excilys.android.training;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MyToastActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Button button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(new android.view.View.OnClickListener() {

			public void onClick(View v) {
				Toast toast = Toast.makeText(MyToastActivity.this,
						R.string.l_toast1, Toast.LENGTH_SHORT);
				toast.show();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuItem mi = menu.add("test");
		mi.setOnMenuItemClickListener(new OnMenuItemClickListener() {

			public boolean onMenuItemClick(MenuItem item) {
				Toast.makeText(MyToastActivity.this, "pouet",
						Toast.LENGTH_SHORT).show();
				return true;
			}
		});
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.id1: 
			
			Toast.makeText(MyToastActivity.this, "id1", Toast.LENGTH_SHORT)
					.show();
			break;
		case R.id.id2:
			Toast.makeText(MyToastActivity.this, "id2", Toast.LENGTH_SHORT)
					.show();
			break;
		case R.id.id3:
			Toast.makeText(MyToastActivity.this, "id3", Toast.LENGTH_SHORT)
					.show();
			break;
		case R.id.id4:
			Toast.makeText(MyToastActivity.this, "id4", Toast.LENGTH_SHORT)
					.show();
			break;
		default:
			return super.onOptionsItemSelected(item);
		}
		return true;

	}
	
	@Override
	public boolean onSearchRequested() {
		/*
		Toast toast = Toast.makeText(MyToastActivity.this,
						R.string.l_toast2, Toast.LENGTH_SHORT);
	    toast.show();
	    */
	    showDialog(0);
		return super.onSearchRequested();
		
	}
	
	@Override
	protected Dialog onCreateDialog(int id, Bundle args) {
		switch(id){
		case 0 : AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("test");
			builder.setPositiveButton("OK", new OnClickListener() {
				
				public void onClick(DialogInterface dialog, int which) {
					Toast.makeText(MyToastActivity.this,
							R.string.l_toast2, Toast.LENGTH_SHORT).show();
				}
			});
			builder.setNegativeButton("ou pas...", null);
			return builder.create();
		default:
			return null;
	    }
	}

}