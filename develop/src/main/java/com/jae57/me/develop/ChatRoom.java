package com.jae57.me.develop;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ChatRoom {
    private String title;
    private String hostName;
    private String remains;
    private String deadline;
    private String content;
    private String location;

    public ChatRoom(){

    }

    public ChatRoom(String title, String hostName, String remains, String deadline, String content, String location){
        this.title = title;
        this.hostName = hostName;
        this.remains = remains;
        this.deadline = deadline;
        this.content = content;
        this.location = location;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getHostName(){
        return hostName;
    }

    public void setHostName(String hostName){
        this.hostName = hostName;
    }

    public String getRemains(){
        return remains;
    }

    public void setRemains(String remains){
        this.remains = remains;
    }

    public String getContent(){
        return content;
    }

    public void setContent(String content){
        this.content = content;
    }

    public String getDeadline(){
        return deadline;
    }

    public void setDeadline(String deadline){
        this.deadline = deadline;
    }

    public String getLocation(){
        return location;
    }

    public void setLocation(String location){
        this.location = location;
    }
}