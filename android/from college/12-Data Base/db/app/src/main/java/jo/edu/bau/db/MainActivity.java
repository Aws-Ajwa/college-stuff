package jo.edu.bau.db;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    MyDatabase mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         mydb=new MyDatabase(this);

    }


    public void addNewContact(View view) {
        EditText tname=(EditText) findViewById(R.id.txtName);
        EditText tphone=(EditText) findViewById(R.id.txtPhone);

        mydb.insert(tname.getText().toString(), tphone.getText().toString());
    }
}
