package com.example.world_cup_app.simpleListView.jetpackbind.twoWayBind;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.world_cup_app.BR;

public class Persoon extends BaseObservable {
    private String name;

    public Persoon(String name) {
        this.name = name;
    }

    @Bindable
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }
}
