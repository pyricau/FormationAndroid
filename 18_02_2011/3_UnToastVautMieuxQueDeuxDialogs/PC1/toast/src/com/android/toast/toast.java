package com.android.toast;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class toast extends Activity {
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// MenuItem menuYeah = menu.add("Yeah");
		// menuYeah.setOnMenuItemClickListener(new OnMenuItemClickListener() {
		// public boolean onMenuItemClick(MenuItem item) {
		// Context context = getApplicationContext();
		// Toast toast = Toast.makeText(context, "Toast Menu",
		// Toast.LENGTH_SHORT);
		// toast.show();
		// return true;
		// }
		// });
		//
		// return true;

		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return true;

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Context context = getApplicationContext();
		Toast toast = Toast.makeText(context, "",	Toast.LENGTH_SHORT);
		switch (item.getItemId()) {
		case R.id.yeah:
			toast.setText("yeah");
			toast.show();
			return true;
			
		case R.id.yeah2:
			toast.setText("yeah2");
			toast.show();
			return true;
			
		case R.id.yeah3:
			toast.setText("yeah3");
			toast.show();
			return true;
			
		default:
			return super.onOptionsItemSelected(item);
		}

	}

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Button buttonToast = (Button) findViewById(R.id.buttonToast);

		buttonToast.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				Context context = v.getContext();
				TextView textViewToast = (TextView) findViewById(R.id.textViewToast);
				Toast toast = Toast.makeText(context, textViewToast.getText(),
						Toast.LENGTH_SHORT);
				toast.show();

			}

		});

	}

	@Override
	public boolean onSearchRequested() {
				
		/*Context context = getApplicationContext();
		Toast toast = Toast.makeText(context, "search",
				Toast.LENGTH_SHORT);
		toast.show();*/
		
		showDialog(12);
		return super.onSearchRequested();
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		if(id==12)
		{
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("dialogue");
			
			LayoutInflater layoutInflater = getLayoutInflater();
			
			View inflate = layoutInflater.inflate(R.layout.main, null);
		
			final EditText edit=(EditText) inflate.findViewById(R.id.editView);
			
			builder.setView(inflate);
			builder.setPositiveButton("OK",new Dialog.OnClickListener() {
				
				public void onClick(DialogInterface dialog, int which) {
					Context context = getApplicationContext();
					Toast toast = Toast.makeText(context, edit.getText().toString(),
							Toast.LENGTH_SHORT);
					toast.show();					
				}
			}			
			);
			builder.setNegativeButton("Annuler", new Dialog.OnClickListener() {
				
				public void onClick(DialogInterface dialog, int which) {
					
					
				}
			});
			return builder.create();			
		}
		return super.onCreateDialog(id);
		
	}
	
	

}