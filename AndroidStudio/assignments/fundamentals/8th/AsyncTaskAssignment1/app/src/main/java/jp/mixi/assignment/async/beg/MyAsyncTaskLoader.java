package jp.mixi.assignment.async.beg;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

/**
 * Created by daipr on 2016/08/16.
 */
public class MyAsyncTaskLoader extends AsyncTaskLoader<String> {
    public static final String TAG = MyAsyncTaskLoader.class.getSimpleName();
    private String mCachedData;

    public MyAsyncTaskLoader(Context context) {
        super(context);
    }

    // 非同期処理の中身
    @Override
    public String loadInBackground() {
        Log.v(MyAsyncTaskLoader.class.getSimpleName(), "loadBackground start.");
        SharedPreferences sp = getContext().getSharedPreferences("a-f-8-sample", getContext().MODE_PRIVATE);
        String savedDate = sp.getString("stringData", "");
        Log.v(MyAsyncTaskLoader.class.getSimpleName(), "loadBackground: " + savedDate);
        return savedDate;
    }

    @Override
    public void deliverResult(String data) {
        Log.v(MyAsyncTaskLoader.class.getSimpleName(), "deliverResult start. data is " + data);

        // ローダがリセットされ、そのローダのライフサイクルが終了となる場合
        if (isReset()) {
            // キャッシュデータがある場合は、キャッシュを削除して、メモリから破棄可能にする
            if (mCachedData != null) {
                mCachedData = null;
            }
            return;
        }

        // 得られたデータをキャッシュする
        mCachedData = data;

        // ローダが開始されている場合、親にデータが得られたことを通知する
        if (isStarted()) {
            super.deliverResult(data);
        }
    }

    @Override
    protected void onStartLoading() {
        Log.v(MyAsyncTaskLoader.class.getSimpleName(), "onStartLoading start.");

        // キャッシュがある場合はそちらを返す
        if (mCachedData != null) {
            deliverResult(mCachedData);
            return;
        }

        // データソースに変更があったり、キャッシュデータがない場合は loadInBackground() に行くようにする
        if (takeContentChanged() || mCachedData == null) {
            forceLoad();
        }
    }

    // ローダの非同期処理がストップする時のコールバック
    @Override
    protected void onStopLoading() {
        Log.v(MyAsyncTaskLoader.class.getSimpleName(), "onStopLoading start.");

        cancelLoad();
        super.onStopLoading();
    }

    // ローダがリセットされる時のコールバック
    @Override
    protected void onReset() {
        Log.v(MyAsyncTaskLoader.class.getSimpleName(), "onReset start.");

        onStopLoading();
        super.onReset();
    }
}
