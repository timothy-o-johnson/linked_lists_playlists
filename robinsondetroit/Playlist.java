package com.robinsondetroit;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Playlist {
    AlbumCollection albumCollection;
    LinkedList<Song> playlist;
    String playlistName;
    String currentState = "standing by";

    public Playlist(String playlistName, AlbumCollection albumCollection) {
        this.playlistName = playlistName;
        this.playlist = new LinkedList<Song>();
        this.albumCollection = albumCollection;
    }

    private Song songExists(String songName) {
        System.out.println("songExists method\n");
        for (int i = 0; i < this.albumCollection.myCollection.size(); i++) {
            System.out.println("Iteration #:" + i);
            if (this.albumCollection.myCollection.get(i).isSongOnAlbum(songName) != null) {
                System.out.println("song found!");
                return this.albumCollection.myCollection.get(i).isSongOnAlbum(songName);
            }
        }
        return null;
    }

    public void addSong(String songName) {
        Song tempSong = songExists(songName);

        //if song is in our collection, add to playlist
        if (tempSong != null) {
            this.playlist.addLast(tempSong);

        } else {
            System.out.println("Womp, womp. Song not found.");
        }
    }

    public void printPlaylist(){
//        System.out.println("\n---------------------------------");
        System.out.println("\n\n" + this.playlistName + " Playlist");
        System.out.println("---------------------------------");
        for(int i = 0; i < this.playlist.size(); i++){
            System.out.println((i+1) + ". " + this.playlist.get(i).getSongName());
        }
    }

    public void printMenuOptions(){
      //  System.out.println("\nCurrently "+ this.currentState + ".");
      //  System.out.println("What would you like to do?");
        System.out.println("\n---------------------------------");
        System.out.println("Options");
        System.out.println("---------------------------------");
        System.out.println("0. View Playlist.");
        System.out.println("1. Skip to next song.");
        System.out.println("2. Skip backwards to previous song.");
        System.out.println("3. Remove current song.");
        System.out.println("4. Current song playing.");
        System.out.println("5. Quit.");
    }

    public void playlistControls(){
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        ListIterator<Song> listIterator = this.playlist.listIterator();
        String tempSongName = "none";

        if(this.playlist.isEmpty()){
            System.out.println("No song in playlist.");
            return;
        } else {
            System.out.println("\nNow playing " + listIterator.next().getSongName());
           // printMenuOptions();
        }

        while (!quit) {
            int action = sc.nextInt();
            sc.nextLine();
            switch(action) {
                case 0:
                    printPlaylist();
                    printMenuOptions();
                    break;

                case 1: // skip forward
                    if(!goingForward){
                        if(listIterator.hasNext()) {
                        listIterator.next();
                        }
                        goingForward = true;
                     }

                    if(listIterator.hasNext()) {
                        listIterator.next().getSongName();
                        System.out.println("Skipping forward to " + listIterator.previous().getSongName());
                        listIterator.next().getSongName();
                    } else {
                        System.out.println("At the end of playlist.");
                        goingForward = false;
                    }
                   break;

                case 2: //skip backward
                    if(goingForward){
                        if(listIterator.hasPrevious()) {
                        listIterator.previous();
                        }
                        goingForward = false;
                     }

                    if(listIterator.hasPrevious()) {
                        System.out.println("Skipping back to " + listIterator.previous().getSongName());
                    } else {
                        System.out.println("At the start of playlist.");
                        goingForward = true;
                    }
                    break;

                case 3: //remove current song
                    if(listIterator.hasNext()) {
                        listIterator.next();
                        tempSongName = listIterator.previous().getSongName();
                        removeSong(tempSongName);
                        //listIterator.next();
                        this.printPlaylist();
                        break;
                    } else {
                        listIterator.previous();
                        tempSongName = listIterator.next().getSongName();
                        System.out.println("Removing " + tempSongName + ".");
                        removeSong(tempSongName);
                       // listIterator.next();
                        this.printPlaylist();
                        break;
                    }


                case 4: //current song
                    if(!goingForward){
                        if(listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }

                    if(listIterator.hasNext()) {
                        listIterator.next();
                        System.out.println("Now playing " + listIterator.previous().getSongName());
                        break;
                    } else {
                        if(goingForward){
                            if(listIterator.hasPrevious()) {
                                listIterator.previous();
                            }
                            goingForward = false;
                        }

                        listIterator.previous();
                        System.out.println("Now playing " + listIterator.next().getSongName());
                        break;

                    }

                case 5:
                    quit = true;
                    break;

            }
        }
    }

    private void removeSong(String songName){
        for(int i = 0; i < this.playlist.size();  i++) {
            if (songName == this.playlist.get(i).getSongName()) {
                System.out.println("Removing " + songName + ".");
                this.playlist.remove(i);
                return;
            }
        }

        System.out.println("Sorry, could not find " + songName + ".");

    }
}
