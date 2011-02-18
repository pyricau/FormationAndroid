package org.ebi.graphics;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MenuXMLActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.toast);
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	        switch (item.getItemId()) {
	        case R.id.yeah: 
	        	Toast.makeText(MenuXMLActivity.this, "Yeah", Toast.LENGTH_SHORT).show();
	                 return true;
	        default:
	                 return super.onOptionsItemSelected(item);
	        }
	}
	
	@Override
	public boolean onSearchRequested() {
		showDialog(43);
		return super.onSearchRequested();
	}
	
	@Override
	protected Dialog onCreateDialog(int id) {
		final Context context = getApplicationContext();
		switch (id) {
		case 43:
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("test");
			builder.setMessage("Okay?");
			builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					Toast.makeText(context, "Coucou", Toast.LENGTH_SHORT).show();
				}
			});
			
			builder.setNegativeButton("Cancel", null);
			return builder.create();

		default:
			return null;
		}
	}

}
