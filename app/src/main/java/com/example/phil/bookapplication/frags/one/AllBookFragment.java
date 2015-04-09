package com.example.phil.bookapplication.frags.one;

import android.support.v4.app.Fragment;
import android.widget.TextView;

import com.example.phil.bookapplication.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

/**
 * Created by phil on 2015. 4. 9..
 */
@EFragment(R.layout.fragment_dummy)
public class AllBookFragment extends Fragment {

    @ViewById(R.id.textView) protected TextView textView;

    private String text;

    public AllBookFragment setText(String text) {
        this.text = text;
        return this;
    }

    @AfterViews
    protected  void afterView() {
        this.textView.setText(text);
    }


}
