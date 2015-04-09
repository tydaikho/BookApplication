package com.example.phil.bookapplication.frags;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.phil.bookapplication.R;
import com.example.phil.bookapplication.frags.one.AllBookFragment_;
import com.example.phil.bookapplication.frags.one.BestBookFragment_;
import com.example.phil.bookapplication.frags.one.NewBookFragment_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

@EFragment(R.layout.fragment_menu_one)
public class MenuOneFragment extends Fragment {

    @ViewById(R.id.oneViewPager) protected ViewPager oneViewPager;


    @AfterViews
    protected  void afterViews() {
        oneViewPager.setAdapter(new PageAdapter(getChildFragmentManager()));
    }

    @Click(value = {R.id.oneBt1, R.id.oneBt2, R.id.oneBt3})
    protected void onClickMenuButton(View view) {
        String tag = (String) view.getTag();
        oneViewPager.setCurrentItem(Integer.parseInt(tag));

    }

    class PageAdapter extends FragmentPagerAdapter {
        private final List<Fragment> items = new ArrayList<>();

        public PageAdapter(FragmentManager fm) {
            super(fm);

            items.add(new BestBookFragment_());
            items.add(new NewBookFragment_().setText("New"));
            items.add(new AllBookFragment_().setText("All"));
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
