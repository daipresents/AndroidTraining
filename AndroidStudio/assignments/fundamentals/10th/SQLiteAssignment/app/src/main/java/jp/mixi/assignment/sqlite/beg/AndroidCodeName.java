package jp.mixi.assignment.sqlite.beg;

import android.provider.BaseColumns;

/**
 * Created by daipr on 2016/08/19.
 * TODO
 * (課題) 以下のデータベースを作成する SQLiteOpenHelper クラスを作成し insert , qurey を実行してください。
 * DB名 : plactice
 テーブル名 : android_code_name

 カラム名	内容
 _id	プライマリーキー
 name	テキスト型 null禁止
 version	テキスト型 null許容
 */
public class AndroidCodeName implements BaseColumns {
    public static final String ANDROID_CODE_NAME_TABLE_NAME = "android_code_name";

    public static final String COLUMN_NAME_ANDROID_CODE_NAME_NAME = "name";
    public static final String COLUMN_NAME_ANDROID_CODE_NAME_VERSION = "version";

    private String name;
    private String version;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
