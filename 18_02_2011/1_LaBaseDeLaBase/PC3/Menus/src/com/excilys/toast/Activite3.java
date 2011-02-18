package com.excilys.toast;

import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Activite3 extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		LayoutParams linearLayoutParams = new LayoutParams(
				LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
		LayoutParams textViewParams = new LayoutParams(
				LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);

		LinearLayout layout = new LinearLayout(this);
		layout.setLayoutParams(linearLayoutParams);
		layout.setOrientation(LinearLayout.VERTICAL);
		
		ListView listView = new ListView(this);
		List<String> values = Arrays.asList("Who", "Will Move",
				"The Fruit Juice");
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, values);
		listView.setAdapter(adapter);

		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				String item = (String) parent.getItemAtPosition(position);
				Bundle bundle = new Bundle();
				bundle.putString("item", item);
				showDialog(10, bundle);
			}
		});
		layout.addView(listView);
		setContentView(layout);

	}

	@Override
	protected Dialog onCreateDialog(int id, Bundle args) {
		switch (id) {
		case 10:
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("Dialogue");
			final TextView textView = new TextView(this);
			textView.setText(args.getString("item"));
			builder.setView(textView);
			builder.setCancelable(true);
			builder.setNegativeButton("Cancel", null);
			builder.setPositiveButton("OK",
					new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							Context context = Activite3.this;

							Toast toast = Toast.makeText(context,"un vieux string",
									Toast.LENGTH_LONG);
							toast.show();
						}
					});
			return builder.create();
		default:
			return null;
		}

	}

}
