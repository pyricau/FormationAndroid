package com.android.toast;

import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;

public class ActivityAdapter extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		List<String> values = Arrays.asList("Who", "Will Move",
				"The Fruit Juice");
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, values);
		ListView listView = (ListView) findViewById(R.id.ListView);
		listView.setAdapter(adapter);

		listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				String item = (String) parent.getItemAtPosition(position);
				Bundle bundle = new Bundle();
				bundle.putString("id", item);
				showDialog(42, bundle);
			}
		});

	}

	@Override
	protected Dialog onCreateDialog(int id, Bundle args) {
		// TODO Auto-generated method stub

		if (id == 42) {
			TextView text = new TextView(getApplicationContext());
			text.setText((String) args.get("id"));
			LayoutParams params = new LayoutParams(LayoutParams.FILL_PARENT,
					LayoutParams.FILL_PARENT);
			text.setLayoutParams(params);
			return new AlertDialog.Builder(this) //
					.setTitle("dialogue")//
					.setView(text)//
					.create();
		}

		return super.onCreateDialog(id, args);
	}

}
