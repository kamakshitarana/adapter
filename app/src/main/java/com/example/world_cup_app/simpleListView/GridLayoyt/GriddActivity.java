package com.example.world_cup_app.simpleListView.GridLayoyt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import com.example.world_cup_app.R;

import java.util.ArrayList;

public class GriddActivity extends AppCompatActivity {

    GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridd);
        gridView =findViewById(R.id.grid_View);

        //data to be displayed into gridview
        ArrayList<CourseModel> courseModelArrayList =new ArrayList<CourseModel>();
        courseModelArrayList.add(new CourseModel("The complete Android 12 course",R.drawable.india));
        courseModelArrayList.add(new CourseModel("The complete Android 12 course",R.drawable.india));
        courseModelArrayList.add(new CourseModel("The complete Android 12 course",R.drawable.india));
        courseModelArrayList.add(new CourseModel("The complete Android 12 course",R.drawable.india));
        courseModelArrayList.add(new CourseModel("The complete Android 12 course",R.drawable.india));

        //attach the adapter
        MyAdapterr myAdapterr =new MyAdapterr(this,courseModelArrayList);
        gridView.setAdapter(myAdapterr);

    }
}