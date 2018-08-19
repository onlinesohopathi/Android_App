package com.example.awsaf.onlinesohopathi.Model;

import com.google.gson.annotations.SerializedName;

public class Answer {

    @SerializedName("answer_id")
    private int answer_id;

    @SerializedName("question_id")
    private int question_id;

    @SerializedName("userid")
    private String userid;

    @SerializedName("username")
    private String username;

    @SerializedName("string")
    private String string;

    @SerializedName("anonymous")
    private int anonymous;

    @SerializedName("image")
    private String image;

    @SerializedName("upvote")
    private int upvote;

    @SerializedName("downvote")
    private int downvote;

    @SerializedName("isright")
    private int isright;

    @SerializedName("fbimg")
    private String fbimg;

    public int getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(int answer_id) {
        this.answer_id = answer_id;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
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

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
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

    public int getIsright() {
        return isright;
    }

    public void setIsright(int isright) {
        this.isright = isright;
    }

    public String getFbimg() {
        return fbimg;
    }

    public void setFbimg(String fbimg) {
        this.fbimg = fbimg;
    }
}
