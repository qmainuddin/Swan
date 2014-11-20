package com.example.kazi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DataHandler {
	
	public static final String USER_NAME="userNameEditText";
	public static final String HEIGHT="heightEditText";
	public static final String WEIGHT="weightEditText";
	public static final String SEX="sexSP";
	public static final String EDUCATION="educationSP";
	public static final String PLACE="placeSP";
	public static final String ZILLA="zillaSP";
	public static final String COUNTRY="countrySP";
	public static final String RELIGION="religionSP";
	public static final String SMOKER="smokerSP";
	public static final String DRINK="drinkSP";
	public static final String CHARECTER="charecterET";
	public static final String USER_TABLE_NAME="myTable";
	public static final String PARTNER_TABLE_NAME="partnerTable";
	public static final int DATABASE_VERSION=3;
	public static final String DATABASE_NAME="myDatabase";
	public static final String USER_TABLE_CREATE= "create table myTable(userNameEditText text not null,heightEditText text not null, weightEditText text not null,sexSP text not null,educationSP text not null,placeSP text not null,zillaSP text not null,countrySP text not null,religionSP text not null,smokerSP text not null,drinkSP text not null);";
	public static final String PARTNER_TABLE_CREATE= "create table partnerTable(sexSP text not null,religionSP text not null,educationSP text not null,heightEditText text not null,weightEditText text not null,placeSP text not null,zillaSP text not null,charecterET text not null);";
	
	DataBaseHelper dbHelper;
	Context ctx;
	SQLiteDatabase db;
	
	
	public DataHandler(Context ctx)
	{
		this.ctx=ctx;
		dbHelper = new DataBaseHelper(ctx);
	}
	
	private static class DataBaseHelper extends SQLiteOpenHelper
	{
		
		
		public DataBaseHelper(Context ctx) {
			super(ctx, DATABASE_NAME, null,DATABASE_VERSION);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
		
			try{
			db.execSQL(USER_TABLE_CREATE);
			db.execSQL(PARTNER_TABLE_CREATE);
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}						
		}
		
		
		

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			db.execSQL("DROP TABLE IF EXISTS myTable");
			db.execSQL("DROP TABLE IF EXISTS partnerTable");
			onCreate(db);
		}
		
		
		
	}
	
	public DataHandler open()
	{
		db= dbHelper.getWritableDatabase();
		return this;
	}
	
	public void close()
	{
		dbHelper.close();
	}
	
	public long insertData(String userName, String height, String weight,String sexSP,String educationalmySP,String placeSP,String zillaSP,String countrySP,String religionSP,String smokerSP,String drinkSP) {
		ContentValues content = new ContentValues();
		content.put(USER_NAME, userName);
		content.put(HEIGHT, height);
		content.put(WEIGHT, weight);
		content.put(SEX,sexSP);
		content.put(EDUCATION,educationalmySP);
		content.put(ZILLA,zillaSP);
		content.put(PLACE,placeSP);
		content.put(COUNTRY,countrySP);
		content.put(RELIGION,religionSP);
		content.put(DRINK,drinkSP);
		content.put(SMOKER,smokerSP);
		return db.insertOrThrow(USER_TABLE_NAME, null, content);
		
	}
	
	public long insertPartnerData(String sex,String religion,String education,String height,String weight,String place,String zilla,String charecter){
		ContentValues content = new ContentValues();
		content.put(SEX,sex );
		content.put(RELIGION,religion );
		content.put(EDUCATION,education );
		content.put(HEIGHT,height );
		content.put(WEIGHT,weight );
		content.put(PLACE,place );
		content.put(ZILLA,zilla );
		content.put(CHARECTER,charecter );
		return db.insertOrThrow(PARTNER_TABLE_NAME, null, content);
	}
	
	public Cursor returnData() {
		return db.query(USER_TABLE_NAME, new String[]{USER_NAME, HEIGHT, WEIGHT}, null, null, null, null, null);
	}

}
