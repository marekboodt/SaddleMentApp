package com.example.saddlement;


import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Pakket extends ActionBarActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pakket);
		
		MySQLiteHelper db = new MySQLiteHelper(this);
		db.addPakket(new PakkettenTabel("D.C.Meesstraat 6","Onderweg"));
		db.addPakket(new PakkettenTabel("D.C.Meesstraat 5","Onderwegg"));

		
		List<PakkettenTabel> list = db.getAllBooks();
		TextView textview = (TextView)findViewById(R.id.textView10);
		int grootte = list.size();
		
		textview.setText(String.valueOf(grootte));
		
		for(int listcounter=0;listcounter<grootte;listcounter++){
			
			PakkettenTabel pk = list.get(listcounter);  //eerste row want listcounter = 0
			textview.append("afleveradres: "+pk.getAfleveradres());
			textview.append("status: "+pk.getStatus());
			
			listcounter++;
			
		}
		
        // delete one book
    //    db.deleteBook(list.get(0));
        db.getPakket(10);
        
        
        // get all books
   //     db.getAllBooks();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.

	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.optionsmenu, menu);
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