package jp.mixi.assignment.actionbar.beg;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

/**
 * TODO (課題) 新しい Activity を作成し、その Activity の中で App Icon Navigation を有効にした上で、
 * 階層を戻るボタンとしての役割を実装してください
 */
public class AppIconActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_icon);

        getActionBar().setHomeButtonEnabled(true);
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        Log.v("====", Integer.toString(item.getItemId()));


        switch (item.getItemId()) {
            case android.R.id.home:
                Log.v("android.R.id.home:", Integer.toString(android.R.id.home));
                startActivity(new Intent(getThis(), MainActivity.class));
                return super.onMenuItemSelected(featureId, item);
            default:
                return super.onMenuItemSelected(featureId, item);
        }
    }


    private Context getThis(){
        return this;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
