package com.example.phil.bookapplication.model;

/**
 * Created by phil on 2015. 4. 9..
 */
public class Event {

    public static final class SelectBook {
        private Book book;
        public SelectBook(Book book) {
            this.book = book;
        }

        public Book getBook() {
            return this.book;
        }
    }

}
