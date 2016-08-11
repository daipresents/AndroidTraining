
package jp.mixi.sample.viewpager;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.Menu;

/**
 * TODO
 * (実習) FragmentPagerAdapter の使い方で説明したプロジェクトを写経して実行してください。
 * 説明したプロジェクトはAndroidTraining/projects/fundamentals/6th/FragmentViewPagerSampleにあります。
 */
public class MainActivity extends FragmentActivity implements ActionBar.TabListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager pager = (ViewPager) findViewById(R.id.Pager);

        FragmentManager fm = getSupportFragmentManager();
        SampleFragmentPagerAdapter sampleFragmentPagerAdapter = new SampleFragmentPagerAdapter(fm);

        pager.setAdapter(new SamplePagerAdapter(this));

        /**
         * TODO
         * (課題) 実習1のプロジェクトを引き続き使用してください。
         * ActionBarのTab Navigationを追加し、Tabを選択したら該当のページが表示されるようにしてください。
         * （3番目のTabを選択したら3ページ目が表示される）
         * また、ページをスクロールさせたら該当のTabが選択されるようにしてください。
         * また、Tabとページの数は3つとしてください。
         */
        // タブナビゲーションモードに設定
        getActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        // タブを作成して追加。タブの選択・解除・再選択をハンドリングするコールバックの TabListener をセットしないと実行時例外でクラッシュする
        getActionBar().addTab(getActionBar().newTab().setText("Tab1").setTabListener(this));
        getActionBar().addTab(getActionBar().newTab().setText("Tab2").setTabListener(this));
        getActionBar().addTab(getActionBar().newTab().setText("Tab3").setTabListener(this));

        //スワイプしたときにもActionbarのタブ（NavigationItem）を常に表示させる処理
        pager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                getActionBar().setSelectedNavigationItem(position);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    // タブナビゲーションの Tab が選択された時のコールバック
    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    // タブナビゲーションの Tab が選択解除された時のコールバック
    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
    }

    // タブナビゲーションの Tab が再度選択された時のコールバック
    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
    }
}
