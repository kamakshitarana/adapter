package com.example.world_cup_app.simpleListView.mvvm;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;

import com.example.world_cup_app.simpleListView.mvvm.model.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseDiffCallback extends DiffUtil.Callback {

    private ArrayList<Course> oldCourseList;
    private ArrayList<Course> newCourseList;

    public CourseDiffCallback(ArrayList<Course> oldCourseList, ArrayList<Course> newCourseList) {
        this.oldCourseList = oldCourseList;
        this.newCourseList = newCourseList;
    }

    @Override
    public int getOldListSize() {
        return oldCourseList == null ? 0 : oldCourseList.size();
    }

    @Override
    public int getNewListSize() {
        return newCourseList == null ? 0 : newCourseList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldCourseList.get(oldItemPosition).getCourseId() ==
                newCourseList.get(newItemPosition).getCourseId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        Course oldCourse = oldCourseList.get(oldItemPosition);
        Course newCourse = newCourseList.get(newItemPosition);
        return oldCourse.getCourseName().equals(newCourse.getCourseName()) &&
                oldCourse.getUnitPrice().equals(newCourse.getUnitPrice());
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        return super.getChangePayload(oldItemPosition, newItemPosition);
    }
}
