package com.example.saddlement;


import java.util.List;

import android.R.layout;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class AllePakketten extends ActionBarActivity {
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.allepakketten);
		
		String[] pakkettn = new String[11];
		
		pakkettn[0] = "Bol.com";
		pakkettn[1] = "Mediamarkt";		
		pakkettn[2] = "Zalando";		
		pakkettn[3] = "Bol.com"; 		
		pakkettn[4] = "Mediamarkt";	
		pakkettn[5] = "Zalando";		
		pakkettn[6] = "Bol.com";		
		pakkettn[7] = "Mediamarkt";		
		pakkettn[8] = "Zalando";		
		pakkettn[9] = "Mediamarkt";	
		pakkettn[10] = "Bol.com";		
		
		int numPakketten = 11;
		
	    // tablelayout
        TableLayout tl = (TableLayout) findViewById(R.id.tableLayout1);

        for (int current = 0; current < numPakketten; current++)
        {
            // maak table row aan
            TableRow tr = new TableRow(this);
            tr.setId(100+current);
            tr.setBackgroundResource(R.drawable.borders);
            tr.setLayoutParams(new LayoutParams(
                    LayoutParams.WRAP_CONTENT,
                    LayoutParams.WRAP_CONTENT));   

            // textview voor elke afzender
            TextView afzender = new TextView(this);
            afzender.setId(200+current);
            afzender.setText(pakkettn[current]);
            afzender.setTextColor(Color.BLACK);
    		afzender.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);            
    		afzender.setTypeface(Typeface.create("Segoe UI Light", Typeface.NORMAL));
    		
    		
    		TableRow.LayoutParams params = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,TableRow.LayoutParams.MATCH_PARENT);
    		params.setMargins(15, 15, 15, 15);
    		
    		afzender.setLayoutParams(params);

            tr.addView(afzender);
            
           
            
            
            
//            Button button = new Button(this);
//            button.setId(200+current);
//
//            button.setBackgroundResource(R.drawable.pijltje);
//            tr.addView(button);

            // Add the TableRow to the TableLayout
            tl.addView(tr, new TableLayout.LayoutParams(
                    LayoutParams.FILL_PARENT,
                    LayoutParams.WRAP_CONTENT));
        }
		
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
	        	Intent intent = new Intent(AllePakketten.this, AllePakketten.class);		
				startActivity(intent);
	            return true;
	        case R.id.app:
	        	Intent intent2 = new Intent(AllePakketten.this, OverApp.class);		
				startActivity(intent2);
	        	return true;
	        case R.id.faq:
	        	Intent intent3 = new Intent(AllePakketten.this, Faq.class);		
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