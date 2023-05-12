package com.example.world_cup_app.simpleListView.CarviewGame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.world_cup_app.R;

import java.util.ArrayList;

public class CardView extends AppCompatActivity {

    //1-data
    ArrayList<CarviewModel> gameList;

    //2-adapter view
    RecyclerView recyclerView;

    //3-Adapter
    CarviewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);

        /**CARDVIEW
         * cardview is a new widget in android that can be used to display any
         * sort of data by providing a rounded corner layout with a
         * specific elevation.
         * **/

        recyclerView =findViewById(R.id.Recyle_view3);
        ArrayList<CarviewModel> gameList = new ArrayList<CarviewModel>();
        gameList.add(new CarviewModel("Horizon chase",R.drawable.india));
        gameList.add(new CarviewModel("Horizon chase",R.drawable.india));
        gameList.add(new CarviewModel("Horizon chase",R.drawable.india));
        gameList.add(new CarviewModel("Horizon chase",R.drawable.india));
        gameList.add(new CarviewModel("Horizon chase",R.drawable.india));
        gameList.add(new CarviewModel("Horizon chase",R.drawable.india));
        gameList.add(new CarviewModel("Horizon chase",R.drawable.india));
        gameList.add(new CarviewModel("Horizon chase",R.drawable.india));
        gameList.add(new CarviewModel("Horizon chase",R.drawable.india));
        gameList.add(new CarviewModel("Horizon chase",R.drawable.india));
        gameList.add(new CarviewModel("Horizon chase",R.drawable.india));

                adapter=new CarviewAdapter(this,gameList);
                RecyclerView.LayoutManager layoutManager =new
                        LinearLayoutManager(this,LinearLayoutManager.VERTICAL,
                       false );

                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(adapter);

    }
}