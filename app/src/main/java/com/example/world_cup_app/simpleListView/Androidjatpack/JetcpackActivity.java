package com.example.world_cup_app.simpleListView.Androidjatpack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.world_cup_app.R;

public class JetcpackActivity extends AppCompatActivity {

    AndroidJetpackViewModel androidJetpackViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jetcpack);

        /**jetpack is a group of libraies to help devlopers follow best practies,
         * reduce boilerplate code and write code that works consistently across
         * android versions and devices so that developers can focus on the code they
         * care about.
         *
         * jetpack encompasses a collection of android libraries that incorporate best pratices
         * and provide backward.
         *
         *  Android jatpack is composed of four main sections
         *  UI------------>Animation and transitions ,layout,palette,emoji,fragment
         *  BEHAVIOUR----->Download manager ,media and playbacks,permissions,notifications,sharing,slices.
         *  FOUNDATION------>app compat,android KTX,multidex,test.
         *  ARCHITECTURE---->compile and have the data binding ,lifecycycles,livedata,navigation,pagging,room,view model,work manager.
         *
         *
         *
         * ARCHITECTURE COMPONENTS:
         * App ARCHITECTURE design is an importtant consideration for ensuring that your apps is robust ,testable.
         * and maintable.
         *
         * Sepration of concerns
         * Loose coupling
         * Observer pattern
         * Inversion of control
         *
         * **/
        /**ROOMDATABASE-->
         *
         * The room persistence library provides an abstraction layer over SQLite to
         * allow fluent databases access while harnessing the full power of sqlite in particuler
         * ,room provides the following benifites.
         *
         * **/
        /**WORKMANAGER
         * Workmanager api provides an optimal solution to manage the backgroud tasks
         * in ANDROID WHICH ARE deferrable (can run later and is still usefull )aswell as
         * guaranteed(runs even if the device restarts ) in nature.
         *
         * **/
        /**LiVEData
         * live data as a part of the architecture pattern, it's basically a data holder that
         * contain primitive.
         *
         *
         * (its basically a data holder)
         *
         * like we knows that view models are used to communicate the data details to that
         * view using view model alone.
         * */

        Button btn =findViewById(R.id.button11);
        TextView textView =findViewById(R.id.textview11);

        androidJetpackViewModel = new ViewModelProvider(this).get(AndroidJetpackViewModel.class);

        //this is how we get the from the every viewmodel(getting the initial count)
        textView.setText("You clicked me: "+androidJetpackViewModel.getInitialCounter()+ " times");


        //Here the benifits of the viewmodel class we have preserved the memory.
        //when i was intilizing the value without viewmodel class and if i will rotate the phone data will lost
        //but now with the help of viewModel i can preserved the data.



        //Using Live Data to get the Counter
        LiveData<Integer> count = androidJetpackViewModel.getInitialCounter();
        count.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                textView.setText("YOU CLICKED ME : " +integer + " times");
            }
        });



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //getting the current count
                androidJetpackViewModel.getCounter();
            }
        });


    }
}