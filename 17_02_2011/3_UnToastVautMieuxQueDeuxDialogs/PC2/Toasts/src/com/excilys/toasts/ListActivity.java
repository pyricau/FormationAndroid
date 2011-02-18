package com.excilys.toasts;

import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_layout);

		ListView listView = (ListView) findViewById(R.id.listView);

		List<String> values = Arrays.asList("Who", "Will Move",
				"The Fruit Juice");
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, values);
		listView.setAdapter(adapter);

		listView.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Toast.makeText(getApplicationContext(),
						parent.getItemAtPosition(position).toString(),
						Toast.LENGTH_SHORT).show();
			}
		});
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		if (id == 42) {
			return new AlertDialog.Builder(this) //
					.setTitle("sqfd") //
					.setMessage("qsdf") //
					.create();
					
		}

		return super.onCreateDialog(id);
	}
	
	@Override
	protected void onPrepareDialog(int id, Dialog dialog, Bundle args) {
		// TODO Auto-generated method stub
		super.onPrepareDialog(id, dialog, args);
	}

	
}
