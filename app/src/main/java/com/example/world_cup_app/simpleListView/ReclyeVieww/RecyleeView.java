package com.example.world_cup_app.simpleListView.ReclyeVieww;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.world_cup_app.R;

public class RecyleeView extends AppCompatActivity implements ItemClickListener{

    //1-AdapterView: RecylerView
    RecyclerView recyclerView;

    //2- data source:
    VaccineModel[] myListData;

    //3- Adapter
    MyAdapter myAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recylee_view);

        //recyle efficiential used for the visible large amount of data
        //u supply the data and define how each item looks and the recycler view liebrary dynamically creates
          //the elements when they are needed.
        recyclerView =findViewById(R.id.recyleView);

        myListData =new VaccineModel[]{
                new VaccineModel("Hepatitis B Vaccine", R.drawable.azflag),
                new VaccineModel("Tetanus Vaccine", R.drawable.india),
                new VaccineModel("pneumococal vaccine", R.drawable.worldatles),
                new VaccineModel("corona B Vaccine", R.drawable.egg),
                new VaccineModel("Covind 19 B Vaccine", R.drawable.azflag),
                new VaccineModel("Hepatitis B Vaccine", R.drawable.india),
                new VaccineModel("Hepatitis B Vaccine", R.drawable.azflag),
                new VaccineModel("Chlere virus  Vaccine", R.drawable.egg),
                new VaccineModel("Hepatitis B Vaccine", R.drawable.azflag),
        };

        //adapter

        myAdapter =new MyAdapter(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);

        //handling the click events here
        myAdapter.setClickListener(this);

    }

    @Override
    public void onClick(View view, int pos) {
        Toast.makeText(this, "Vaccine name" +myListData[pos].getTitle(), Toast.LENGTH_SHORT).show();
        

    }
}