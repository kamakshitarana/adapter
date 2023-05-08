package com.example.world_cup_app.simpleListView.ReclyeVieww;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.world_cup_app.R;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    //4- click handling the click events
    public ItemClickListener clickListener;


//1-Data source
    private VaccineModel[] listData;

    public MyAdapter(VaccineModel[] listData) {
        this.listData = listData;
    }


    //2-VIEW HOLDER CLASS:
    //now handling the click events in recylerview


    public void setClickListener(ItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements
            View.OnClickListener{
        public ImageView imageView;
        public TextView textView;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            this.imageView=itemView.findViewById(R.id.imageRec);
            this.textView=itemView.findViewById(R.id.vaccineRec);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            if (clickListener!=null){
                clickListener.onClick(view,getAdapterPosition());
            }
        }
    }

    //3-implementing the methods

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(parent.getContext());
        View listItem =inflater.inflate(R.layout.recyle_item,parent,false);
        MyViewHolder viewHolder =new MyViewHolder(listItem);
        return viewHolder;     //onCreateViewHolder is called when u need a new view

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        final VaccineModel myListData =listData[position];
        holder.textView.setText(listData[position].getTitle());
        holder.imageView.setImageResource(listData[position].getImage());
    }

    @Override
    public int getItemCount() {
        return listData.length;
    }
}
