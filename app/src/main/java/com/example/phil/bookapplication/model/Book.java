package com.example.phil.bookapplication.model;

import java.io.Serializable;


public class Book implements Serializable{

    private static final String[] urls = {
            "http://41.media.tumblr.com/b200093e29442b05f3d86f574780e414/tumblr_nmi8r5svD61tvcttpo1_250.jpg",
            "http://36.media.tumblr.com/b6df8a8e502ac323ea8f5aa0fb0a3fd9/tumblr_nm7zaqTlLj1tgbkn6o1_250.jpg",
            "http://40.media.tumblr.com/93793efa7ea69b72fd41a153344b7180/tumblr_nkszyzplmj1r4lihzo1_250.png",
            "http://36.media.tumblr.com/beb69bc24c16422c92fb1cdfbc0f1fc5/tumblr_n7jywgpWqa1qgqig6o1_400.png",
            "http://40.media.tumblr.com/6e478504b2636561581783e7ae76b129/tumblr_n7pd83Hkhp1tthm8wo1_400.jpg",
            "http://41.media.tumblr.com/ab63ccb43481b427bc37ff8b59114cfc/tumblr_nmhtjzJw7a1qemdseo1_250.jpg",
            "http://40.media.tumblr.com/3b7e658300aefe352d5b6430624af799/tumblr_naxqvbCSGi1qgddlro1_250.jpg",
            "http://41.media.tumblr.com/d91e9c2e44dfd66187e9c78408f6bb29/tumblr_ne9u4tZPI31rags0ko1_250.jpg",
            "http://41.media.tumblr.com/4f6cdbac6f6a82ae8c392bdf1857e368/tumblr_nmbo7y3y6k1scp6t2o1_400.png",
            "http://40.media.tumblr.com/aa1159ed4876a69af5c9b4725d2b02dc/tumblr_nm7z1qqAE71qb139no1_400.jpg"
    };

    private Long bookUid;
    private String title;
    private String author;
    private String publisher;
    private Long bookImageUid;

    public Book() {
    }

    public Book(Long bookUid, String title, String author, String publisher, Long bookImageUid) {
        this.bookUid = bookUid;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.bookImageUid = bookImageUid;
    }

    public String getImageUrl() {
        return urls[((int) (bookImageUid % urls.length))];
    }

    public Long getBookImageUid() {
        return bookImageUid;
    }

    public void setBookImageUid(Long bookImageUid) {
        this.bookImageUid = bookImageUid;
    }

    public Long getBookUid() {
        return bookUid;
    }

    public void setBookUid(Long bookUid) {
        this.bookUid = bookUid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
