package jp.mixi.assignment.async.beg;

import android.app.IntentService;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by daipr on 2016/08/15.
 */
public class MyIntentService extends IntentService {
    public static final String TAG = MyIntentService.class.getSimpleName();

    public MyIntentService() {
        this(MyIntentService.class.getSimpleName());
    }

    public MyIntentService(String name) {
        super(name);
    }

    /**
     * {@link android.app.Service} のライフサイクルの開始。
     */
    @Override
    public void onCreate() {
        super.onCreate();
        Log.v(TAG, "onCreate");
    }

    /**
     * 親クラスで必要な処理がひと通り揃っているため、通常は Override の必要はない。
     */
    @Override
    public IBinder onBind(Intent intent) {
        Log.v(TAG, "onBind");
        return super.onBind(intent);
    }

    /**
     * 親クラスで必要な処理がひと通り揃っているため、通常は Override の必要はない。
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.v(TAG, "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    /**
     * {@link android.content.Context#startService(Intent)} によって呼び出される。
     * ワーカスレッド上で実行されるため、ネットワーク通信等のスレッドをブロックする処理を直接記述しても問題ない。
     */
    @Override
    protected void onHandleIntent(Intent intent) {
        Log.v(TAG, "onHandleIntent");

        // TODO: 適宜、保持しているデータを見て書き込みと読み込みを行うこと。
        SharedPreferences sp = getSharedPreferences("a-f-8-sample", MODE_PRIVATE);

        Log.v(MyIntentService.class.toString(), "Start saving.");

        PreferencesEntity entity = (PreferencesEntity) intent.getParcelableExtra("data");
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("stringData", entity.getHoge());
        editor.putInt("intData", entity.getFuga());
        editor.putBoolean("booleanData", entity.isPiyo());
        editor.commit();

        Log.v(TAG, "Data is commited.");

    }

    /**
     * {@link android.app.Service} のライフサイクルの終了。
     * {@link MyIntentService} では、1 回の {@link android.content.Context#startService(Intent)} の呼び出しで
     * 1 つのライフサイクルが回るように作られている。
     */
    @Override
    public void onDestroy() {
        Log.v(TAG, "onDestroy");
        super.onDestroy();
    }
}
