package com.example.world_cup_app.simpleListView.mvvm.model;

//Room db ----3(creating singleton )

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Database(entities = {Category.class,Course.class}, version = 1)
public abstract class CourseDataBase extends RoomDatabase {

    public abstract CategoryDao categoryDao();
    public abstract CourseDao courseDao();

    //singleton pattern
    private static CourseDataBase instance;
    //synchronized in order to prevent any creation of the objects.
    public static synchronized CourseDataBase getInstance(Context context){
        if (instance==null){
            instance= Room.databaseBuilder(context.getApplicationContext(),
                    CourseDataBase.class,"courses_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    //creating callback
    private static RoomDatabase.Callback roomCallback=new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            //insert data when database is created
            initializeData();

        }
    };

    private static void initializeData() {
        //this will insert readymate data
        CourseDao courseDao = instance.courseDao();
        CategoryDao categoryDao = instance.categoryDao();

        //here i will insert the data in background and and threads so i will used executors
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                //categories data
                Category category1 =new Category();
                category1.setCategoryName("Front End");
                category1.setCategoryDescription("Web Development Interface");

                Category category2 =new Category();
                category2.setCategoryName("Back End");
                category2.setCategoryDescription("Backend Development ");

               categoryDao.insert(category1); //so here i used that abstration here,how i can use the interface of the data access
               categoryDao.insert(category2);

               //Courses data
                Course course1=new Course();
                course1.setCourseName("HTML");
                course1.setUnitPrice("100$");
                course1.setCategoryId(1);

                Course course2=new Course();
                course2.setCourseName("JAVA");
                course2.setUnitPrice("200$");
                course2.setCategoryId(1);

                Course course3=new Course();
                course3.setCourseName("Android");
                course3.setUnitPrice("300$");
                course3.setCategoryId(2);

                Course course4=new Course();
                course4.setCourseName("PYTHON");
                course4.setUnitPrice("400$");
                course4.setCategoryId(2);

                courseDao.insert(course1);
                courseDao.insert(course2);
                courseDao.insert(course3);
                courseDao.insert(course4);

            }
        });

    }
}
