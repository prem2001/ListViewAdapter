package base.fire.com.listviewadapter.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

import java.util.List;

/**
 * Database management Class
 */
public final class DatabaseManager {
    // db help object
    public HistoryDBHelper dbHelper;

    //Activity context
    private Context context;


    public DatabaseManager(Context context) {
        this.context = context;
    }

    /**
     * Init the db helper object
     */
    public void open() {
        dbHelper = new HistoryDBHelper(context);
    }

    /**
     * Close the db object
     */
    public void close() {
        dbHelper.close();
    }

    /* Utility Methods */

    public void create() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        dbHelper.onCreate(db);

    }






    public void insertDataToSqliteDB(String first, String second) {

        ///****this is for modification it will delete all data then put it
//        String deleteQuery =
//                "DELETE FROM " + DatabaseField.ChatMessages.TABLE_NAME +
//                        " WHERE " + DatabaseField.ChatMessages.COLUMN_SELLER_COMPANY + "='" + seller_company +
//                        "' AND " + DatabaseField.ChatMessages.COLUMN_SELLER_CITY + "='" + seller_city +
//
//                        "'";
//
//        SQLiteDatabase db = dbHelper.getWritableDatabase();
//        db.execSQL(deleteQuery);

        ContentValues insertValues = new ContentValues();
        insertValues.put(DatabaseField.ChatMessages.COLUMN_FIRST, first);
        insertValues.put(DatabaseField.ChatMessages.COLUMN_SECOND, second);


        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.insert(DatabaseField.ChatMessages.TABLE_NAME, null, insertValues);

        db.close();

        /* Delete most old Search From the table */
//        deleteOldSearch(DatabaseField.ChatMessages.TABLE_NAME);
    }

    public Cursor getFirstRowData() {
        final String TABLE_NAME = DatabaseField.ChatMessages.TABLE_NAME;

        String selectQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor ;
        return db.rawQuery(selectQuery, null);

    }

    public String getAllData() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String data=null;
        Cursor cursor = db.rawQuery("select * from "+DatabaseField.ChatMessages.TABLE_NAME, null);
        if (cursor.moveToFirst()){
            do{
            data = cursor.getString(cursor.getColumnIndex("first"));
            // do what ever you want here
            }while(cursor.moveToNext());
        }
        cursor.close();
        return data;
    }



    /**
     * Database implementation class
     */
    public class HistoryDBHelper extends SQLiteOpenHelper {
        /**
         * Database version code for the update
         */
        public static final int DATABASE_VERSION = 4;

        /**
         * Database name
         */
        public static final String DATABASE_NAME = "PremDB.db";

        private static final String TEXT_TYPE = " TEXT";
        private static final String COMMA_SEP = ", ";



        private static final String SQL_CREATE_CHAT_MESSAGES =
                "CREATE TABLE " + DatabaseField.ChatMessages.TABLE_NAME + " (" +
                        "_id" + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        DatabaseField.ChatMessages.COLUMN_FIRST + TEXT_TYPE + COMMA_SEP +
                        DatabaseField.ChatMessages.COLUMN_SECOND + TEXT_TYPE +
                        ")";





        //Delete query for chat history
        private static final String SQL_DELETE_CHAT_MESSAGES =
                "DROP TABLE IF EXISTS " + DatabaseField.ChatMessages.TABLE_NAME;


        public HistoryDBHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }



        public void onCreate(SQLiteDatabase db) {

            db.execSQL(SQL_CREATE_CHAT_MESSAGES);
        }


        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            if (newVersion > oldVersion) {
                db.execSQL(SQL_DELETE_CHAT_MESSAGES);
                onCreate(db);
            }
        }

        public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            onUpgrade(db, oldVersion, newVersion);
        }


    }
}