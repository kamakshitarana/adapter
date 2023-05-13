package com.example.world_cup_app.simpleListView.GridLayoyt;

public class CourseModel {

    //holding the same data that we need to pair to pass inside item of the grid view
    private String course_name;
    private int course_img;

    public CourseModel(String course_name, int course_img) {
        this.course_name = course_name;
        this.course_img = course_img;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public int getCourse_img() {
        return course_img;
    }

    public void setCourse_img(int course_img) {
        this.course_img = course_img;
    }
}
