package jp.mixi.assignment.network.networkAssignment;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

/**
 * TODO
 * (課題) youtubeで日本で前日の評価が最も高い動画のタイトルをAPIで取得し表示してください。
 */
public class MainActivity extends FragmentActivity implements LoaderManager.LoaderCallbacks<String> {

    Activity mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
            StrictMode.setThreadPolicy(
                    new StrictMode.ThreadPolicy.Builder()
                    .detectNetwork()
                    .penaltyDeath()
                    .build());
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainActivity = this;

        LoaderManager manager = getSupportLoaderManager();
        Bundle argsForLoader = new Bundle();
        manager.initLoader(0, argsForLoader, MainActivity.this);


    }

    @Override
    public Loader<String> onCreateLoader(int id, Bundle args) {
        switch (id) {
            case 0:
                return new GetAsyncTaskLoader(this);
            default:
                return null;
        }
    }

    @Override
    public void onLoadFinished(Loader<String> loader, String result) {
        Log.v(MainActivity.class.getSimpleName(), result);
        TextView response = (TextView) mainActivity.findViewById(R.id.title);
        response.setText(result);
    }

    @Override
    public void onLoaderReset(Loader<String> loader) {}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
