package com.example.leitnerbox.database;

import io.objectbox.annotation.Id;
import io.objectbox.annotation.Entity;

@Entity
public class Card {

    @Id
    private long id;
    private Integer deck;
    private Integer part;
    private String front;
    private String back;
    private Integer year;
    private Integer day;
    private Integer review;
    private Integer correct;
    private Integer package_id;
    private Boolean starred;
    private String image_front;
    private String image_back;
    private String audio_front;
    private String audio_back;
    private Integer quiz_question;
    private Integer quiz_correct;

    public Card() {

    }

    public Card(Integer deck, Integer part, String front, String back, Integer year, Integer day, Integer review, Integer correct, Integer package_id, Boolean starred, String image_front, String image_back, String audio_front, String audio_back, Integer quiz_question, Integer quiz_correct) {

        this.deck = deck;
        this.part = part;
        this.front = front;
        this.back = back;
        this.year = year;
        this.day = day;
        this.review = review;
        this.correct = correct;
        this.package_id = package_id;
        this.starred = starred;
        this.image_front = image_front;
        this.image_back = image_back;
        this.audio_front = audio_front;
        this.audio_back = audio_back;
        this.quiz_question = quiz_question;
        this.quiz_correct = quiz_correct;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getDeck() {
        return deck;
    }

    public void setDeck(Integer deck) {
        this.deck = deck;
    }

    public Integer getPart() {
        return part;
    }

    public void setPart(Integer part) {
        this.part = part;
    }

    public String getFront() {
        return front;
    }

    public void setFront(String front) {
        this.front = front;
    }

    public String getBack() {
        return back;
    }

    public void setBack(String back) {
        this.back = back;
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

    public Integer getReview() {
        return review;
    }

    public void setReview(Integer review) {
        this.review = review;
    }

    public Integer getCorrect() {
        return correct;
    }

    public void setCorrect(Integer correct) {
        this.correct = correct;
    }

    public Integer getPackage_id() {
        return package_id;
    }

    public void setPackage_id(Integer package_id) {
        this.package_id = package_id;
    }

    public Boolean getStarred() {
        return starred;
    }

    public void setStarred(Boolean starred) {
        this.starred = starred;
    }

    public String getImage_front() {
        return image_front;
    }

    public void setImage_front(String image_front) {
        this.image_front = image_front;
    }

    public String getImage_back() {
        return image_back;
    }

    public void setImage_back(String image_back) {
        this.image_back = image_back;
    }

    public String getAudio_front() {
        return audio_front;
    }

    public void setAudio_front(String audio_front) {
        this.audio_front = audio_front;
    }

    public String getAudio_back() {
        return audio_back;
    }

    public void setAudio_back(String audio_back) {
        this.audio_back = audio_back;
    }

    public Integer getQuiz_question() {
        return quiz_question;
    }

    public void setQuiz_question(Integer quiz_question) {
        this.quiz_question = quiz_question;
    }

    public Integer getQuiz_correct() {
        return quiz_correct;
    }

    public void setQuiz_correct(Integer quiz_correct) {
        this.quiz_correct = quiz_correct;
    }
}



