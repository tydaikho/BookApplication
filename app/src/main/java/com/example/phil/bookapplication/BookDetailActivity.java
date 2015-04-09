package com.example.phil.bookapplication;

import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

import com.example.phil.bookapplication.model.Book;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_book_detail)
public class BookDetailActivity extends ActionBarActivity{
    @ViewById(R.id.textView) protected TextView textView;

    @AfterViews
    protected void afterInject() {
        Book book = (Book) getIntent().getSerializableExtra("book");
        textView.setText(book.getTitle());
    }
}
