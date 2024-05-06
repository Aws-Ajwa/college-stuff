package jo.edu.bau.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;

public class MyDatabase extends SQLiteOpenHelper {
    public static final String Database_name="ContactApp.db";
    public static final String table_name="contact";
    public static final String col_1="ID";
    public static final String col_2="name";
    public static final String col_3="phone";


    public MyDatabase(Context context) {

        super(context, Database_name, null, 1);
        this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE CONTACT(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, PHONE TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS contact");
        onCreate(db);
    }

    public boolean insert(String name, String phone)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(col_2, name);
        values.put(col_3, phone);
        long result=db.insert("CONTACT", null,values );
        //db.close();
        if(result==-1)
            return false;
        else
            return true;

    }


}
