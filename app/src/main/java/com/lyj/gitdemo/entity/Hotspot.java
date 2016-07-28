package com.lyj.gitdemo.entity;

/**
 * Created by 1 on 2016/7/28.
 */
public class Hotspot {
    private String icon;
    private String title;
    private String matter;
    private String stars;
    private String url;

    public Hotspot(String icon, String title, String matter, String stars, String url) {
        this.icon = icon;
        this.title = title;
        this.matter = matter;
        this.stars = stars;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMatter() {
        return matter;
    }

    public void setMatter(String matter) {
        this.matter = matter;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }
}
