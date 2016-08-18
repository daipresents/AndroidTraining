package jp.mixi.practice.network.networkpractice2;

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
 * (実習) HttpURLConnectionを利用してmixi.jpへアクセスをし、取得できたhtmlの文字列を画面に表示してください。
 */
public class MainActivity extends FragmentActivity implements LoaderManager.LoaderCallbacks<String> {

    private FragmentActivity mainActivity;
    private String url;
    private String param;

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

        EditText accessUrl = (EditText) findViewById(R.id.accessUrl);
        url = accessUrl.getText().toString();
        Log.v(MainActivity.class.getSimpleName(), url);

        EditText httpBody = (EditText) findViewById(R.id.httpBody);
        param = httpBody.getText().toString();

        View buttonGet = findViewById(R.id.buttonGet);
        buttonGet.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                // http getの処理を書く
                LoaderManager manager = mainActivity.getSupportLoaderManager();
                Bundle argsForLoader = new Bundle();
                argsForLoader.putString("url", url);
                manager.initLoader(0, argsForLoader, MainActivity.this);
            }
        });
        View buttonPost = findViewById(R.id.buttonPost);
        buttonPost.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                // http postの処理を書く
                LoaderManager manager = mainActivity.getSupportLoaderManager();
                Bundle argsForLoader = new Bundle();
                argsForLoader.putString("url", url);
                argsForLoader.putString("param", param);
                manager.initLoader(1, argsForLoader, MainActivity.this);
            }
        });
    }

    @Override
    public Loader<String> onCreateLoader(int id, Bundle args) {
        switch (id) {
            case 0:
                return new GetAsyncTaskLoader(this, args.getString("url"));
            case 1:
                return new PostAsyncTaskLoader(this, args.getString("url"), args.getString("param"));
            default:
                return null;
        }
    }

    @Override
    public void onLoadFinished(Loader<String> loader, String result) {
        Log.v(MainActivity.class.getSimpleName(), result);
        TextView response = (TextView) mainActivity.findViewById(R.id.responce);
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
