package com.examplelogin.myapplication;

import androidx.appcompat.app.AppCompatActivity;

        import android.content.Context;
        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.view.View;
        import android.widget.Button;

        import android.os.Bundle;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button BtnSave,BtnRead,btn1,btn2;
    String FileName="myFile";
    EditText edtName,edtPhone,edtDob,edtGender;
    TextView readName,readDob,readGender,readPhone;
    String name,dob,gender,phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=findViewById(R.id.idbtn1);
        btn2=findViewById(R.id.idbtn2);
        BtnSave=findViewById(R.id.idBtnSave);
        BtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveFile();
            }
        });
        BtnRead=findViewById(R.id.idBtnRead);
        BtnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readFile();
            }
        });
        edtName=findViewById(R.id.idName);
        edtDob=findViewById(R.id.idDOB);
        edtPhone=findViewById(R.id.idPhone);
        edtGender=findViewById(R.id.idGender);
        readName=findViewById(R.id.idReadtxt);
        readDob=findViewById(R.id.idReadDOB);
        readGender=findViewById(R.id.idReadGender);
        readPhone=findViewById(R.id.idReadPhone);
    }
    private void readFile(){
        SharedPreferences sharedPref1=getSharedPreferences(FileName, Context.MODE_PRIVATE);
        String defaultValue1="DefaultName";
        String name=sharedPref1.getString("name",defaultValue1);
        readName.setText(name);
        Toast.makeText(this,"Data: "+name,Toast.LENGTH_SHORT).show();
        SharedPreferences sharedPref2=getSharedPreferences(FileName, Context.MODE_PRIVATE);
        String defaultValue2="DefaultDob";
        String dob=sharedPref2.getString("dob",defaultValue2);
        readDob.setText(dob);
        Toast.makeText(this,"Data: "+dob,Toast.LENGTH_SHORT).show();
        SharedPreferences sharedPref3=getSharedPreferences(FileName, Context.MODE_PRIVATE);
        String defaultValue3="DefaultGender";
        String gender=sharedPref3.getString("gender",defaultValue3);
        readGender.setText(gender);
        Toast.makeText(this,"Data: "+gender,Toast.LENGTH_SHORT).show();
        SharedPreferences sharedPref4=getSharedPreferences(FileName, Context.MODE_PRIVATE);
        String defaultValue4="DefaultPhone";
        String phone=sharedPref4.getString("phone",defaultValue4);
        readPhone.setText(phone);
        Toast.makeText(this,"Data: "+phone,Toast.LENGTH_SHORT).show();
    }

    private void saveFile(){
        String strName=edtName.getText().toString();
        SharedPreferences sharedPref1=getSharedPreferences(FileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor1=sharedPref1.edit();
        editor1.putString("name",strName);
        editor1.commit();
        String strDob=edtDob.getText().toString();
        SharedPreferences sharedPref2=getSharedPreferences(FileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor2=sharedPref2.edit();
        editor2.putString("dob",strDob);
        editor2.commit();
        String strGender=edtGender.getText().toString();
        SharedPreferences sharedPref3=getSharedPreferences(FileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor3=sharedPref3.edit();
        editor3.putString("gender",strGender);
        editor3.commit();
        String strPhone=edtPhone.getText().toString();
        SharedPreferences sharedPref4=getSharedPreferences(FileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor4=sharedPref4.edit();
        editor4.putString("phone",strPhone);
        editor4.commit();


        Toast.makeText(this,"Data saved successfully ",Toast.LENGTH_SHORT).show();
    }

     public void btn1(View v){
       Intent i=new Intent(this,MainActivity2.class);
      startActivity(i);
   }

    public void btn2(View v) {
        Intent i=new Intent(this,MainActivity4.class);
        startActivity(i);
    }
}