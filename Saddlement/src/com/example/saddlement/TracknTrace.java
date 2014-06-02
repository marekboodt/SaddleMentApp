package com.example.saddlement;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TracknTrace extends ActionBarActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.trackntrace);
		

		
		Button button2 = (Button)findViewById(R.id.button2);
		final EditText mEdit = (EditText)findViewById(R.id.editText2);
		
		button2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String trackntrace = mEdit.getText().toString();					//maak van de input een String
				Editable trackntraceInt = mEdit.getText();
				int trackntraceInt2 = Integer.parseInt(trackntrace.toString());		//maak van de input een int
				Intent intent = new Intent(TracknTrace.this, Pakket.class);
				intent.putExtra("Track_Trace", trackntraceInt2);
				startActivity(intent);
			}
		});
		
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
        	Intent intent = new Intent(TracknTrace.this, Pakket.class);		
			startActivity(intent);
            return true;
        case R.id.app:
        	Intent intent2 = new Intent(TracknTrace.this, OverApp.class);		
			startActivity(intent2);
        	return true;
        case R.id.faq:
        	Intent intent3 = new Intent(TracknTrace.this, Faq.class);		
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