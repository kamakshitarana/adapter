package com.example.world_cup_app.simpleListView.mvvm;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.world_cup_app.R;
import com.example.world_cup_app.databinding.ActivityModelViewwBinding;
import com.example.world_cup_app.simpleListView.mvvm.model.Category;
import com.example.world_cup_app.simpleListView.mvvm.model.Course;
import com.example.world_cup_app.simpleListView.mvvm.viewModel.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class ModelViewwActivity extends AppCompatActivity {
    private MainActivityViewModel mainActivityViewModel;
    private ArrayList<Category> categorysList;
    private ActivityModelViewwBinding activityModelViewwBinding;
    private ModelViewwActivityClickHandler handler;
    private Category selectedCategory;

    // RecyclerView
    private RecyclerView courseRecyclerView;
    private CourseAdapter courseAdapter;
    private ArrayList<Course> coursesList;
    private static final int ADD_COURSE_REQUEST_CODE = 1;
    private static final int EDIT_COURSE_REQUEST_CODE = 2;
    public int selectedCourseId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model_vieww);

        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        activityModelViewwBinding = DataBindingUtil.setContentView(this, R.layout.activity_model_vieww);
        handler = new ModelViewwActivityClickHandler();
        activityModelViewwBinding.setClickHandler(handler);

        mainActivityViewModel.getAllCategories().observe(this, new Observer<List<Category>>() {
            @Override
            public void onChanged(List<Category> categories) {
                categorysList = new ArrayList<>(categories);
                showOnSpinner();
            }
        });

        mainActivityViewModel.getCoursesOfSelectedCategory(1).observe(this, new Observer<List<Course>>() {
            @Override
            public void onChanged(List<Course> courses) {
                coursesList = new ArrayList<>(courses);
                LoadRecyclerView();
            }
        });
    }

    private void showOnSpinner() {
        ArrayAdapter<Category> categoryArrayAdapter = new ArrayAdapter<>(
                this,
                R.layout.spinner_item,
                categorysList
        );
        categoryArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        activityModelViewwBinding.setSpinnerAdapter(categoryArrayAdapter);
    }

    public void LoadCoursesArrayList(int categoryId) {
        mainActivityViewModel.getCoursesOfSelectedCategory(categoryId).observe(this, new Observer<List<Course>>() {
            @Override
            public void onChanged(List<Course> courses) {
                coursesList = new ArrayList<>(courses);
                LoadRecyclerView();
            }
        });
    }

    private void LoadRecyclerView() {
        courseRecyclerView = activityModelViewwBinding.secondaryLayout.recyleViiew;
        courseRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        courseRecyclerView.setHasFixedSize(true);

        // Attach the adapter to the RecyclerView
        courseAdapter = new CourseAdapter();
        courseRecyclerView.setAdapter(courseAdapter);
        courseAdapter.setCourses(coursesList);

        // Edit the course
        courseAdapter.setListener(new CourseAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Course course) {
                selectedCourseId = course.getCourseId();
                Intent i = new Intent(ModelViewwActivity.this, AddEditActivity.class);
                i.putExtra(AddEditActivity.COURSE_ID, selectedCourseId);
                i.putExtra(AddEditActivity.COURSE_NAME, course.getCourseName());
                i.putExtra(AddEditActivity.UNIT_PRICE, course.getUnitPrice());
                startActivityForResult(i, EDIT_COURSE_REQUEST_CODE);
            }
        });

        // Delete a course
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                Course courseToDelete = coursesList.get(viewHolder.getAdapterPosition());
                mainActivityViewModel.deleteCourse(courseToDelete);
            }
        }).attachToRecyclerView(courseRecyclerView);
        courseAdapter.notifyDataSetChanged();
    }

    public class ModelViewwActivityClickHandler {
        public void onFabClicked(View view) {
            // Create the course
            Intent i = new Intent(ModelViewwActivity.this, AddEditActivity.class);
            startActivityForResult(i, ADD_COURSE_REQUEST_CODE);
        }

        public void onSelectItem(AdapterView<?> parent, View view, int pos, long id) {
            selectedCategory = (Category) parent.getItemAtPosition(pos);
            String message = "id is: " + selectedCategory.getId() +
                    " \n name is " + selectedCategory.getCategoryName();
            Toast.makeText(parent.getContext(), " " + message, Toast.LENGTH_SHORT).show();
            LoadCoursesArrayList(selectedCategory.getId());
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        int selectedCategoryId = selectedCategory.getId();

        if (requestCode == ADD_COURSE_REQUEST_CODE && resultCode == RESULT_OK) {
            Course course = new Course();
            course.setCategoryId(selectedCategoryId);
            course.setCourseName(data.getStringExtra(AddEditActivity.COURSE_NAME));
            course.setUnitPrice(data.getStringExtra(AddEditActivity.UNIT_PRICE));
            mainActivityViewModel.addNewCourse(course);
            Log.v("TAG", "Inserted" + course.getUnitPrice());
        } else if (requestCode == EDIT_COURSE_REQUEST_CODE && resultCode == RESULT_OK) {
            Course course = new Course();
            course.setCategoryId(selectedCategoryId);
            course.setCourseName(data.getStringExtra(AddEditActivity.COURSE_NAME));
            course.setUnitPrice(data.getStringExtra(AddEditActivity.UNIT_PRICE));
            course.setCourseId(selectedCourseId);
            mainActivityViewModel.updateCourse(course);
        }
    }
}
