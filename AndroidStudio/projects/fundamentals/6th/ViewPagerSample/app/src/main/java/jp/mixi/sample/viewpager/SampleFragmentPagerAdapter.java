package jp.mixi.sample.viewpager;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by daipr on 2016/08/11.
 */
public class SampleFragmentPagerAdapter extends FragmentPagerAdapter {
    private static final int PAGE_COUNT = 5;

    public SampleFragmentPagerAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        return SampleFragment.newINstance(position);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }
}
