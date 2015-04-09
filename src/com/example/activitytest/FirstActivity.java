package com.example.activitytest;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import android.view.Window;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.util.Log;

public class FirstActivity extends BaseActivity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.e("FirstActivity","Task id is " + getTaskId());
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.first_layout);
		Button button1 = (Button)findViewById(R.id.button_1);
		button1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(FirstActivity.this, "You clicked Button 1", 
						Toast.LENGTH_SHORT).show();
				//Intent intent = new Intent("com.example.activitytest.ACTION_START");
				//intent.addCategory("com.example.activitytest.MY_CATEGORY");
				//Intent intent = new Intent(Intent.ACTION_VIEW);
				//intent.setData(Uri.parse("http://www.baidu.com"));
				//Intent intent = new Intent(Intent.ACTION_DIAL);
				//intent.setData(Uri.parse("tel:10086"));
				String data = "Hello SecondActivity";
				//Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
				//intent.putExtra("extra_data", data);
				//Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
				//startActivityForResult(intent, 1);
				//startActivity(intent);
				SecondActivity.actionStart(FirstActivity.this, "data1", "data2");
			}
		});
	}
	
	@Override
	protected void onRestart() {
		super.onRestart();
		Log.e("FirstActivity", "onRestart");
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);;
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.add_item:
			Toast.makeText(this, "You clicked Add", Toast.LENGTH_SHORT).show();
			break;
		case R.id.remove_item:
			Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT).show();
			break;
		default:
		}
		return true;
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (requestCode) {
		case 1:
			if (resultCode == RESULT_OK) {
				//String returnData = data.getStringExtra("data_return");
				//Log.e("FirstActivity", returnData);
			}
			break;
		default:
		}
	}
}
