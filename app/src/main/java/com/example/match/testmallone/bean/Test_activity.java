package com.example.match.testmallone.bean;

/**
 * Created by match on 2018/12/13.
 */

public class Test_activity extends BaseBean {

    private String mallName;
    private Double gread;
    private int image;
    private String text;
    private int time;
    private String category;

    public Test_activity(String mallName, Double gread, int image, String text, int time,String category) {

        this.mallName = mallName;
        this.gread = gread;
        this.image = image;
        this.text = text;
        this.time = time;
        this.category=category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMallName() {
        return mallName;
    }

    public void setMallName(String mallName) {
        this.mallName = mallName;
    }

    public Double getGread() {
        return gread;
    }

    public void setGread(Double gread) {
        this.gread = gread;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
