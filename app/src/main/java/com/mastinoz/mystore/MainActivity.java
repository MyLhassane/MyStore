package com.mastinoz.mystore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText userName = (EditText)findViewById(R.id.userNameEditText);
        final EditText password = (EditText)findViewById(R.id.passEditText);

        Button login = (Button)findViewById(R.id.loginButton);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Realm realm=Realm.getInstance(getApplicationContext());
                RealmQuery<User> query=realm.where(User.class);
                query.equalTo("userName",userName.getText().toString());
                query.equalTo("password",password.getText().toString());
                RealmResults<User> results=query.findAll();
                if (results.size()>0){
                    Intent intent = new Intent(MainActivity.this,AddCar.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(MainActivity.this, "بيانات المستخدم خاطئة", Toast.LENGTH_SHORT).show();
                }

            }
        });


        Button regester = (Button)findViewById(R.id.regesterButton);
        regester.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,RegActivity.class);
                startActivity(i);
            }
        });

    }
}
