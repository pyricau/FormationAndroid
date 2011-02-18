package com.excilys.toast;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main);

		Button button = (Button) findViewById(R.id.buttonA1);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Context context = Main.this;

				Toast toast = Toast.makeText(context,
						((EditText) findViewById(R.id.editText)).getText()
								.toString(), Toast.LENGTH_LONG);
				toast.show();

			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		MenuItem add = menu.add("Item 1");
		add.setOnMenuItemClickListener(new OnMenuItemClickListener() {
			
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				Context context = Main.this;

				Toast toast = Toast.makeText(context,
						((EditText) findViewById(R.id.editText)).getText()
								.toString(), Toast.LENGTH_LONG);
				toast.show();
				return true;
			}
		});
		return true;
	}

}
