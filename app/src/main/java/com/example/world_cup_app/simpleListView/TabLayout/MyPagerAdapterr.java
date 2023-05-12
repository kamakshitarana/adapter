package com.example.world_cup_app.simpleListView.TabLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyPagerAdapterr extends FragmentPagerAdapter {

    private int numOfTabs;

//    public MyPagerAdapterr(@NonNull FragmentManager fm, int numOfTabs) {
//        super(fm);
//        this.numOfTabs = numOfTabs;
//    }

    public MyPagerAdapterr(@NonNull FragmentManager fragmentManager, int numOfTabs){
        super(fragmentManager);
        this.numOfTabs = numOfTabs;
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return new ChatFragement();
            case 1:
                return new StatusFragment();
            case 2:
                return new CallsFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }


    @Override
    public CharSequence getPageTitle(int position)
    {
        String title = null;
        if (position == 0)
            title = "Chats";
        else if (position == 1)
            title = "Status";
        else if (position == 2)
            title = "Calls";
        return title;
    }

}
