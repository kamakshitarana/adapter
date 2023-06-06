package com.example.world_cup_app.simpleListView.mvvm.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.world_cup_app.simpleListView.mvvm.model.Category;
import com.example.world_cup_app.simpleListView.mvvm.model.Course;
import com.example.world_cup_app.simpleListView.mvvm.model.CoursesShopRepository;

import java.util.List;
//when the activity needs to communicate with datasources ,we need to create a viewmodel.---4

public class MainActivityViewModel extends AndroidViewModel {
    //Repository
    private CoursesShopRepository repository;

    //livedata
    private LiveData<List<Category>> allCategories;
    private LiveData<List<Course>> coursesOfSelectedCategory;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);

        //initilizwed the repositry here
        repository=new CoursesShopRepository(application);
    }

    public LiveData<List<Category>> getAllCategories(){
        allCategories = repository.getCategories();
        return allCategories;
    }
    public LiveData<List<Course>> getCoursesOfSelectedCategory(int categoryId){
        coursesOfSelectedCategory = repository.getCourses(categoryId);
        return coursesOfSelectedCategory;
    }

    public void addNewCourse(Course course){
        repository.insertCourse(course);
    }

    public void updateCourse(Course course){
        repository.updateCourse(course);
    }

    public void deleteCourse(Course course){
        repository.deleteCourse(course);
    }

}
