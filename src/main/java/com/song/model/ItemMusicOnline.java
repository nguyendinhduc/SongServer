package com.song.model;

public class ItemMusicOnline {
    private String id;
    private String linkImage;
    private String songName;
    private String artistName;
    private String linkSong;
    private String linkMusic;

    public ItemMusicOnline(String id, String linkImage, String songName, String artistName, String linkSong) {
        this.id = id;
        this.linkImage = linkImage;
        this.songName = songName;
        this.artistName = artistName;
        this.linkSong = linkSong;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLinkImage() {
        return linkImage;
    }

    public void setLinkImage(String linkImage) {
        this.linkImage = linkImage;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getLinkSong() {
        return linkSong;
    }

    public void setLinkSong(String linkSong) {
        this.linkSong = linkSong;
    }

    public String getLinkMusic() {
        return linkMusic;
    }

    public void setLinkMusic(String linkMusic) {
        this.linkMusic = linkMusic;
    }
}
