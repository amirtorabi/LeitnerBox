package com.example.leitnerbox.database;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class Day {

    @Id
    private long id;
    private Integer year;
    private Integer day;
    private Integer adds;
    private Integer reviews;
    private Integer corrects;

    public Day() {
    }

    public Day(Integer year, Integer day, Integer adds, Integer reviews, Integer corrects) {
        this.year = year;
        this.day = day;
        this.adds = adds;
        this.reviews = reviews;
        this.corrects = corrects;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getAdds() {
        return adds;
    }

    public void setAdds(Integer adds) {
        this.adds = adds;
    }

    public Integer getReviews() {
        return reviews;
    }

    public void setReviews(Integer reviews) {
        this.reviews = reviews;
    }

    public Integer getCorrects() {
        return corrects;
    }

    public void setCorrects(Integer corrects) {
        this.corrects = corrects;
    }
}
