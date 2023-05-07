package com.example.world_cup_app.simpleListView.customListView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.world_cup_app.R;

import java.util.ArrayList;

public class CustomList extends AppCompatActivity {
    ListView listVieww;
    private static CustomAdapter adapter;
    ArrayList<CountriesModel> datamodels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);

        // 1-adapter view: a listview
        listVieww =findViewById(R.id.listView2);

        //2-data source
         datamodels =new ArrayList<>();
         datamodels.add(new CountriesModel("Germany","4",R.drawable.azflag));
         datamodels.add(new CountriesModel("India","54",R.drawable.india));
         datamodels.add(new CountriesModel("Frenc","3",R.drawable.egg));
         datamodels.add(new CountriesModel("Pakistan","0",R.drawable.worldatles));
         datamodels.add(new CountriesModel("US","1",R.drawable.azflag));
         datamodels.add(new CountriesModel("Pakk","1",R.drawable.egg));
         datamodels.add(new CountriesModel("Meerut","45",R.drawable.india));

         //3 adapter
        adapter =new CustomAdapter(datamodels,getApplicationContext());
        listVieww.setAdapter(adapter);

        //4- Handling the click events on listview items
        listVieww.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Toast.makeText(CustomList.this, "Country" + adapter.getItem(i).getCountry_name() + "\n" +
                                "World Cups wins: "+adapter.getItem(i).getCup_win_count()
                        , Toast.LENGTH_SHORT).show();

            }
        });
    }
}