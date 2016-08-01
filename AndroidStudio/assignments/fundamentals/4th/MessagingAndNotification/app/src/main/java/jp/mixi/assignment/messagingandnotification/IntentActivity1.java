package jp.mixi.assignment.messagingandnotification;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import java.net.URI;

/**
 * 画面にボタンが 1 つ配置されています。このボタンのクリックイベントを拾う処理の中で、
 * ブラウザを立ち上げ、指定した URL を読み込むためのIntentオブジェクトを作成し、
 * ブラウザを立ち上げるところまでを実装してください。
 *
 * Created by suino on 2015/02/25.
 */
public class IntentActivity1 extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_1);

        View button = findViewById(R.id.ViewMixi);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO http://mixi.jp をブラウザで開くための Intent を作って、ブラウザを立ち上げる
                Intent intent = new Intent(getThis(), OpenURLActivity.class);
                intent.setAction("ACTION_VIEW");
                intent.setData(Uri.parse("http://mixi.jp"));
                startActivity(intent);
            }
        });
    }

    private Context getThis(){
        return this;
    }

}
