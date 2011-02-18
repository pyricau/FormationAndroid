package com.excilys.formation.android;

import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ClasseToast extends Activity {

	private Context context;
	private TextView txtView;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		context = getApplicationContext();
		txtView = (TextView) findViewById(R.id.txt);
		Button btnAfficher = (Button) findViewById(R.id.mybutton);
		btnAfficher.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				Toast.makeText(context, txtView.getText(), Toast.LENGTH_LONG).show();
			}
		});
		ListView listView = (ListView) findViewById(R.id.list);
		List<String> values = Arrays.asList("A", "B", "C");
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				String item = (String) parent.getItemAtPosition(position);
				Bundle bundle = new Bundle();
				bundle.putString("myKey", item);
				showDialog(42, bundle);
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		/*
		 * MenuItem monMenu = menu.add("Pouet");
		 * monMenu.setOnMenuItemClickListener(new OnMenuItemClickListener() {
		 * 
		 * public boolean onMenuItemClick(MenuItem item) {
		 * Toast.makeText(context, item.getTitle(), Toast.LENGTH_LONG).show();
		 * return true; } });
		 * 
		 * MenuItem mPata = menu.add("M. Patate");
		 * mPata.setOnMenuItemClickListener(new OnMenuItemClickListener() {
		 * 
		 * public boolean onMenuItemClick(MenuItem item) {
		 * Toast.makeText(context, item.getTitle(),Toast.LENGTH_LONG).show();
		 * return true; } });
		 */

		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.item:
			Toast.makeText(context, item.getTitle(), Toast.LENGTH_LONG).show();
			return true;
		case R.id.item2:
			Toast.makeText(context, item.getTitle(), Toast.LENGTH_LONG).show();
			return true;
		case R.id.item3:
			Toast.makeText(context, item.getTitle(), Toast.LENGTH_LONG).show();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	@Override
	public boolean onSearchRequested() {
		showDialog(42);
		return super.onSearchRequested();
	}

	@Override
	protected Dialog onCreateDialog(int id, Bundle args) {
		switch (id) {
		case 42:
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("Alerte 42");
			builder.setMessage("Loupé");
			builder.setPositiveButton("Ok, je me rend", new OnClickListener() {

				public void onClick(DialogInterface dialog, int which) {
					Toast.makeText(context, "Tu as compris qui était ton maitre!", Toast.LENGTH_LONG).show();
				}

			});

			builder.setNegativeButton("Non, je continue !!!!!", new OnClickListener() {

				public void onClick(DialogInterface dialog, int which) {

				}

			});
			return builder.create();

		default:
			return null;
		}
	}

}