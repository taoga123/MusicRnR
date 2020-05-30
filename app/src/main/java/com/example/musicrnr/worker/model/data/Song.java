package com.example.musicrnr.worker.model.data;

import android.net.Uri;

public class Song {

    private String Title,url;
    private int File;
    private Uri uri;

    public Song(String title, Uri uri) {
        Title = title;
        this.uri = uri;
    }

    public Uri getUri() {
        return uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }

    public Song(String title, int file) {
        Title = title;
        File = file;
    }

    public Song(String title, String url) {
        Title = title;
        this.url = url;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getFile() {
        return File;
    }

    public void setFile(int file) {
        File = file;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
