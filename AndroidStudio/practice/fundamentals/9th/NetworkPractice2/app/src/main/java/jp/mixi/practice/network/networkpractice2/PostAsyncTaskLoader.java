package jp.mixi.practice.network.networkpractice2;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by daipr on 2016/08/18.
 */
public class PostAsyncTaskLoader extends AsyncTaskLoader<String> {
    public static final String TAG = PostAsyncTaskLoader.class.getSimpleName();
    private String mCachedData;
    private String url;
    private String param;

    public PostAsyncTaskLoader(Context context, String url, String param) {
        super(context);
        this.url = url;
        this.param = param;
    }

    // 非同期処理の中身
    @Override
    public String loadInBackground() {

        String response = "";
        String target = this.url + "?" + this.param;
        Log.v(MainActivity.class.getSimpleName(), target);

        HttpClient client = new DefaultHttpClient();
        try {
            response = client.execute(new HttpPost(target),
                    new ResponseHandler<String>() {
                        public String handleResponse(HttpResponse response)
                                throws ClientProtocolException, IOException {
                            return EntityUtils.toString(response.getEntity());
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public void deliverResult(String data) {
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
        cancelLoad();
        super.onStopLoading();
    }

    // ローダがリセットされる時のコールバック
    @Override
    protected void onReset() {
        onStopLoading();
        super.onReset();
    }
}
