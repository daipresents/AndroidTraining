package jp.mixi.assignment.sqlite.beg;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by daipr on 2016/08/19.
 *
 * TODO
 * (課題) 以下のデータベースを作成する SQLiteOpenHelper クラスを作成し insert , qurey を実行してください。
 * DB名 : plactice
 テーブル名 : android_code_name

 カラム名	内容
 _id	プライマリーキー
 name	テキスト型 null禁止
 version	テキスト型 null許容
 */
public class AndroidCodeNameOpenHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 5;
    public static final String DATABASE_NAME = "plactice.db";

    private static final String ANDROID_CODE_NAME_TABLE_CREATE =
            "CREATE TABLE " + AndroidCodeName.ANDROID_CODE_NAME_TABLE_NAME + " (" +
                    AndroidCodeName._ID + " INTEGER PRIMARY KEY, " +
                    AndroidCodeName.COLUMN_NAME_ANDROID_CODE_NAME_NAME + " TEXT NOT NULL, " +
                    AndroidCodeName.COLUMN_NAME_ANDROID_CODE_NAME_VERSION + " TEXT);";

    private static final String ANDROID_CODE_NAME_TABLE_DELETE =
            "DROP TABLE IF EXISTS " + AndroidCodeName.ANDROID_CODE_NAME_TABLE_NAME;

    public AndroidCodeNameOpenHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.v(AndroidCodeName.class.getSimpleName(), "onCreate start.");
        db.execSQL(ANDROID_CODE_NAME_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.v(AndroidCodeName.class.getSimpleName(), "onUpgrade start.");
        db.execSQL(ANDROID_CODE_NAME_TABLE_DELETE);
        onCreate(db);
    }
}
