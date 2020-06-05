package com.example.nameandage;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper mDatabaseHelper;
    private Button button1,button2;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity2();
            }
        });

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor result = mDatabaseHelper.getAllData();
                if(result.getCount() ==0) {
                    showMessage("ERROR","Nothind Found");
                    return;
                }
                StringBuffer stringBuffer = new StringBuffer();
                while (result.moveToNext()) {
                    stringBuffer.append("ID :" + result.getString(0) + "\n");
                    stringBuffer.append("Name :" + result.getString(1) + "\n");
                    stringBuffer.append("AGE :" + result.getString(2) + "\n\n\n");
                }

                showMessage("DATA",stringBuffer.toString());

            }
        });
    }

    public void openMainActivity2() {
        Intent intent1 = new Intent(this, MainActivity2.class);
        startActivity(intent1);
    }

    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
    }

}