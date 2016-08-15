package jp.mixi.assignment.async.beg;

import android.app.Activity;
import android.content.Intent;
import android.content.Loader;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * TODO
 * (課題) SharedPreferences にデータを書き込むための MyIntentService を作成してください。
 *
 * TODO
 * (課題) SharedPreferences からデータを読み出すための AsyncTaskLoader を作成してください（プロジェクトは Service の課題と同じ物を用いること）。
 */
public class MainActivity extends FragmentActivity implements LoaderManager.LoaderCallbacks<String> {

    Activity mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainActivity = this;

        // TODO: それぞれ、ボタンクリックに反応して、SharedPreferences からの読み込みと保存の処理を実装すること。
        Button saveButton = (Button) findViewById(R.id.SaveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(MainActivity.class.toString(), "Save button is clicked");

                // TODO: 保存、読み込みのためのオブジェクトは、 PreferencesEntity クラスを使用する。
                String saveData = new SimpleDateFormat().format(Calendar.getInstance().getTime());
                Log.v(MainActivity.class.getSimpleName(), saveData);

                PreferencesEntity data = new PreferencesEntity(saveData, Calendar.getInstance().get(Calendar.SECOND), true);
                Intent intent = new Intent(mainActivity, MyIntentService.class);
                intent.putExtra("data", data);
                startService(intent);
            }
        });

        Button loadButton = (Button) findViewById(R.id.LoadButton);
        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(MainActivity.class.toString(), "Load button is clicked");
                // TODO: 読み込みが終わったら、Toast で、PreferencesEntity が持っているデータのどれか好きなものを表示する
                //SharedPreferences sp = getSharedPreferences("a-f-8-sample", MODE_PRIVATE);
                //Toast.makeText(mainActivity, sp.getString("stringData", ""), Toast.LENGTH_SHORT).show();

                // TODO (課題) SharedPreferences からデータを読み出すための AsyncTaskLoader を作成してください（プロジェクトは Service の課題と同じ物を用いること）。
                // ローダの管理をするオブジェクト
                LoaderManager manager = getSupportLoaderManager();
                Bundle argsForLoader = new Bundle();
                // ローダを初期化して非同期処理を開始する
                manager.initLoader(0, argsForLoader, MainActivity.this);

            }
        });

    }

    // id に対応した Loader のインスタンスを作って返す
    // args は Loader に渡したい引数を Bundle に詰めたもの
    @Override
    public android.support.v4.content.Loader<String> onCreateLoader(int id, Bundle args) {
        Log.v(MainActivity.class.toString(), "onCreateLoader start.");

        switch (id) {
            case 0:
                return new MyAsyncTaskLoader(this);
            default:
                return null;
        }
    }

    // 結果を受け取るコールバック
    // メインスレッドで動作する

    @Override
    public void onLoadFinished(android.support.v4.content.Loader<String> loader, String data) {
        Log.v(MainActivity.class.toString(), "onLoadFinished start. data is " + data);
        Toast.makeText(this, data, Toast.LENGTH_LONG).show();
    }

    // ローダがリセットされる時のコールバック
    @Override
    public void onLoaderReset(android.support.v4.content.Loader<String> loader) {
        Log.v(MainActivity.class.toString(), "onLoaderReset start.");
    }

}