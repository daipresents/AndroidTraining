package com.example.daipr.usercontentprovider;

import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

/**
 * TODO
 * (実習) サンプルアプリ（ContentProviderSample）に独自 ContentProvider ( BookContentProvider ) が実装されています。
 * まず、ContentProviderSample を起動してデータを追加してください。
 * その後に、新しくプロジェクトを作成し、 ContentProvider からデータの取得を行なってください。
 * また、 ContentProviderSample の AndroidManifest.xml を修正して非公開の ContentProvider にし、
 * データの取得ができないことを確認してください。
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Uri uri = Uri.parse("content://" + "jp.mixi.sample.contentprovider.Book" + "/book");
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        while (cursor.moveToNext()) {
            Log.d(MainActivity.class.getSimpleName(), "call:" + cursor.getString(cursor.getColumnIndexOrThrow("title")));
        }

        cursor.close();
    }
}
