
package jp.mixi.assignment.sqlite.beg;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

/**
 * TODO
 * (課題) 以下のデータベースを作成する SQLiteOpenHelper クラスを作成し insert , qurey を実行してください。
 * DB名 : plactice
 テーブル名 : android_code_name

 カラム名	内容
 _id	プライマリーキー
 name	テキスト型 null禁止
 version	テキスト型 null許容
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // TODO:独自SQLiteOpenHelperの作成、それに使用するカラム名などの定義 => DONE.

        // TODO:insert処理
        Log.v(MainActivity.class.getSimpleName(), "start insert.");
        AndroidCodeNameOpenHelper helper = new AndroidCodeNameOpenHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(AndroidCodeName.COLUMN_NAME_ANDROID_CODE_NAME_NAME, "daipresents");
        values.put(AndroidCodeName.COLUMN_NAME_ANDROID_CODE_NAME_VERSION, "300");

        long rowId = db.insert(AndroidCodeName.ANDROID_CODE_NAME_TABLE_NAME, null, values);
        Log.v(MainActivity.class.getSimpleName(), "insert end:" + String.valueOf(rowId));

        // TODO query処理の実装
        Log.v(MainActivity.class.getSimpleName(), "query start.");
        db = helper.getReadableDatabase();

        // 取得する情報を指定
        String[] projection = {
                AndroidCodeName._ID,
                AndroidCodeName.COLUMN_NAME_ANDROID_CODE_NAME_NAME,
                AndroidCodeName.COLUMN_NAME_ANDROID_CODE_NAME_VERSION
        };

        // 条件を指定
        String selection = AndroidCodeName.COLUMN_NAME_ANDROID_CODE_NAME_NAME + " = ?";
        String[] selectionArgs = {
                "daipresents"
        };

        /**
         *  TODO
         (課題) 2で作成したデータベースを表示する ListView を作成してください。
         Adapter には SimpleCursorAdapter を使用してください。プロジェクトは2のものを使用してください。
         */
        ListView listView = (ListView) findViewById(R.id.ListView);

        Cursor cursor = db.query(AndroidCodeName.ANDROID_CODE_NAME_TABLE_NAME, projection, selection, selectionArgs, null, null, null);
        String[] from = {
                AndroidCodeName._ID, AndroidCodeName.COLUMN_NAME_ANDROID_CODE_NAME_NAME, AndroidCodeName.COLUMN_NAME_ANDROID_CODE_NAME_VERSION
        };
        int[] to = {
                R.id.id, R.id.name, R.id.version
        };
        SimpleCursorAdapter adapter =
                new SimpleCursorAdapter(this, R.layout.list_android_code_name, cursor, from, to, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        listView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
