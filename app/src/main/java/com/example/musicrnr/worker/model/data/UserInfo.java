package com.example.musicrnr.worker.model.data;

public class UserInfo {
    String userName,passWord;
    int userId,lastKey,userLever;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getLastKey() {
        return lastKey;
    }

    public void setLastKey(int lastKey) {
        this.lastKey = lastKey;
    }

    public int getUserLever() {
        return userLever;
    }

    public void setUserLever(int userLever) {
        this.userLever = userLever;
    }
}
