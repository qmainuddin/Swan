package com.example.kazi;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebIconDatabase.IconListener;
import android.widget.ImageButton;
import android.widget.TextView;
import android.app.ActionBar;

public class MainActivity extends Activity {

	ImageButton myMatchesIB, myProfileIB, partnerProfileIB, searchIB, termsIB,
			aboutUsIB;
	TextView myMatchesTV, myProfileTV, partnerProfileTV, searchTV, termsTV,
			aboutUsTV;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		myMatchesIB = (ImageButton) findViewById(R.id.myMatchesImageButton);
		myProfileIB = (ImageButton) findViewById(R.id.myProfileImageButton);
		partnerProfileIB = (ImageButton) findViewById(R.id.partnerProfileImageButton);
		searchIB = (ImageButton) findViewById(R.id.searchImageButton);
		termsIB = (ImageButton) findViewById(R.id.termsImageButton);
		aboutUsIB = (ImageButton) findViewById(R.id.aboutUsImageButton);

		myMatchesTV = (TextView) findViewById(R.id.myMatchesTextView);
		myProfileTV = (TextView) findViewById(R.id.myProfileTextView);
		partnerProfileTV = (TextView) findViewById(R.id.partnerProfileTextView);
		searchTV = (TextView) findViewById(R.id.SearchTextView);
		termsTV = (TextView) findViewById(R.id.termsTextView);
		aboutUsTV = (TextView) findViewById(R.id.aboutUsTextView);

		

		myMatchesIB.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent myMatchesIBIntent = new Intent("com.example.kazi.MyMatchesActivity");
				startActivity(myMatchesIBIntent);

			}
		});
		myProfileIB.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Intent myProfileIBIntent = new Intent("com.example.kazi.MyProfileActivity");
				startActivity(myProfileIBIntent);

			}
		});
		partnerProfileIB.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Intent partnerProfileIBIntent = new Intent("com.example.kazi.PartnersProfileActivity");
				startActivity(partnerProfileIBIntent);

			}
		});
		searchIB.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				
				Intent searchIntent = new Intent("com.example.kazi.SearchActivity");
				startActivity(searchIntent);

			}
		});
		termsIB.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				
				Intent termsIBIntent = new Intent("com.example.kazi.TermsConditionActivity");
				startActivity(termsIBIntent);

			}
		});
		aboutUsIB.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent aboutUsIntent = new Intent("com.example.kazi.AboutUsActivity");
				startActivity(aboutUsIntent);
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.activity_main, menu);
		//return true;
		MenuInflater mif= getMenuInflater();
		mif.inflate(R.menu.main_activity_action, menu);
		return super.onCreateOptionsMenu(menu);
	}
	@Override
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
					Intent startUpIntent = new Intent("com.example.kazi.StartUpActivity");
					startActivity(startUpIntent);
					return true;
				}
			});
			return true;
		
		}
		
		return super.onOptionsItemSelected(item);
	}

}
