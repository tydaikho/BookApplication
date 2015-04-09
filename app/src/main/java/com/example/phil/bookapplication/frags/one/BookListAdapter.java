package com.example.phil.bookapplication.frags.one;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.phil.bookapplication.model.Book;
import com.example.phil.bookapplication.view.BookItemView;
import com.example.phil.bookapplication.view.BookItemView_;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.ArrayList;
import java.util.List;

@EBean
public class BookListAdapter extends RecyclerView.Adapter<BookListAdapter.ViewHolder>{
    @RootContext protected Context context;

    private final List<Book> items = new ArrayList<>();

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onBindViewHolder(BookListAdapter.ViewHolder viewHolder, int position) {
        Book book = items.get(position);
        viewHolder.bookItemView.setBook(book);
    }

    @Override
    public BookListAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(BookItemView_.build(context));
    }

    public void reset(List<Book> items) {
        this.items.clear();
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        BookItemView bookItemView;
        public ViewHolder(View itemView) {
            super(itemView);
            bookItemView = (BookItemView) itemView;
        }
    }
}
