package com.ebi;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class ToastActivity extends Activity {
	Toast toast;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		showDialog(42);
		// setContentView(R.layout.newlayout);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.newmenu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.yeah:
			Toast.makeText(ToastActivity.this, "Yeah!", Toast.LENGTH_SHORT)
					.show();
			return true;
		case R.id.yo:
			Toast.makeText(ToastActivity.this, "Yo!", Toast.LENGTH_SHORT)
					.show();
			return true;
		case R.id.ya:
			Toast.makeText(ToastActivity.this, "Ya!", Toast.LENGTH_SHORT)
					.show();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	@Override
	public boolean onSearchRequested() {
		Toast.makeText(ToastActivity.this, "Recherche!", Toast.LENGTH_SHORT)
				.show();
		return super.onSearchRequested();
	}

	@Override
	protected Dialog onCreateDialog(int id, Bundle args) {

		switch (id) {
		case 42:
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("Boite de dialogue");
			builder.setPositiveButton("OK", new OnClickListener() {

				public void onClick(DialogInterface dialog, int which) {
					Toast.makeText(ToastActivity.this, "Ya!",
							Toast.LENGTH_SHORT).show();

				}
			});

			builder.setNegativeButton("ANNULER", new OnClickListener() {

				public void onClick(DialogInterface dialog, int which) {
					Toast.makeText(ToastActivity.this, "Ya!",
							Toast.LENGTH_SHORT).show();

				}
			});

			// builder.setPositiveButton("Ok", new OnClickListener() {
			// public void onClick(View v) {
			// Toast.makeText(ToastActivity.this, "OK!",
			// Toast.LENGTH_SHORT).show();
			// }
			// });

			// builder.setPositiveButton("", arg1)
			//
			// LayoutInflater layoutInflater = getLayoutInflater();
			//
			// View layout = layoutInflater.inflate(R.layout.dialog, null);
			//
			// Button ok = (Button) layout.findViewById(R.id.ok);
			// Button annuler = (Button) layout.findViewById(R.id.annuler);
			//
			// ok.setOnClickListener(new OnClickListener() {
			// public void onClick(View v) {
			// Toast.makeText(ToastActivity.this, "OK!",
			// Toast.LENGTH_SHORT).show();
			// }
			// });
			//
			// annuler.setOnClickListener(new OnClickListener() {
			// public void onClick(View v) {
			// Toast.makeText(ToastActivity.this, "ANNULER!",
			// Toast.LENGTH_SHORT).show();
			// }
			// });

			// builder.setView(layout);
			return builder.create();
		default:
			return null;
		}
	}

}