package com.excilys.toasts;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button mainButton = (Button) findViewById(R.id.mainButton);
        
        mainButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				EditText editText = (EditText) findViewById(R.id.mainTextView);
				Toast toast = Toast.makeText(getApplicationContext(), editText.getText().toString(), Toast.LENGTH_LONG);
				toast.show();
			}
		});
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater menuInflater = getMenuInflater();
		menuInflater.inflate(R.menu.menu, menu);
		
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.yeah:
			Toast toast = Toast.makeText(getApplicationContext(), "yeah", Toast.LENGTH_SHORT);
			toast.show();
			return true;

		default:
			return super.onOptionsItemSelected(item);
		}
	}

	@Override
	public boolean onSearchRequested() {
		
		showDialog(42);
		
		
		return true;
	}
	
	@Override
	protected Dialog onCreateDialog(int id) {
		if (id == 42) {
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("mon titre");
			builder.setMessage("mon message");
			final EditText editText = new EditText(this);
			builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
				
				public void onClick(DialogInterface dialog, int which) {
					Toast.makeText(getApplicationContext(), editText.getText().toString(), Toast.LENGTH_SHORT).show();
				}
			});
			builder.setNeutralButton("Annuler",
					new DialogInterface.OnClickListener() {

						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub

						}
					});
			
			builder.setView(editText);
			
			return builder.create();
		}
		
		
		return null;
	}
}