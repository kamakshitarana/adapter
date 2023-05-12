package com.example.world_cup_app.simpleListView.NavigationDrawer;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import android.os.Bundle;
import android.view.MenuItem;
import com.example.world_cup_app.R;
import com.google.android.material.navigation.NavigationView;
public class NvigationActivity extends AppCompatActivity {

    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    private NavigationView nvDrawer;
    private ActionBarDrawerToggle  drawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nvigation);
        //toolbar
        toolbar =findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Drawer view
        mDrawer=findViewById(R.id.myDrawerlayout);
        //drawer navigation
        nvDrawer =findViewById(R.id.nview);
        setupDrawerContect(nvDrawer);
    }

    private void setupDrawerContect(NavigationView nvDrawer) {
        nvDrawer.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectDrawerItem(item);
                return true;
            }
        });
    }

    private void selectDrawerItem(MenuItem item) {
        Fragment fragment = null;
        Class fragmentClass;

        if (item.getItemId() == R.id.nav_first_fragment) {
            fragmentClass = FirstFragment.class;
        } else if (item.getItemId() == R.id.nav_second_fragment) {
            fragmentClass = SecondFragment.class;
        } else if (item.getItemId() == R.id.nav_third_fragment) {
            fragmentClass = ThirdFragment.class;
        } else {
            fragmentClass = FirstFragment.class;
        }



//        switch (item.getItemId())
//        {
//            case R.id.nav_first_fragment:
//                fragmentClass = FirstFragment.class;
//            break;
//
//            case R.id.nav_second_fragment:
//                fragmentClass = SecondFragment.class;
//                break;
//
//            case R.id.nav_third_fragment:
//                fragmentClass= ThirdFragment.class;
//                break;
//
//            default:
//                fragmentClass= FirstFragment.class;
//        }


        try {
            fragment=(Fragment)fragmentClass.newInstance();
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }catch (InstantiationException e){
            e.printStackTrace();
        }
        FragmentManager fragmentManager =getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent,fragment).commit();

        item.setChecked(true);
        setTitle(item.getTitle());
        mDrawer.closeDrawers();

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                mDrawer.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}