package com.example.phil.bookapplication.view;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.phil.bookapplication.R;
import com.example.phil.bookapplication.model.Book;
import com.example.phil.bookapplication.model.Event;
import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import de.greenrobot.event.EventBus;


@EViewGroup(R.layout.view_book_item)
public class BookItemView extends FrameLayout {

    @ViewById(R.id.bookImageView) protected ImageView bookImageView;
    @ViewById(R.id.titleTextView) protected TextView titleTextView;
    @ViewById(R.id.authorTextView) protected TextView authorTextView;
    @ViewById(R.id.publisherTextView) protected TextView publisherTextView;

    private Context context;
    private Book book;

    public BookItemView(Context context) {
        super(context);
        this.context = context;
    }

    public void setBook(Book book) {
        this.book = book;
        this.titleTextView.setText(book.getTitle());
        this.authorTextView.setText(book.getAuthor());
        this.publisherTextView.setText(book.getPublisher());

        Picasso.with(context).load(book.getImageUrl()).into(bookImageView);
    }

    @Click(R.id.bookItemViewWrapper)
    protected void onClick(View view) {
        EventBus.getDefault().post(new Event.SelectBook(book));
    }
}


