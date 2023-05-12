package com.example.world_cup_app.simpleListView.viewPager;


import com.example.world_cup_app.R;

public enum ModelCourse {
     RED(R.string.red, R.layout.view_red),
     BLUE(R.string.blue, R.layout.view_blue),
     GREEN(R.string.green,R.layout.view_green);

     private int mTitleId;
     private int mLayoutId;

     ModelCourse(int mTitleId, int mLayoutId) {
          this.mTitleId = mTitleId;
          this.mLayoutId = mLayoutId;
     }

     public int getmTitleId() {
          return mTitleId;
     }

     public void setmTitleId(int mTitleId) {
          this.mTitleId = mTitleId;
     }

     public int getmLayoutId() {
          return mLayoutId;
     }

     public void setmLayoutId(int mLayoutId) {
          this.mLayoutId = mLayoutId;
     }
}
