package com.example.phil.bookapplication.frags.one;

import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.phil.bookapplication.R;
import com.example.phil.bookapplication.model.Book;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

@EFragment(R.layout.fragment_one_best)
public class BestBookFragment extends Fragment {
    @ViewById(R.id.bookListView) protected RecyclerView bookListView;
    @Bean protected BookListAdapter bookListAdapter;

    @AfterViews
    protected void afterViews() {
        bookListAdapter.reset(getBookList());

        bookListView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        bookListView.setItemAnimator(new DefaultItemAnimator());
        bookListView.setHasFixedSize(true);
        bookListView.setAdapter(bookListAdapter);
    }

    private List<Book> getBookList() {
        List<Book> list = new ArrayList<>();
        for (long i = 0; i < 64; i++) {
            list.add(new Book(i, "title" + i, "author" + i, "publisher" + i, i));
        }
        return list;
    }

}
