package jp.mixi.sample.contentprovider;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.util.Log;
import android.widget.ListView;

/**
 * Created by daipr on 2016/08/19.
 */
public class MainLoaderActivity extends FragmentActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    private SimpleCursorAdapter simpleCursorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_loader);

        ListView listView = (ListView) findViewById(R.id.ListView);

        String[] from = {
                Book.COLUMN_NAME_BOOK_TITLE, Book.COLUMN_NAME_BOOK_PUBLISHER, Book.COLUMN_NAME_BOOK_PRICE
        };

        int[] to = {
                R.id.title, R.id.publisher, R.id.price
        };

        simpleCursorAdapter =
                new SimpleCursorAdapter(this, R.layout.list_custom, null, from, to, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        listView.setAdapter(simpleCursorAdapter);

        LoaderManager loaderManager = getSupportLoaderManager();
        loaderManager.initLoader(0, null, this);

        Cursor cursor = getContentResolver().query(Book.CONTENT_URI, null, null, null, null);
        while (cursor.moveToNext()) {
            Log.d(MainLoaderActivity.class.getSimpleName(), cursor.getString(cursor.getColumnIndexOrThrow(Book.COLUMN_NAME_BOOK_TITLE)));
        }
        cursor.close();
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        // ここでデータの取得条件の指定が可能です。
        // CursorLoader (Context context, Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder)
        return new CursorLoader(this, Book.CONTENT_URI, null, null, null, null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor c) {
        // 古いCursorと新しいCursorを入れ替えます。そのため最新のデータが表示されます。
        simpleCursorAdapter.swapCursor(c);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> cursor) {
        // 古いCursorと新しいCursorを入れ替えます。そのため最新のデータが表示されます。
        simpleCursorAdapter.swapCursor(null);
    }
}
