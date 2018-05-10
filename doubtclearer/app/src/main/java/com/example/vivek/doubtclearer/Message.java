package com.example.vivek.doubtclearer;

/**
 * Created by Vivek on 11/2/2017.
 */

public class Message {
    private String content,username;
    public Message(){
    }
    public  Message(String content,String username){
        this.content= content;
        this.username = username;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
}
