package com.example.kazi;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class AboutUsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about_us);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.activity_about_us, menu);
		//return true;
		MenuInflater mif= getMenuInflater();
		mif.inflate(R.menu.main_activity_action, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
	//	return super.onOptionsItemSelected(item);
		switch(item.getItemId()){
			
		case R.id.search_icon:
			item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
				
				@Override
				public boolean onMenuItemClick(MenuItem arg0) {
					Intent searchIntent = new Intent("com.example.kazi.SearchActivity");
					startActivity(searchIntent);
					return true;
				}
			});
			return true;
			
		case R.id.back_icon:
			item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
				
				@Override
				public boolean onMenuItemClick(MenuItem arg0) {
					Intent startUpIntent = new Intent("com.example.kazi.MainActivity");
					startActivity(startUpIntent);
					return true;
				}
			});
			return true;
		
		}
		
		return super.onOptionsItemSelected(item);
	}

}
