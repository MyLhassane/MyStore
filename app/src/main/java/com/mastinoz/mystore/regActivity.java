package com.mastinoz.mystore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import io.realm.Realm;

/**
 * Created by hassan on 8/10/16.
 */
public class regActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        final EditText userName = (EditText)findViewById(R.id.userNameEditText);
        final EditText password = (EditText)findViewById(R.id.passEditText);
        Button reg = (Button)findViewById(R.id.regButton);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User();
                user.setUserName(userName.getText().toString());
                user.setPassword(password.getText().toString());

                Realm realm = Realm.getInstance(getApplicationContext());
                realm.beginTransaction();
                realm.copyToRealmOrUpdate(user);
                realm.commitTransaction();
            }
        });

    }
}
