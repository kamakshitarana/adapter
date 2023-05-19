package com.example.world_cup_app.simpleListView.Androidjatpack;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AndroidJetpackViewModel extends ViewModel  {
    private int counter =0;

    //now here we will create a live Data
    private MutableLiveData<Integer> countLiveData =new MutableLiveData<>();
    //mutableliveData is just a class that extends the life data type class



    //when the app first launched
    public MutableLiveData<Integer> getInitialCounter(){
        countLiveData.setValue(counter);
        return countLiveData;
    }


    //when user clicks the button
     public void getCounter(){
     counter++;
     countLiveData.setValue(counter);
 }

}
