package com.example.world_cup_app.simpleListView.customListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.world_cup_app.R;
import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<CountriesModel> {
   private ArrayList<CountriesModel> countryArrayList;
   Context context;

    public CustomAdapter(ArrayList<CountriesModel> data ,Context context) {
        super(context, R.layout.my_list2,data);
        this.countryArrayList = data;
        this.context = context;
    }
//created the class here viewholder  view look cache
    private static class ViewHolder{
        TextView txtCountry;
        TextView cupwins;
        ImageView flagimg;
}


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //get the data item for this position
        CountriesModel countriesModel =getItem(position);

        //check if an existing view is being reused ,otherwise inflate the view
        ViewHolder viewHolder;   //viewholder describe an item view and metadata recyler view and other custom layout,
        final  View result;
        if (convertView==null){
            viewHolder=new ViewHolder();
            LayoutInflater inflater =LayoutInflater.from(getContext());
            convertView =inflater.inflate(
                    R.layout.my_list2,
                    parent,false
                    );

            viewHolder.txtCountry=(TextView) convertView.findViewById(R.id.country_name);
            viewHolder.cupwins=(TextView) convertView.findViewById(R.id.cup_win_desc);
            viewHolder.flagimg=(ImageView) convertView.findViewById(R.id.img_view);
            result=convertView;
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder=(ViewHolder) convertView.getTag();
            result=convertView;
        }

        //get the data from the model
        if (viewHolder.txtCountry != null) {
            viewHolder.txtCountry.setText(countriesModel.getCountry_name());
        }
        if (viewHolder.cupwins != null) {
            viewHolder.cupwins.setText(countriesModel.getCup_win_count());
        }
        if (viewHolder.flagimg != null) {
            viewHolder.flagimg.setImageResource(countriesModel.getFlag_img());

        }
        return convertView;

    }
}
