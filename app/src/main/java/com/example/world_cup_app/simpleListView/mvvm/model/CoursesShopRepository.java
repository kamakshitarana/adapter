package com.example.world_cup_app.simpleListView.mvvm.model;

import android.app.Application;
import android.os.Looper;

import androidx.lifecycle.LiveData;
import java.util.List;
import android.os.Handler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//this repositery combines the right the bussiness logic combining data ----3
public class CoursesShopRepository {
    private CategoryDao categoryDao;
    private CourseDao courseDao;

    private LiveData<List<Category>> categories;
    private LiveData<List<Course>> courses;

    public CoursesShopRepository(Application application) {
        CourseDataBase courseDataBase = CourseDataBase.getInstance(application);
        categoryDao = courseDataBase.categoryDao();
        courseDao = courseDataBase.courseDao();

    }

    public LiveData<List<Category>> getCategories() {
        return categoryDao.getAllCategories();
    }

    public LiveData<List<Course>> getCourses(int categoryId) {
        return courseDao.getCourses(categoryId);
    }

    private void insertCategory(Category category) {
        //inserting categories
        categoryDao.insert(category);
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executor.execute(new Runnable() {
            @Override
            public void run() {
                //inserting categories
                categoryDao.insert(category);
            }
        });

    }

    public void insertCourse(Course course) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executor.execute(new Runnable() {
            @Override
            public void run() {
                //inserting categories
                courseDao.insert(course);
                //do after background execution is done--post execution

            }
        });

    }

    public void deleteCategory(Category category) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executor.execute(new Runnable() {
            @Override
            public void run() {
                //inserting categories
                categoryDao.delete(category);
                //do after background execution is done--post execution

            }
        });
    }

    public void deleteCourse(Course course) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executor.execute(new Runnable() {
            @Override
            public void run() {
                //inserting categories
                courseDao.delete(course);
                //do after background execution is done--post execution

            }
        });
    }

    public void updateCategory(Category category) {
            ExecutorService executor = Executors.newSingleThreadExecutor();
            Handler handler = new Handler(Looper.getMainLooper());
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    //inserting categories
                    categoryDao.update(category);
                    //do after background execution is done--post execution

                }
            });
    }

    public void updateCourse(Course course) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executor.execute(new Runnable() {
            @Override
            public void run() {
                //inserting categories
                courseDao.update(course);
                //do after background execution is done--post execution

            }
        });
    }

}
