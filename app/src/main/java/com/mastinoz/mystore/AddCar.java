package com.mastinoz.mystore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;

public class AddCar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);

        final EditText name   =   (EditText)findViewById(R.id.nameEditText);
        final EditText model  =   (EditText)findViewById(R.id.modelEditText);
        final EditText id     =   (EditText)findViewById(R.id.idEditText);
        final CheckBox status =   (CheckBox)findViewById(R.id.isNewCheckBox);
        Button addCar   =   (Button)findViewById(R.id.addButton);

        addCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Car car =   new Car();
                car.setName(name.getText().toString());
                car.setModel(model.getText().toString());
                car.setId(id.getText().toString());
                car.setStatus(status.isChecked());

                Realm realm =   Realm.getInstance(getApplicationContext());
                realm.beginTransaction();
                realm.copyToRealmOrUpdate(car);
                realm.commitTransaction();
                Toast.makeText(AddCar.this, "تم إضافة السيارة", Toast.LENGTH_SHORT).show();
                finish();

            }
        });

    }
}
