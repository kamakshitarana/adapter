package com.example.world_cup_app.simpleListView.GridLayoyt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.world_cup_app.R;

import java.util.ArrayList;

public class MyAdapterr extends ArrayAdapter<CourseModel> {

    public MyAdapterr(@NonNull Context context, ArrayList<CourseModel> courseModelArrayList) {
        super(context,0, courseModelArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listitemView =convertView;
        if (listitemView==null){
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.grid_card_item,parent,false);
        }

        CourseModel courseModel=getItem(position);
        TextView courseTitle =listitemView.findViewById(R.id.gridTextview);
        ImageView courseImageview= listitemView.findViewById(R.id.gridImageView);

        courseTitle.setText(courseModel.getCourse_name());
        courseImageview.setImageResource(courseModel.getCourse_img());
        return listitemView;
    }
}
