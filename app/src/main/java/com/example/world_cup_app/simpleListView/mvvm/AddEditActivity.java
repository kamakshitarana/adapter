package com.example.world_cup_app.simpleListView.mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.world_cup_app.R;
import com.example.world_cup_app.databinding.ActivityAddEditBinding;
import com.example.world_cup_app.simpleListView.mvvm.model.Course;

public class AddEditActivity extends AppCompatActivity {


    private Course course;
    public static final String COURSE_ID="courseId";
    public static final String COURSE_NAME="courseName";
    public static final String UNIT_PRICE="unitPrice";
    private ActivityAddEditBinding activityAddEditBinding;
    private AddEditActivityClickHandlers  clickHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit);

        course =new Course();
        activityAddEditBinding = DataBindingUtil.setContentView(this,
                R.layout.activity_add_edit);
        activityAddEditBinding.setCourse(course);

        clickHandler =new AddEditActivityClickHandlers(this);
        activityAddEditBinding.setClickHandlers(clickHandler);

        Intent i =getIntent();
        if (i.hasExtra(COURSE_ID)) {
            //recyler view item clicked
            setTitle("Edit Courses");
            course.setCourseName(i.getStringExtra(COURSE_NAME));
            course.setUnitPrice(i.getStringExtra(UNIT_PRICE));
        } else{
            //fab is clicked
                setTitle("Create New Courses");
            }

    }

    public class AddEditActivityClickHandlers {
        Context context;

        public AddEditActivityClickHandlers(Context context) {
            this.context = context;
        }

        public void onSubmitButtonClick(View view) {
            if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
                Toast.makeText(context, "Course name is empty", Toast.LENGTH_SHORT).show();
            } else {
                Intent i = new Intent();
                i.putExtra(COURSE_NAME, course.getCourseName());
                i.putExtra(UNIT_PRICE, course.getUnitPrice());
                setResult(RESULT_OK, i);
                Log.v("TAG", course.getCourseName());
                finish();
            }
        }
    }

}