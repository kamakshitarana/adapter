package com.example.world_cup_app.simpleListView.CarviewGame;
//creating Custom Adapter
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.world_cup_app.R;

import java.util.ArrayList;

public class CarviewAdapter extends RecyclerView.Adapter<CarviewAdapter.ViewHolder> {
    //1 data sourse

    private Context context;
    private ArrayList<CarviewModel> gameList;
    //2- constructor


    public CarviewAdapter(Context context, ArrayList<CarviewModel> gameList) {
        this.context = context;
        this.gameList = gameList;
    }

    //3-view holder
    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView gameImg;
        private TextView  gameTitle;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            gameImg = itemView.findViewById(R.id.imgcardView);
            gameTitle =itemView.findViewById(R.id.txtCardview);

        }
    }
    //4
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item
        ,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CarviewModel model =gameList.get(position);
        holder.gameTitle.setText(model.getGameName());
        holder.gameImg.setImageResource(model.getGameImg());

        //setting the click events
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "you choose : "+gameList.get(position).getGameName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return gameList.size();
    }



}
