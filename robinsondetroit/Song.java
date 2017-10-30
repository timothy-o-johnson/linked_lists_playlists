package com.robinsondetroit;

public class Song {
    private String songName;
    private double songLength;

    public Song(String songName, double songLength) {
        this.songName = songName;
        this.songLength = songLength;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public double getSongLength() {
        return songLength;
    }

    public void setSongLength(double songLength) {
        this.songLength = songLength;
    }
}
