package base.fire.com.listviewadapter.database;

import android.provider.BaseColumns;

/**
 * Database Table field declaration class.
 * Add Each Table column details as an abstract inner class.
 * and derive it for customization
 */
public final class DatabaseField {

    public DatabaseField() {
    }


    public static abstract class ChatMessages implements BaseColumns {
        public static final String TABLE_NAME = "table_name";

        //Column names
        public static final String COLUMN_FIRST= "first";
        public static final String COLUMN_SECOND= "second";


        //Indices
        public static final int INDEX_FIRST= 1;
        public static final int INDEX_SECOND = 1;



    }
}