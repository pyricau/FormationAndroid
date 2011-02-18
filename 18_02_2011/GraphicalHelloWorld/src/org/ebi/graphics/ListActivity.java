package org.ebi.graphics;

import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.list);
		ListView listView = (ListView)findViewById(R.id.list);
		List<String> values = Arrays.asList("Who", "Will Move", "The Fruit Juice");
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values);
		listView.setAdapter(adapter);
		
		listView.setOnItemClickListener(new OnItemClickListener() {
			
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				String item = (String) parent.getItemAtPosition(position);
				Bundle bundle = new Bundle();
				bundle.putCharSequence("item", item);
				showDialog(43, bundle);
			}
		});
	
	}
	@Override
	protected Dialog onCreateDialog(int id, Bundle args) {
		switch (id) {
		case 43:
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("test");
			builder.setMessage(args.getCharSequence("item"));
			
			
			builder.setNegativeButton("Cancel", null);
			return builder.create();

		default:
			return null;
		}
	}
	
	@Override
	protected void onPrepareDialog(int id, Dialog dialog, Bundle args) {
		switch (id) {
		case 43:
			AlertDialog builder =(AlertDialog) dialog;
			builder.setMessage(args.getCharSequence("item"));
			break;
		default:
		}
	}
	
	
}
