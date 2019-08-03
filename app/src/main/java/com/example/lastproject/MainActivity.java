package com.example.lastproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText name,age;
    Button buttons;
    DatabaseReference reff;
    Reports report;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        report=new Reports();
      name=(EditText)findViewById(R.id.name);

      age=(EditText)findViewById(R.id.age);

      buttons=(Button) findViewById(R.id.button2);

      reff= FirebaseDatabase.getInstance().getReference().child("Reports");
      buttons.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              int ages=Integer.parseInt(age.getText().toString().trim());

              report.setName(name.getText().toString().trim());
              report.setAge(ages);
              reff.push().setValue(report);
              Toast.makeText(MainActivity.this, "INSERT", Toast.LENGTH_SHORT).show();

          }
      });


    }
}
