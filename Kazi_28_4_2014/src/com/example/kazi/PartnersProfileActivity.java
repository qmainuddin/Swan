package com.example.kazi;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class PartnersProfileActivity extends Activity {
	
	TextView textTV,addressTV,text1TV;
	EditText heightET,weightET,charecterET;
	Spinner sexSP,religionSP,qualificationSP,placeSP,zillaSP;
	Button backButton,submitButton;
	Intent startUpIntent;
	DataHandler handler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_partners_profile);
		
		startUpIntent = new Intent("com.example.kazi.MainActivity");
		
		textTV = (TextView) findViewById(R.id.textTextView);
        heightET = (EditText) findViewById(R.id.heightEditText);
        
        weightET = (EditText) findViewById(R.id.weightEditText);
        addressTV = (TextView) findViewById(R.id.addressTextView);
        text1TV = (TextView) findViewById(R.id.text1TextView);
        charecterET = (EditText) findViewById(R.id.charecterEditText);
        
        sexSP=(Spinner) findViewById(R.id.sexSpinner);
        ArrayAdapter<CharSequence> sexadapter = ArrayAdapter.createFromResource(this, R.array.sex_array, android.R.layout.simple_spinner_item);
        sexadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sexSP.setAdapter(sexadapter);
        
        religionSP=(Spinner) findViewById(R.id.religionSpinner);
        ArrayAdapter<CharSequence> religionadapter = ArrayAdapter.createFromResource(this, R.array.religion_array, android.R.layout.simple_spinner_item);
        religionadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        religionSP.setAdapter(religionadapter);
        
        qualificationSP=(Spinner) findViewById(R.id.qualificationSpinner);
        ArrayAdapter<CharSequence> educationaladapter = ArrayAdapter.createFromResource(this, R.array.educational_array, android.R.layout.simple_spinner_item);
        educationaladapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        qualificationSP.setAdapter(educationaladapter);
        
        placeSP=(Spinner) findViewById(R.id.placeSpinner);
        placeSP=(Spinner) findViewById(R.id.placeSpinner);
        ArrayAdapter<CharSequence> placeadapter = ArrayAdapter.createFromResource(this, R.array.place_array, android.R.layout.simple_spinner_item);
        placeadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        placeSP.setAdapter(placeadapter);        
        
        zillaSP=(Spinner) findViewById(R.id.zillaSpinner);
        ArrayAdapter<CharSequence> zillaadapter = ArrayAdapter.createFromResource(this, R.array.zilla_array, android.R.layout.simple_spinner_item);
        zillaadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        zillaSP.setAdapter(zillaadapter);
        
        backButton=(Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(startUpIntent);
			}
		});
        
        submitButton=(Button) findViewById(R.id.submitButton);        
        submitButton.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				String sex=sexSP.getSelectedItem().toString();
				String religion=religionSP.getSelectedItem().toString();
				String education=qualificationSP.getSelectedItem().toString();
				String height=heightET.getText().toString();
				String weight=weightET.getText().toString();
				String place=placeSP.getSelectedItem().toString();
				String zilla=zillaSP.getSelectedItem().toString();
				String charecter=charecterET.getText().toString();
				
				handler= new DataHandler(getBaseContext());
				handler.open();
				long id= handler.insertPartnerData(sex, religion, education, height, weight, place, zilla, charecter);
				Toast.makeText(getBaseContext(), "Data inserted :"+sex, Toast.LENGTH_LONG).show();				
				handler.close();
				startActivity(startUpIntent);
			}
		});
		
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.activity_partners_profile, menu);
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

					startActivity(startUpIntent);
					return true;
				}
			});
			return true;
		
		}
		
		return super.onOptionsItemSelected(item);
	}

}
