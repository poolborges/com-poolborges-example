package com.poolborges.example.resources.model;

/**
 * Created by borges on 1/9/14.
 */
public class Music {

    String title;
    String singer;
    int duration;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Music [title=" + title + ", duration=" + duration + ", singer=" + singer + "]";
    }
}
