package com.robinsondetroit;

import java.util.ArrayList;

public class AlbumCollection {
    ArrayList<Album> myCollection;
    String name;

    public AlbumCollection(String name) {
        this.myCollection = new ArrayList<Album>();
        this.name = name;
    }

    public void addAlbumToCollection(Album newAlbum){
        System.out.println("Adding " + newAlbum.getAlbumName() + "...\n" );
        myCollection.add(newAlbum);

    }

    public ArrayList<Album> getMyCollection() {
        return myCollection;
    }

    public void setMyCollection(ArrayList<Album> myCollection) {
        this.myCollection = myCollection;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
