package com.example.kazi;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class SearchActivity extends Activity {
	
	Spinner iAmASP,seekingSP,whoIsFromSP,toSP,educationalSP,religionSP,maritalStatusSP,childrenSP,countrySP,districtSP;
	TextView iAmATV,seekingTV,whoIsFromTV,toTV,educationalTV,religionTV,maritalStatusTV,childrenTV,countryTV,districtTV,placeET,nameET,placeTV,nameTV,smokeTV,drinkTV;
	Button searchButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		
		iAmASP = (Spinner)findViewById(R.id.iAmASpinner);
		ArrayAdapter<CharSequence> isexadapter = ArrayAdapter.createFromResource(this, R.array.sex_array, android.R.layout.simple_spinner_item);
        isexadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        iAmASP.setAdapter(isexadapter);
        
		seekingSP = (Spinner)findViewById(R.id.seekingSpinner);
		ArrayAdapter<CharSequence> seeksexadapter = ArrayAdapter.createFromResource(this, R.array.sex_array, android.R.layout.simple_spinner_item);
		seeksexadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        seekingSP.setAdapter(seeksexadapter);
		
		whoIsFromSP = (Spinner)findViewById(R.id.whoIsFromSpinner);
		ArrayAdapter<CharSequence> fromadapter = ArrayAdapter.createFromResource(this, R.array.from_array, android.R.layout.simple_spinner_item);
		fromadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        whoIsFromSP.setAdapter(fromadapter);
		
		toSP = (Spinner)findViewById(R.id.toSpinner);
		ArrayAdapter<CharSequence> toadapter = ArrayAdapter.createFromResource(this, R.array.to_array, android.R.layout.simple_spinner_item);
		toadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        toSP.setAdapter(toadapter);        
		
		educationalSP = (Spinner)findViewById(R.id.educationalStatusSpinner);
		ArrayAdapter<CharSequence> educationaladapter = ArrayAdapter.createFromResource(this, R.array.educational_array, android.R.layout.simple_spinner_item);
        educationaladapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        educationalSP.setAdapter(educationaladapter);
        
		
		religionSP = (Spinner)findViewById(R.id.religionSpinner);
		ArrayAdapter<CharSequence> religionadapter = ArrayAdapter.createFromResource(this, R.array.religion_array, android.R.layout.simple_spinner_item);
        religionadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        religionSP.setAdapter(religionadapter);
		
		maritalStatusSP = (Spinner)findViewById(R.id.maritalStatusSpinner);
		ArrayAdapter<CharSequence> maritaladapter = ArrayAdapter.createFromResource(this, R.array.marital_array, android.R.layout.simple_spinner_item);
		maritaladapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        maritalStatusSP.setAdapter(maritaladapter);
		
		childrenSP = (Spinner)findViewById(R.id.childrenSpinner);
		ArrayAdapter<CharSequence> childrenadapter = ArrayAdapter.createFromResource(this, R.array.children_array, android.R.layout.simple_spinner_item);
		childrenadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        childrenSP.setAdapter(childrenadapter);
		
		countrySP = (Spinner)findViewById(R.id.countrySpinner);
		ArrayAdapter<CharSequence> countryadapter = ArrayAdapter.createFromResource(this, R.array.country_array, android.R.layout.simple_spinner_item);
        countryadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countrySP.setAdapter(countryadapter);
		
		districtSP = (Spinner)findViewById(R.id.districtSpinner);
		ArrayAdapter<CharSequence> zillaadapter = ArrayAdapter.createFromResource(this, R.array.zilla_array, android.R.layout.simple_spinner_item);
        zillaadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        districtSP.setAdapter(zillaadapter);
		
		iAmATV = (TextView) findViewById(R.id.iAmATextView);
		seekingTV = (TextView) findViewById(R.id.seekinfTextVeiw);
		whoIsFromTV = (TextView) findViewById(R.id.whoIsFromTextVeiw);
		toTV = (TextView) findViewById(R.id.toTextVeiw);
		educationalTV = (TextView) findViewById(R.id.educationalStatusTextVeiw);
		religionTV = (TextView) findViewById(R.id.religionTextVeiw);
		maritalStatusTV = (TextView) findViewById(R.id.maritalStatusTextVeiw);
		childrenTV = (TextView) findViewById(R.id.childrenTextVeiw);
		countryTV = (TextView) findViewById(R.id.countryTextVeiw);
		districtTV = (TextView) findViewById(R.id.districtTextVeiw);
		placeET = (TextView) findViewById(R.id.placeEditText);
		nameET = (TextView) findViewById(R.id.nameEditText);
		placeTV = (TextView) findViewById(R.id.placeTextVeiw);
		nameTV = (TextView) findViewById(R.id.nameTextVeiw);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.activity_search, menu);
		//return true;
		MenuInflater mif= getMenuInflater();
		mif.inflate(R.menu.main_activity_action, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {

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
