//package com.example.world_cup_app.simpleListView.JetpackBinding;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.databinding.DataBindingUtil;
//
//import android.os.Bundle;
//import android.widget.TextView;
//
//import com.example.world_cup_app.R;
//import com.example.world_cup_app.databinding.ActivityDataBindingBinding;
//
//public class DataBindingActivity extends AppCompatActivity {
//    private ActivityDataBindingBinding activityDataBindingBinding;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_data_binding);
//        /*** DATABinding
//         * Data binding library is a support library that allows you UI components in your layout to data source in the app
//         * using declarative format
//         *
//         * SYNTAX OF DATA BINDING
//         * <Textview
//         * android:text="@{viewmodel.userName}"/>
//         *
//         * Not to use FindViewById()
//         * not to create many adapters
//         * to handle call backs easily
//         * Data Binding for forms
//         * Set Fonts directly to XML
//         *
//         *
//         * //making the code simpler easier to maintain,
//         * its improve the app's performance and help prevent memory leaks and null pointer exceptions.
//         *
//         * */
//
//
//        Person person1=new Person("Kamakshi","lavitaranatarana@gmail.com");
//        activityDataBindingBinding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding);
//        activityDataBindingBinding.setPerson(person1);
//
//    }
//}