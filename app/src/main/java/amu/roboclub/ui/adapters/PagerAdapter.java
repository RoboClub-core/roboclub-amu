package amu.roboclub.ui.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {
    private final int mTabs;
    private final Class[] fragments;
    private String[] titles;

    public PagerAdapter(FragmentManager fm, Class... tabs) {
        super(fm);
        mTabs = tabs.length;
        fragments = tabs;
    }

    public void setTitles(String... titles) {
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int position) {

        if (position >= mTabs || position < 0)
            return null;

        try {
            return (Fragment) fragments[position].newInstance();
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public int getCount() {
        return mTabs;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
