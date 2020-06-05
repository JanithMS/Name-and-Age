package com.example.nameandage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    DatabaseHelper mDatabaseHelper;
    private Button buttonsave;
    private EditText name,age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        buttonsave = (Button) findViewById(R.id.button3);
        name = (EditText) findViewById(R.id.editTextTextPersonName);
        age = (EditText) findViewById(R.id.editTextTextPersonAge);
        mDatabaseHelper = new DatabaseHelper(this);

        buttonsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  newEntry1 = name.getText().toString();
                String  newEntry2 = age.getText().toString();
                if(name.length() !=0 && age.length() != 0){
                    AddData(newEntry1, newEntry2);
                    name.setText("");
                    age.setText("");
                }
                else if (name.length() ==0 && age.length() != 0){
                    toastMessage("You must enter the Name!");
                }
                else if (name.length() !=0 && age.length() == 0){
                    toastMessage("You must enter the Age!");
                }
                else {
                    toastMessage("You must enter Name and Age");
                }
            }
        });

    }

    public void AddData(String newEntry1, String  newEntry2) {
        boolean insertData = mDatabaseHelper.addData(newEntry1,newEntry2);
        if(insertData){
            toastMessage("Data Successfully Inserted!");
        }
        else{
            toastMessage("Something went wrong");
        }
    }

    private  void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }

}