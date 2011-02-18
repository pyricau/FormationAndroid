package org.ebi.graphics;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ToastActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.toast);
		final TextView textView = (TextView)findViewById(R.id.myText);
		Button sexyButton = (Button) findViewById(R.id.sexyButton);
        sexyButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Context context = ToastActivity.this;
				Toast toast = Toast.makeText(context, textView.getText(), Toast.LENGTH_SHORT);
				toast.show();
			}
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuItem menuItem = menu.add("Yeahhh");
		menuItem.setOnMenuItemClickListener(new OnMenuItemClickListener() {
			
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				Toast.makeText(ToastActivity.this, "Youpppi", Toast.LENGTH_SHORT).show();
				return true;
			}
		});
		return true;
	}
}
