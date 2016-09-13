package com.mastinoz.mystore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;
import java.util.Random;

import io.realm.Realm;
import io.realm.RealmResults;

public class ShowAll extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all);

        Button addCar = (Button)findViewById(R.id.addButton);

        addCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShowAll.this,AddCar.class);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();

        Realm realm =   Realm.getInstance(getApplicationContext());
        List<Car>   cars    =   realm.allObjects(Car.class);
        String[]    names   =   new String[cars.size()];
        for (int i=0;i<names.length;i++){
            names[i]=cars.get(i).getName();
        }

        ListView listView   =   (ListView)findViewById(R.id.listView);
        ArrayAdapter<String>    adapter =   new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,names);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent   =   new Intent(ShowAll.this,editCar.class);
                intent.putExtra("id",position);
                startActivity(intent);

            }
        });

    }
}
