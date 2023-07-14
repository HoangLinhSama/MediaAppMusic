package com.hoanglinhsama.mediaappmusic;

public class Song { // class Song de chua cac thong tin can thiet
    private String song;
    private String singer;
    private int fileMp3;
    private int picture;

    public Song(String song, String singer, int fileMp3, int picture) {
        this.song = song;
        this.singer = singer;
        this.fileMp3 = fileMp3;
        this.picture = picture;
    }

    public String getSong() {
        return this.song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public String getSinger() {
        return this.singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public int getFileMp3() {
        return this.fileMp3;
    }

    public void setFileMp3(int fileMp3) {
        this.fileMp3 = fileMp3;
    }

    public int getPicture() {
        return this.picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }
}
