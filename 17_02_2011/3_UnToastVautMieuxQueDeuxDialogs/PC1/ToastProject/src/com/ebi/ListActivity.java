package com.ebi;

import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		 setContentView(R.layout.list);
		 ListView listview = (ListView)findViewById(R.id.list);
		 
		 List<String> values = Arrays.asList("Who", "Will Move", "The Fruit Juice");
		 ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values);
		 listview.setAdapter(adapter);
		 
		 listview.setOnItemClickListener(new OnItemClickListener() {
		        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		                String item = (String) parent.getItemAtPosition(position);
		        }
		});

	}
}
