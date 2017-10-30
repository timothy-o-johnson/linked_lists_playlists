package com.robinsondetroit;

public class Main {

    public static void main(String[] args) {
        Album brightenTheCorners = purchaseBrightenTheCorners();
        AlbumCollection timsAlbumCollection = new AlbumCollection("Tim");
       // Song tempSong = new Song("Blank", 0.0);

        //add album to collection
        timsAlbumCollection.addAlbumToCollection(brightenTheCorners);



        Playlist pavementPlaylist = new Playlist("Pavement", timsAlbumCollection);

       // tempSong = Playlist.songExists("Fin", timsAlbumCollection);

        pavementPlaylist.addSong("Fin");
        pavementPlaylist.addSong("Embassy Row");
        pavementPlaylist.addSong("Passat Dream");
        pavementPlaylist.addSong("We Are Underused");
        pavementPlaylist.addSong("Blue Hawaiian");
        pavementPlaylist.addSong("Starlings of the Slipstream");

        pavementPlaylist.printPlaylist();

        pavementPlaylist.printMenuOptions();
        pavementPlaylist.playlistControls();
    }


    public static Album purchaseBrightenTheCorners() {
        System.out.println("Congrats on the new purchase! Look at what you've got!\n");
        Album brightenTheCorners = new Album("Brighten The Corners", "Pavement");

        brightenTheCorners.addTracks("Stereo", 3.07);
        brightenTheCorners.addTracks("Shady Lane / J Vs S", 3.50);
        brightenTheCorners.addTracks("Transport Is Arranged", 3.52);
        brightenTheCorners.addTracks("Date w/IKEA", 2.39);
        brightenTheCorners.addTracks("Old to Begin", 3.22);
        brightenTheCorners.addTracks("Type Slowly", 5.20);
        brightenTheCorners.addTracks("Embassy Row", 3.51);
        brightenTheCorners.addTracks("Blue Hawaiian", 3.33);
        brightenTheCorners.addTracks("We Are Underused", 4.12);
        brightenTheCorners.addTracks("Passat Dream", 3.51);
        brightenTheCorners.addTracks("Starlings of the Slipstream", 3.08);
        brightenTheCorners.addTracks("Fin", 5.24);

        System.out.println("Album: " + brightenTheCorners.getAlbumName());
        System.out.println("Artist: " + brightenTheCorners.getArtist());
        System.out.println("Album length: " + brightenTheCorners.getAlbumLength());
        brightenTheCorners.printTrackListings();

        return brightenTheCorners;
    }

}

