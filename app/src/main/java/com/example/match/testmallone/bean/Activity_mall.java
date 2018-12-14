package com.example.match.testmallone.bean;

import java.io.Serializable;

/**
 * Created by <a href="http://www.cniao5.com">菜鸟窝</a>
 * 一个专业的Android开发在线教育平台
 */
public class Activity_mall implements Serializable {


    private String id;
    private String name;
    private String imgUrl;
    private String timedata;
    private String description;
    private Double gread;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTimedata() {
        return timedata;
    }

    public void setTimedata(String timedata) {
        this.timedata = timedata;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getGread() {
        return gread;
    }

    public void setGread(Double gread) {
        this.gread = gread;
    }
}
