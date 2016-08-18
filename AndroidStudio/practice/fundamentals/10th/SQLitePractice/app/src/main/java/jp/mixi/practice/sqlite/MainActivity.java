
package jp.mixi.practice.sqlite;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

import java.util.Calendar;

/**
 * TODO
 * (実習) SQLiteOpenHelper クラス（ BookOpenHelper ）が実装されています。
 * SQLiteDatebase インスタンスを取得して、insert,delete,update,qureyメソッドを使用する機能を実装し実行結果をログで確認してください。
 */
public class MainActivity extends Activity {

    private BookOpenHelper helper = new BookOpenHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.Insert).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                insert();
            }
        });
        findViewById(R.id.Delete).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                delete();
            }
        });
        findViewById(R.id.Update).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
            }
        });
        findViewById(R.id.Query).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                query();
            }
        });

    }

    private void insert() {
        // TODO:ここにinsert処理を実装してください
        // 書き込み用のSQLiteDatabaseを取得
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Book.COLUMN_NAME_BOOK_TITLE, "TITLE1");
        values.put(Book.COLUMN_NAME_BOOK_PUBLISHER, "PUBLISHER1");
        values.put(Book.COLUMN_NAME_BOOK_PRICE, "PRICE1");

        // 戻り値はRowID（_ID）
        // エラーの場合は-1になる
        long rowId = db.insert(Book.BOOK_TABLE_NAME, null, values);
        Log.v(MainActivity.class.getSimpleName(), "insert: " + String.valueOf(rowId));
    }

    private void delete() {
        // TODO:ここにdelete処理を実装してください
        SQLiteDatabase db = helper.getWritableDatabase();

        // 条件を指定
        String selection = Book.COLUMN_NAME_BOOK_PRICE + " = ?";
        String[] selectionArgs = {
                "PRICE1"
        };
        int deletedCount = db.delete(Book.BOOK_TABLE_NAME, selection, selectionArgs);
        Log.v(MainActivity.class.getSimpleName(), "delete count: " + String.valueOf(deletedCount));
    }

    private void update() {
        // TODO:ここにupdate処理を実装してください
        SQLiteDatabase db = helper.getWritableDatabase();

        // update情報を設定する
        ContentValues values = new ContentValues();
        values.put(Book.COLUMN_NAME_BOOK_TITLE, "NEW_TITLE " + String.valueOf(Calendar.getInstance().getTimeInMillis()));

        // 条件を指定
        String selection = Book.COLUMN_NAME_BOOK_TITLE + " LIKE ?";
        String[] selectionArgs = {
                "TITLE%"
        };

        int updatedCount = db.update(Book.BOOK_TABLE_NAME, values, selection, selectionArgs);
        Log.v(MainActivity.class.getSimpleName(), "update count: " + String.valueOf(updatedCount));
    }

    private void query() {
        // TODO:ここにquery処理を実装してください
        // 読み込み用のSQLiteDatabaseを取得
        SQLiteDatabase db = helper.getReadableDatabase();

        // 取得する情報を指定
        String[] projection = {
                Book._ID,
                Book.COLUMN_NAME_BOOK_TITLE,
                Book.COLUMN_NAME_BOOK_PUBLISHER,
                Book.COLUMN_NAME_BOOK_PRICE
        };

        // 条件を指定
        String selection = Book.COLUMN_NAME_BOOK_PRICE + " = ?";
        String[] selectionArgs = {
                "PRICE1"
        };

        Cursor cursor = db.query(Book.BOOK_TABLE_NAME, projection, selection, selectionArgs, null, null, null);
        boolean moveToFirst = cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            long itemId = cursor.getLong(cursor.getColumnIndexOrThrow(Book._ID));
            Log.v(MainActivity.class.getSimpleName(), String.valueOf(itemId));
            cursor.moveToNext();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
