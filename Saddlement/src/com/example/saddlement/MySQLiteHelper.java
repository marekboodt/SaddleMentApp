package com.example.saddlement;

import java.util.LinkedList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

public class MySQLiteHelper extends SQLiteOpenHelper{

	//Database versie
	private static final int DATABASE_VERSION = 1;
	//Database naam
	private static final String DATABASE_NAME = "Pakketten2DB";
	
	
	public MySQLiteHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}


	@Override
	public void onCreate(SQLiteDatabase db) {
		//SQL statement voor het maken van de database
		String CREATE_PAKKETTEN_TABEL = "CREATE TABLE pakketten2 ( "
				+ "id INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ "afleveradres TEXT,"
				+ "status TEXT)";
		//Maak tabel Pakketten aan		
		db.execSQL(CREATE_PAKKETTEN_TABEL);
	}


	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Verwijder tabel als het bestaat
		db.execSQL("DROP TABLE IF EXISTS pakketten2");
		
		this.onCreate(db);
	}
	
	/*
	 * CRUD - create, read, update, delete hieronder
	 *
	 */
	
	//Pakketten tabel naam
	private static final String TABLE_PAKKETTEN = "pakketten2";
	
	//Pakketten tabel kolom namen
	private static final String KEY_ID = "id";
	//private static final String KEY_PAKKETID = "pakketID";
	private static final String KEY_AFLEVERADRES = "afleveradres";
	private static final String KEY_STATUS = "status";
//	private static final String KEY_GEWICHT = "gewicht";
//	private static final String KEY_AFMETINGEN = "afmetingen";
	//private static final String KEY_AANKOMST = "aankomst";
	
	private static final String[] KOLOMMEN = {KEY_ID,KEY_AFLEVERADRES,KEY_STATUS};
	
	public void addPakket (PakkettenTabel pakkettenTabel){
		//loggen
		Log.d("addPakket", pakkettenTabel.toString());
		
		SQLiteDatabase db = this.getWritableDatabase();
		
		//Met contentvalues kan je een set values opslaan
		ContentValues values = new ContentValues();
		values.put(KEY_AFLEVERADRES, pakkettenTabel.getAfleveradres());
		values.put(KEY_STATUS, pakkettenTabel.getStatus());
		
		//Insert in de tabel
		db.insert(TABLE_PAKKETTEN, null, values);
		
		db.close();
		
	}
	
	public PakkettenTabel getPakket (int id){
		SQLiteDatabase db = this.getWritableDatabase();
		
		//hiermee maak je de query.
	    Cursor cursor = 
                db.query(TABLE_PAKKETTEN, // a. table
                KOLOMMEN, // b. column names
                " id = ?", // c. selections 
                new String[] { String.valueOf(id) }, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit
		
		//als we de resultaten krijgen, toon dan alleen de eerste


		if (cursor != null)
	        cursor.moveToFirst();
	   
	    PakkettenTabel pakketje = new PakkettenTabel();
	    pakketje.setId(Integer.parseInt(cursor.getString(0)));
	    pakketje.setAfleveradres(cursor.getString(1));
	    pakketje.setStatus(cursor.getString(2));
	    
	 
	    Log.d("getPakket("+id+")", pakketje.toString());

		return pakketje;

		
	}
	
	public List<PakkettenTabel> getAllBooks() {
	       List<PakkettenTabel> books = new LinkedList<PakkettenTabel>();
	 
	       // 1. build the query
	       String query = "SELECT  * FROM " + TABLE_PAKKETTEN;
	 
	       // 2. get reference to writable DB
	       SQLiteDatabase db = this.getWritableDatabase();
	       Cursor cursor = db.rawQuery(query, null);
	 
	       // 3. go over each row, build book and add it to list
	       PakkettenTabel book = null;
	       if (cursor.moveToFirst()) {
	           do {
	               book = new PakkettenTabel();
	               book.setId(Integer.parseInt(cursor.getString(0)));
	               book.setAfleveradres(cursor.getString(1));
	               book.setStatus(cursor.getString(2));

	               // Add book to books
	               books.add(book);
	           } while (cursor.moveToNext());
	       }
	 
	       Log.d("getAllBooks()", books.toString());
	 
	       // return books
	       return books;
	   }


	public void deleteBook(PakkettenTabel pakkettenTabel) {

        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
 
        // 2. delete
        db.delete(TABLE_PAKKETTEN, //table name
                KEY_ID+" = ?",  // selections
                new String[] { String.valueOf(pakkettenTabel.getId()) }); //selections args
 
        // 3. close
        db.close();
 
        //log
    Log.d("deleteBook", pakkettenTabel.toString());
 		
	}
}
