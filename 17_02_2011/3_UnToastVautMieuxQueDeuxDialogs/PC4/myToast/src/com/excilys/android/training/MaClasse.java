package com.excilys.android.training;

import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MaClasse extends Activity {
	
	private String item;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.main2);
		List<String> values = Arrays.asList("Who", "Will Move", "The Fruit Juice");
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values);
		ListView lv = (ListView) findViewById(R.id.ListView1);
		lv.setAdapter(adapter);
		lv.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				item = (String) parent.getItemAtPosition(position);
				Bundle bndl = new Bundle();
				bndl.putString("myItem", item);
				showDialog(1, bndl);

			}
		});
		super.onCreate(savedInstanceState);
	}

	@Override
	protected Dialog onCreateDialog(int id, final Bundle args) {
		switch (id) {
		case 1:
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("test");
			builder.setPositiveButton("OK", new OnClickListener() {

				public void onClick(DialogInterface dialog, int which) {
					Toast.makeText(MaClasse.this, item, Toast.LENGTH_SHORT).show();
				}
			});
			builder.setNegativeButton("ou pas...", null);
			return builder.create();
		default:
			return null;
		}
	}

	@Override
	protected void onPrepareDialog(int id, Dialog dialog, final Bundle args) {

		if (id == 1) {
			AlertDialog alert = (AlertDialog) dialog;
			
			alert.setButton(DialogInterface.BUTTON_POSITIVE, "OK", new OnClickListener() {

				public void onClick(DialogInterface dialog, int which) {
					Toast.makeText(MaClasse.this, args.getString("myItem"), Toast.LENGTH_SHORT).show();
				}
			});
		}

		// TODO Auto-generated method stub
		super.onPrepareDialog(id, dialog, args);
	}

}
