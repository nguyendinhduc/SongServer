package com.song;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SongController {
    @Autowired
    private SongManager songManager;
    @GetMapping("/api/searchSong")
    public Object searchSong(
            @RequestParam(value = "songName", required = false) String songName,
            @RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage
    ){
        return songManager.searchSong(songName,currentPage);
    }

    @GetMapping("/api/linkMusic")
    public Object getLinkMusic(
            @RequestParam(value = "linkSong") String linkSong
    ){
        return songManager.getLinkMusic(linkSong);
    }
}
