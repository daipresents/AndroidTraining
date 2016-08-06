
package jp.mixi.assignment.actionbar.med;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;

/**
 * TODO
 * (課題) 3 つのタブと、2 つの ActionItem を持つ ActionBar を MainActivity に実装してください。
 * ActionItem のうち、片方は新しい Activity を起動するように、
 * もう片方は MainActivity を終了するようにイベントをハンドリングしてください。
 */
public class MainActivity extends Activity implements ActionBar.TabListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // タブナビゲーションモードに設定
        getActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        // タブを作成して追加。タブの選択・解除・再選択をハンドリングするコールバックの TabListener をセットしないと実行時例外でクラッシュする
        getActionBar().addTab(getActionBar().newTab().setText("Tab1").setTabListener(this));
        getActionBar().addTab(getActionBar().newTab().setText("Tab2").setTabListener(this));
        getActionBar().addTab(getActionBar().newTab().setText("Tab3").setTabListener(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // ここで、状態に応じてメニューの有効・無効を切り替えたりなどの処理をする
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if ("Edit".equals(item.getTitle())) {
            // Open new activity.
            startActivity(new Intent(this, NewActivity.class));

        } else if ("Preview".equals(item.getTitle())) {
            // Finish main activity.
            finish();
        }

        return super.onOptionsItemSelected(item);
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
