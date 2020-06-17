package com.rohini.homepage.bean;

import com.google.gson.annotations.SerializedName;

public class Bookbean {

    @SerializedName("post_url")
    String post_url;
    @SerializedName("id")
    String id;

    @SerializedName("imageurl")
    String imageurl;

    @SerializedName("author_url")
    String author_url;

    @SerializedName("author")
    String author;

    @SerializedName("filename")
    String filename;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getImageurl() {
        return imageurl;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor_url() {
        return author_url;
    }

    public void setAuthor_url(String author_url) {
        this.author_url = author_url;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getPost_url() {
        return post_url;
    }

    public void setPost_url(String post_url) {
        this.post_url = post_url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
