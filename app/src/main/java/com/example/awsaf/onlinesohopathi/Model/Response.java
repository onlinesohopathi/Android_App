package com.example.awsaf.onlinesohopathi.Model;


import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Response {

    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String title;

    @SerializedName("userid")
    private String userid;

    @SerializedName("username")
    private String username;

    @SerializedName("question")
    private String question;

    @SerializedName("category")
    private String category;

    @SerializedName("anonymous")
    private int anonymous;

    @SerializedName("image")
    private String image;

    @SerializedName("upvote")
    private int upvote;

    @SerializedName("downvote")
    private int downvote;

    @SerializedName("tags")
    private String tags;

    @SerializedName("fbpics")
    private String fbpics;

    @SerializedName("answers")
    private List<Answer> answers;

//    public Response(String title, String username, int anonymous) {
//        this.title = title;
//        this.username = username;
//        this.anonymous = anonymous;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getAnonymous() {
        return anonymous;
    }

    public void setAnonymous(int anonymous) {
        this.anonymous = anonymous;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getUpvote() {
        return upvote;
    }

    public void setUpvote(int upvote) {
        this.upvote = upvote;
    }

    public int getDownvote() {
        return downvote;
    }

    public void setDownvote(int downvote) {
        this.downvote = downvote;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getFbpics() {
        return fbpics;
    }

    public void setFbpics(String fbpics) {
        this.fbpics = fbpics;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }




}