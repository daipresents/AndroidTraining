
package jp.mixi.practice.preference;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // TODO:preferences.xmlを作成してください => DONE
        // TODO:作成したpreferences.xmlの読み込み処理を実装してください => DONE
        // TODO:ListPreferenceの設定が変更されたらSummaryに反映してください

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        String menuTitle = item.getTitle().toString();
        Log.v(MainActivity.class.getSimpleName(), "Clicked menu is " + menuTitle);

        if( "Settings".equals(menuTitle)){
            Intent intent = new Intent(this, MyPreferenceActivity.class);
            startActivity(intent);
        }

        return super.onMenuItemSelected(featureId, item);
    }
}
