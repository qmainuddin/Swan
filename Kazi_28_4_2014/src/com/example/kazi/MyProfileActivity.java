package com.example.kazi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MyProfileActivity extends Activity {
	
	Spinner  sexSP,educationalmySP,placeSP,zillaSP,countrySP,religionSP,smokerSP,drinkSP;
	TextView addressTV,imageTV;
	ImageView  imageView;
	Button birthDateButton,submitButton;
	EditText userNameET,heightET,weightET;
	DataHandler handler;
	Intent startUpIntent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_profile);
		
        heightET = (EditText) findViewById(R.id.heightEditText);
        
        weightET = (EditText) findViewById(R.id.weightEditText);
               
        userNameET = (EditText) findViewById(R.id.userNameEditText);
        
        addressTV = (TextView) findViewById(R.id.addressTextView); 
        startUpIntent = new Intent("com.example.kazi.MainActivity");

        educationalmySP =(Spinner) findViewById(R.id.educationalmySpinner);
        ArrayAdapter<CharSequence> educationaladapter = ArrayAdapter.createFromResource(this, R.array.educational_array, android.R.layout.simple_spinner_item);
        educationaladapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        educationalmySP.setAdapter(educationaladapter);
		
        
        countrySP=(Spinner) findViewById(R.id.countrySpinner);
        ArrayAdapter<CharSequence> countryadapter = ArrayAdapter.createFromResource(this, R.array.country_array, android.R.layout.simple_spinner_item);
        countryadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countrySP.setAdapter(countryadapter);
        
        
        smokerSP=(Spinner) findViewById(R.id.smokerSpinner);
        ArrayAdapter<CharSequence> smokeradapter = ArrayAdapter.createFromResource(this, R.array.smoke_array, android.R.layout.simple_spinner_item);
        smokeradapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        smokerSP.setAdapter(smokeradapter);
        
        
        drinkSP=(Spinner) findViewById(R.id.drinkSpinner);
        ArrayAdapter<CharSequence> drinkadapter = ArrayAdapter.createFromResource(this, R.array.drink_array, android.R.layout.simple_spinner_item);
        drinkadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        drinkSP.setAdapter(drinkadapter);
        
        
        sexSP=(Spinner) findViewById(R.id.sexSpinner);
        ArrayAdapter<CharSequence> sexadapter = ArrayAdapter.createFromResource(this, R.array.sex_array, android.R.layout.simple_spinner_item);
        sexadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sexSP.setAdapter(sexadapter);
        
        
        religionSP=(Spinner) findViewById(R.id.religionSpinner);
        ArrayAdapter<CharSequence> religionadapter = ArrayAdapter.createFromResource(this, R.array.religion_array, android.R.layout.simple_spinner_item);
        religionadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        religionSP.setAdapter(religionadapter);
        
        
        placeSP=(Spinner) findViewById(R.id.placeSpinner);
        ArrayAdapter<CharSequence> placeadapter = ArrayAdapter.createFromResource(this, R.array.place_array, android.R.layout.simple_spinner_item);
        placeadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        placeSP.setAdapter(placeadapter);
        
        
        zillaSP=(Spinner) findViewById(R.id.zillaSpinner);
        ArrayAdapter<CharSequence> zillaadapter = ArrayAdapter.createFromResource(this, R.array.zilla_array, android.R.layout.simple_spinner_item);
        zillaadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        zillaSP.setAdapter(zillaadapter);
        

        

        submitButton=(Button) findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String getUserName= userNameET.getText().toString();
				String height= heightET.getText().toString();
				String weight= weightET.getText().toString();		
				String sex= sexSP.getSelectedItem().toString();
				String education= educationalmySP.getSelectedItem().toString();
				String place= placeSP.getSelectedItem().toString();
				String zilla= zillaSP.getSelectedItem().toString();
				String country= countrySP.getSelectedItem().toString();
				String religion= religionSP.getSelectedItem().toString();
				String smoker= smokerSP.getSelectedItem().toString();
				String drink= drinkSP.getSelectedItem().toString();
				
				handler= new DataHandler(getBaseContext());
				handler.open();
				long id= handler.insertData(getUserName, height, weight, sex, education, place, zilla, country, religion, smoker, drink);
				Toast.makeText(getBaseContext(), "Data inserted :"+sex, Toast.LENGTH_LONG).show();				
				handler.close();
				startActivity(startUpIntent);
				
			}
		});
        
        birthDateButton=(Button) findViewById(R.id.birthDateButton);
        
        imageView=(ImageView) findViewById(R.id.image);
        
        
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

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
