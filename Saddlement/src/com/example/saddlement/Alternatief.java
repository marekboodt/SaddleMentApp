package com.example.saddlement;


import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Alternatief extends ActionBarActivity {
	private TextView textview;
	private TextView textview12;
	private TextView textview13;
	private TextView textview14;
	private TextView textview15;
	private TextView textview16;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.alternatief);
		
	}

	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.

	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.optionsmenu, menu);
	    
	//    MenuItem pakketId= menu.add(0,5,0,"Logout");
	//    pakketId.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
	    //MENU ITEM ADDEN IN DE OVERFLOW GEDEELTE
	    
	    return true;
	}


	
	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {
	        case R.id.pakketten:
	        	Intent intent = new Intent(Alternatief.this, AllePakketten.class);		
				startActivity(intent);
	            return true;
	        case R.id.app:
	        	Intent intent2 = new Intent(Alternatief.this, OverApp.class);		
				startActivity(intent2);
	        	return true;
	        case R.id.faq:
	        	Intent intent3 = new Intent(Alternatief.this, Faq.class);		
				startActivity(intent3);
	        	return true;        	
	        case R.id.logout:
	        	//code
	        	return true;        	
	        	
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
}