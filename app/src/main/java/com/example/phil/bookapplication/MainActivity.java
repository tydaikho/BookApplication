package com.example.phil.bookapplication;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import com.example.phil.bookapplication.frags.MenuFourFragment_;
import com.example.phil.bookapplication.frags.MenuOneFragment_;
import com.example.phil.bookapplication.frags.MenuThreeFragment_;
import com.example.phil.bookapplication.frags.MenuTwoFragment_;
import com.example.phil.bookapplication.model.Event;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;

@EActivity(R.layout.activity_main)
public class MainActivity extends ActionBarActivity {

    @ViewById(R.id.viewPager) protected ViewPager viewPager;


    @AfterInject
    void afterInject() {
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
        }

        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    public void onEvent(Event.SelectBook event) {
        Intent intent = new Intent(getApplicationContext(), BookDetailActivity_.class);
        intent.putExtra("book", event.getBook());
        startActivity(intent);
    }

    @AfterViews
    protected  void afterViews() {
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager()));
    }

    @Click(value = {R.id.menuBt1, R.id.menuBt2, R.id.menuBt3, R.id.menuBt4})
    protected void onClickMenuButton(View view) {
        String tag = (String) view.getTag();
        viewPager.setCurrentItem(Integer.parseInt(tag));

    }

    class PageAdapter extends FragmentPagerAdapter {
        private final List<Fragment> items = new ArrayList<>();

        public PageAdapter(FragmentManager fm) {
            super(fm);

            items.add(new MenuOneFragment_());
            items.add(new MenuTwoFragment_());
            items.add(new MenuThreeFragment_());
            items.add(new MenuFourFragment_());
        }

        @Override
        public Fragment getItem(int position) {
            return items.get(position);
        }

        @Override
        public int getCount() {
            return items.size();
        }
    }
}
