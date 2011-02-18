package com.excilys.toast;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Activite4 extends Activity {

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

		Button button = new Button(this);
		button.setText("NOTIFIER");

		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
				int icon = R.drawable.icon;
				String statusText = "ALERTE";
				long when = System.currentTimeMillis();
				Notification notification = new Notification(icon, statusText,
						when);
			}
		});

		layout.addView(button);
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
							Context context = Activite4.this;

							Toast toast = Toast.makeText(context,
									"un vieux string", Toast.LENGTH_LONG);
							toast.show();
						}
					});
			return builder.create();
		default:
			return null;
		}

	}

}
