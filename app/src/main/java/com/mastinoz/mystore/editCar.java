package com.mastinoz.mystore;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import io.realm.Realm;

public class editCar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_car);

        int i   =   getIntent().getIntExtra("id",0);

        final   EditText    name        =   (EditText)findViewById(R.id.nameEditText);
        final   EditText    model       =   (EditText)findViewById(R.id.modelEditText);
        final   EditText    id          =   (EditText)findViewById(R.id.idEditText);
        final   CheckBox    status      =   (CheckBox)findViewById(R.id.isNewCheckBox);

        final Realm realm   =   Realm.getInstance(getApplication());
        List<Car>   cars    =   realm.allObjects(Car.class);
        final Car   car     =   cars.get(i);

        name.setText(car.getName());
        model.setText(car.getModel());
        id.setText(car.getId());
        status.setChecked(car.isStatus());

        Button  delete  =   (Button)findViewById(R.id.deleteButton);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new AlertDialog.Builder(editCar.this)
                        .setTitle("تنبيه")
                        .setMessage("هل أنت متاكد من حدف السيارة")
                        .setPositiveButton("نعم", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                realm.beginTransaction();
                                car.removeFromRealm();
                                realm.commitTransaction();
                                finish();
                            }
                        })
                        .setNegativeButton("لا", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .show();
            }
        });

        Button  update  =   (Button)findViewById(R.id.updateButton);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new AlertDialog.Builder(editCar.this)
                        .setTitle("تنبيه")
                        .setMessage("هل أنت متاكد من أنك تريد تعديل معلومات السيارة الحالية")
                        .setPositiveButton("نعم", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                realm.beginTransaction();

                                car.setName(name.getText().toString());
                                car.setModel(model.getText().toString());
                                car.setStatus(status.isChecked());
                                car.setId(id.getText().toString());

                                realm.copyToRealmOrUpdate(car);
                                realm.commitTransaction();

                                Toast.makeText(editCar.this, "تم التعديل", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("لا", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .show();
            }
        });

    }
}
