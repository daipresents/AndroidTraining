package jp.mixi.assignment.messagingandnotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.NotificationCompat;

/**
 * TODO アイコン、タイトル、詳細メッセージを含む通知を表示してください。通知を表示するときに、バイブレーションを作動させるようにしてください。
 * Created by suino on 2015/02/26.
 */
public class NotificationActivity1 extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification1);

        // TODO ここで通知を表示する
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        Notification notification = builder
                // 通知の日時
                .setWhen(System.currentTimeMillis())
                // 通知のタイトル
                .setContentTitle("タイトルだよ")
                // 通知の詳細メッセージ
                .setContentText("しょうさいめっせーじだよ")
                // 通知のアイコン
                .setSmallIcon(R.drawable.ic_launcher)
                .setTicker("通知だヨ！")
                .setOnlyAlertOnce(true)
                .setAutoCancel(true)
                .build();

        NotificationManager manager = (NotificationManager) getSystemService(this.NOTIFICATION_SERVICE);
        manager.notify(0, notification);

    }
}
