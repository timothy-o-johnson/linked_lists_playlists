package com.robinsondetroit;

import java.util.ArrayList;
import java.util.List;

public class Album {
    private Songlist album = new Songlist();
    private String albumName;
    private String artist;
    private int totalTracks;
    private double albumLength;

    public Album(String name, String artist) {
        this.album = new Songlist();
        this.albumName = name;
        this.artist = artist;
        this.totalTracks = 0;
        this.albumLength = 0.0;
    }


    public boolean addTracks(String songName, double songLength) {
        if (this.album.addSong(new Song(songName, songLength))) {

            this.totalTracks += 1;
            updateAlbumLength();

            return true;
        }
        return false;
    }


    private class Songlist{
        private List<Song> songList = new ArrayList<Song>();

        private boolean addSong(Song newSong) {
            if (!findSong(newSong)) {
                this.songList.add(newSong);
               // System.out.println(newSong.getSongName() + " added to playlist.");
                return true;
            } else {
                System.out.println("Sorry, " +newSong.getSongName() + " is already on the album.");
                return false;
            }
        }

        private boolean findSong(Song song){
            for(Song song1: this.songList){
                if(song.getSongName() == song1.getSongName()){
                    return true;
                }
            }
            return false;
        }

        public ArrayList<Song> getSongList() {
            return songList;
        }

        public void setSongList(ArrayList<Song> songList) {
            this.songList = songList;
        }
    }

    public void printTrackListings(){
       // System.out.println("\ncom.robinsondetroit.Album: " + this.albumName);

        System.out.println("Tracks: " + this.getTotalTracks() + "\n");
        for(int i = 0; i < this.album.getSongList().size(); i++){
            System.out.println((i + 1) + ". " + this.album.getSongList().get(i).getSongName() +" (" + this.album.getSongList().get(i).getSongLength() + ")");

        }
    }

    private void updateAlbumLength(){
        this.albumLength = 0;

        for(int i = 0; i < this.album.getSongList().size(); i++){
            this.albumLength += this.album.getSongList().get(i).getSongLength();
        }
    }

    public Song isSongOnAlbum(String song){
        for(int i = 0; i < this.album.songList.size(); i++) {
            if (song == this.album.songList.get(i).getSongName()) {
                return this.album.songList.get(i);
            }
        }

        return null;
    }

    public Songlist getAlbum() {
        return album;
    }

    public void setAlbum(Songlist album) {
        this.album = album;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getTotalTracks() {
        return totalTracks;
    }

    public void setTotalTracks(int totalTracks) {
        this.totalTracks = totalTracks;
    }

    public double getAlbumLength() {
        return albumLength;
    }

    public void setAlbumLength(double albumLength) {
        this.albumLength = albumLength;
    }
}


