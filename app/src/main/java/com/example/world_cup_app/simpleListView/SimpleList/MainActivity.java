//package com.example.world_cup_app.simpleListView.SimpleList;
//
//import android.os.Bundle;
//import android.widget.ArrayAdapter;
//import android.widget.ListView;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.example.world_cup_app.R;
//
//public class MainActivity extends AppCompatActivity {
//    ListView listView;   //step 1 adapterview
//    String[] worldCup23 ={ "Germany","spain","india","puneTeam","USA","Qatar"};    //step 2  data sources
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        listView =findViewById(R.id.listView);   //listview is created
//
//        //step 3 create adapter now.(simple item adapter)
//        ArrayAdapter adapter= new ArrayAdapter(
//              this,
////                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,   //used default
//                R.layout.my_list,
//                R.id.list_item,
//                  //here using the mine one
//                worldCup23
//        );
//
//        listView.setAdapter(adapter);
//    }
//}