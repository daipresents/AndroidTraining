
package jp.mixi.assignment.interaction.beg;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;

/**
 * TODO
 * (課題) OptionsMenu に、以下の 2 つの項目を表示し、
 * そのうち一方の項目の有効／無効の状態を交互に切り替える処理を実装してください。
 *   Settings と表示するもの
 *   Refresh と表示するもの
 */
public class MainActivity extends Activity {

    private Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if ("Settings".equals(item.getTitle())){
            item.setEnabled(false);
            MenuItem refresh = (MenuItem)this.menu.findItem(R.id.action_refresh);
            refresh.setEnabled(true);
        }else if("Refresh".equals(item.getTitle())){
            item.setEnabled(false);
            MenuItem setting = (MenuItem)this.menu.findItem(R.id.action_settings);
            setting.setEnabled(true);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        this.menu = menu;
        MenuItem refresh = (MenuItem)this.menu.findItem(R.id.action_refresh);
        refresh.setEnabled(false);
        return true;
    }

}
