package com.song;

import com.song.model.GetLinkMusic;
import com.song.model.ItemMusicOnline;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class SongManager {
    public Object searchSong(String songName, int currentPage) {
        if (songName == null || songName.trim().equals("")) {
            return getListFirstSong();
        }
        List<ItemMusicOnline> onlines = new ArrayList<>();
        try {
            Document c = Jsoup.connect("https://chiasenhac.vn/tim-kiem?q="
                    + songName.replace(" ", "+") +
                    "&page_music=" + currentPage + "&filter=all").get();
            Elements els = c.select("div.tab-content").first().select("ul.list-unstyled");
            for (int i = 0; i <= els.size() - 1; i++) {
                Element e = els.get(i);
                Elements childEls = e.select("li.media");
                for (Element child : childEls) {
                    try {
                        String linkSong =
                                child.select("a").first().attr("href");
                        String linkImg =
                                child.select("a").first().select("img").attr("src");
                        String title = child.select("a").first().attr("title");
                        String singer = child.select("div.author").text();
                        onlines.add(new ItemMusicOnline(linkSong, linkImg, title, singer, linkSong));
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }

                }
            }
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }

        return onlines;
    }

    private Object getListFirstSong() {
        List<ItemMusicOnline> onlines = new ArrayList<>();
        try {
            Document doc = Jsoup.connect("https://chiasenhac.vn/bang-xep-hang/tuan.htmlhttps://chiasenhac.vn/bang-xep-hang/tuan.html").get();
            Elements els = doc.select("div.tab-content").select("ul.list-unstyled");
            Elements childEls = els.select("li.media");
            for (Element child : childEls) {
                String linkSong =
                        "https://chiasenhac.vn" + child.select("a").first().attr("href");
                String linkImage = child.select("a").first().select("img").attr("src");
                String nameSong = child.select("a").first().attr("title");
                String nameSinger = child.select("div.author").text();
                onlines.add(new ItemMusicOnline(linkSong, linkImage, nameSong, nameSinger, linkSong));
            }
        } catch (IOException e) {

        }

        return onlines;
    }

    public Object getLinkMusic(String linkSong) {
        try {
            Document c = Jsoup.connect(linkSong).get();
            Elements els =
                    c.select("div.tab-content").first().select("a.download_item");
            if (els.size() >= 2) {
                return
                        new GetLinkMusic(els.get(1).attr("href"));
            } else {
                return
                        new GetLinkMusic(els.get(0).attr("href"));
            }

        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
        return null;
    }
}
