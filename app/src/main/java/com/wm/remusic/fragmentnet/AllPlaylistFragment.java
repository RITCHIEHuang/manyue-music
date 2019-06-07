package com.wm.remusic.fragmentnet;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bilibili.magicasakura.utils.ThemeUtils;
import com.wm.remusic.R;
import com.wm.remusic.fragment.AttachFragment;

import java.util.ArrayList;
import java.util.List;

public class AllPlaylistFragment extends AttachFragment implements ChangeView {
    //PreferencesUtility mPreferences;
    private ViewPager viewPager;
    private int page = 0;
    private String[] title = {"百度云音乐", "网易云音乐"};
    private boolean isFirstLoad = true;

    public static final AllPlaylistFragment newInstance(int page, String[] title) {
        AllPlaylistFragment f = new AllPlaylistFragment();
        Bundle bdl = new Bundle(1);
        bdl.putInt("page_number", page);
        bdl.putStringArray("title", title);
        f.setArguments(bdl);
        return f;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewPager.setCurrentItem(page);
    }

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // mPreferences = PreferencesUtility.getInstance(mContext);
        if (getArguments() != null) {
            page = getArguments().getInt("page_number");
            title = getArguments().getStringArray("title");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.recommend_all_playlist, container, false);


        viewPager = (ViewPager) rootView.findViewById(R.id.viewpager);
        if (viewPager != null) {
            setupViewPager(viewPager);
            viewPager.setOffscreenPageLimit(1);
        }

        final TabLayout tabLayout = (TabLayout) rootView.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabTextColors(R.color.text_color, ThemeUtils.getThemeColorStateList(mContext, R.color.theme_color_primary).getDefaultColor());
        tabLayout.setSelectedTabIndicatorColor(ThemeUtils.getThemeColorStateList(mContext, R.color.theme_color_primary).getDefaultColor());


        return rootView;

    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(baiduListFragment == null){
            return;
        }
        if(isVisibleToUser && isFirstLoad){
            baiduListFragment.requestData();
            isFirstLoad = false;
        }
    }
    NeteasePlayListFragment baiduListFragment;

    private void setupViewPager(ViewPager viewPager) {
        Adapter adapter = new Adapter(getChildFragmentManager());
        baiduListFragment = new NeteasePlayListFragment();
        adapter.addFragment(baiduListFragment, title[1]);
        adapter.addFragment(new BaiduPlayListFragment(), title[0]);

        viewPager.setAdapter(adapter);
    }

    @Override
    public void onPause() {
        super.onPause();

    }

    @Override
    public void onResume() {
        super.onResume();
    }


    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void changeTo(int page) {
        if (viewPager != null)
            viewPager.setCurrentItem(page);
    }

    static class Adapter extends FragmentStatePagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public Adapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            if (mFragments.size() > position)
                return mFragments.get(position);

            return null;
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }

        @Override
        public void restoreState(Parcelable state, ClassLoader loader) {
            // don't super !
        }
    }

}
