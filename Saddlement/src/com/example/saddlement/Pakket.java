package com.example.saddlement;


import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Pakket extends ActionBarActivity {
	private TextView textview;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pakket);
		
		MySQLiteHelper db = new MySQLiteHelper(this);
	//	db.addPakket(new PakkettenTabel("D.C.Meesstraat 6","Onderweg"));
	//	db.addPakket(new PakkettenTabel("D.C.Meesstraat 5","Onderwegg"));

		
		List<PakkettenTabel> list = db.getAllBooks();
		textview = (TextView)findViewById(R.id.textView10);
		
		
		
		int grootte = list.size();
		
		String returnCode = getIntentExtra();
		int returnCodeInt = getIntentExtraInt();
		this.setTitle("Pakket: #" +returnCodeInt); //.toUpperCase()
		
		
//		textview.setText(String.valueOf("Aantal records: "+grootte+"\n\n"));  //setText overwrites alles.
		
	
		/*
		for(int listcounter=0;listcounter<grootte;listcounter++){
			
			PakkettenTabel pk = list.get(listcounter);  //eerste row want listcounter = 0
			textview.append("id: "+pk.getId());
			textview.append("afleveradres: "+pk.getAfleveradres());
			textview.append("status: "+pk.getStatus());
			
			textview.append("\n");
		}
		
		*/
		PakkettenTabel tnt = db.getPakket(returnCodeInt);
		
		textview.append("ID: "+tnt.getId()+"\n");
		textview.append("Afleveradres: "+tnt.getAfleveradres()+"\n");
		textview.append("Status: "+tnt.getStatus()+"\n");

		textview.append("\n");
		

		
        // delete one book
    //    db.deleteBook(list.get(0));
    //   db.getPakket(4);
        
        
        // get all books
    //    db.getAllBooks();
	}
	
	public String getIntentExtra(){
	
		Intent intent = getIntent();
		String tntCode = intent.getExtras().getString("Track_Trace");
		return tntCode;
		
	}
	
	public int getIntentExtraInt(){
		
		Intent intent = getIntent();
		int tntCode = intent.getIntExtra("Track_Trace", 0);
		return tntCode;
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
	        	Intent intent = new Intent(Pakket.this, Pakket.class);		
				startActivity(intent);
	            return true;
	        case R.id.app:
	        	Intent intent2 = new Intent(Pakket.this, OverApp.class);		
				startActivity(intent2);
	        	return true;
	        case R.id.faq:
	        	Intent intent3 = new Intent(Pakket.this, Faq.class);		
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