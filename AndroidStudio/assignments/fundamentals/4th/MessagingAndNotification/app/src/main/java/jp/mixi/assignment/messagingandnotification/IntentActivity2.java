package jp.mixi.assignment.messagingandnotification;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

/**
 * 画面にボタンが 1 つ配置されています。このボタンのクリックイベントを拾う処理の中で、EditText を 1 つと、
 * ボタンを 1 つ配置した新しい Activity を立ち上げ、EditText の入力内容を結果として返し、
 * 返された結果を Toast で表示するようにしてください。
 * Created by suino on 2015/02/25.
 */
public class IntentActivity2 extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_2);

        View button = findViewById(R.id.CallActivityForResult);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO EditText と ボタンを 1 つずつ持つ新しい Activity を呼び出し、ボタンを押した時に結果を返すように実装する
                startActivityForResult(new Intent(getThis(), ShowToastActivity.class), ShowToastActivity.REQUEST_CODE_TOAST);
            }
        });
    }

    // TODO 返ってきた結果を Toast で表示するところも実装すること
    // 新しい Activity から戻ってくる Intent を受け取るコールバック
    // 新しい Activity が全面に出る場合は、onRestart()の前、ダイアログのように一部を覆って表示される場合は、onResume()の前で呼ばれる
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        // super.onActivityResult(int, int, Intent) の呼び出しは、条件に関係なくすること
        // Fragment から startActivityForResult(Intent, int) した場合の戻りの判定ができなくなってしまう
        super.onActivityResult(requestCode, resultCode, data);

        String toastMessage = data.getStringExtra("inputData");
        Log.v("===============", toastMessage);

        // requestCode には、startActivityForResult(Intent, int) の第 2 引数で指定したものが来る
        // resultCode には、呼び出し先で　setResult(int, Intent) をコールした時の第 1 引数が来る
        // data には、呼び出し先で　setResult(int, Intent) をコールした時の第 2 引数が来る
        switch (requestCode) {
            case ShowToastActivity.REQUEST_CODE_TOAST:
                Toast.makeText(IntentActivity2.this, toastMessage, Toast.LENGTH_LONG).show();
                return;
            default:
                return;
        }
    }

    private Context getThis() {
        return this;
    }
}
