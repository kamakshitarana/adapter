package com.example.world_cup_app.simpleListView.mvvm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.world_cup_app.R;
import com.example.world_cup_app.databinding.CourseListItemBinding;
import com.example.world_cup_app.simpleListView.mvvm.model.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {
    private OnItemClickListener listener;
    private ArrayList<Course> courses = new ArrayList<>();

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CourseListItemBinding courseListItemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.course_list_item,
                parent,
                false);
        return new CourseViewHolder(courseListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        Course course = courses.get(position);
        holder.courseListItemBinding.setCourse(course);
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }


    class CourseViewHolder extends RecyclerView.ViewHolder {
        private CourseListItemBinding courseListItemBinding;

        public CourseViewHolder(@NonNull CourseListItemBinding courseListItemBinding) {
            super(courseListItemBinding.getRoot());
            this.courseListItemBinding = courseListItemBinding;

            courseListItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int clickedPosition = getAdapterPosition();
                    if (listener != null && clickedPosition != RecyclerView.NO_POSITION) {
                        listener.onItemClick(courses.get(clickedPosition));
                    }
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Course course);
    }

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public void setCourses(ArrayList<Course> newCourses) {

         final DiffUtil.DiffResult result = DiffUtil.calculateDiff
                 (new CourseDiffCallback(courses, newCourses),false);
         courses =newCourses;
         result.dispatchUpdatesTo(CourseAdapter.this);

//        ArrayList<Course> oldCourses = new ArrayList<>(courses);
//        courses.clear();
//        courses.addAll(newCourses);
//        diffResult.dispatchUpdatesTo(this);
    }
}
