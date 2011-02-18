package com.excilys.toast;

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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainXML extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main);

		Button button = (Button) findViewById(R.id.buttonA1);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Context context = MainXML.this;

				Toast toast = Toast.makeText(context,
						((EditText) findViewById(R.id.editText)).getText()
								.toString(), Toast.LENGTH_LONG);
				toast.show();

			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Context context = MainXML.this;

		switch (item.getItemId()) {
		case R.id.yeah1:
			Toast toast = Toast.makeText(context, "Yeah1", Toast.LENGTH_LONG);
			toast.show();
			return true;
		case R.id.yeah2:
			Toast toast2 = Toast.makeText(context, "Yeah2", Toast.LENGTH_LONG);
			toast2.show();
			return true;
		case R.id.yeah3:
			Toast toast3 = Toast.makeText(context, "Yeah3", Toast.LENGTH_LONG);
			toast3.show();
			return true;
		case R.id.yeah4:
			Toast toast4 = Toast.makeText(context, "Yeah4", Toast.LENGTH_LONG);
			toast4.show();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	@Override
	protected Dialog onCreateDialog(int id, Bundle args) {
		switch (id) {
		case 10:
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("Dialogue");
			final TextView textView = new TextView(this);
			textView.setText("PY est saoul");
			builder.setView(textView);
			builder.setCancelable(true);
			builder.setNegativeButton("Cancel", null);
			builder.setPositiveButton("OK",
					new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							Context context = MainXML.this;

							Toast toast = Toast.makeText(context,
									((EditText) findViewById(R.id.editText))
											.getText().toString(),
									Toast.LENGTH_LONG);
							toast.show();
						}
					});
			return builder.create();
		default:
			return null;
		}

	}

	@Override
	public boolean onSearchRequested() {
		showDialog(10);
		return super.onSearchRequested();
	}

}
