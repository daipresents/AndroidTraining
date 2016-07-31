package jp.mixi.practice.messagingandnotification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;

/**
 * 1. アイコン、タイトル、詳細メッセージを含む通知を表示してください。=> DONE
 * 2. アイコン、タイトル、詳細メッセージを含む通知を表示し、
 * 通知をタップしたら MainActivity ではない新しい Activity を立ち上げるようにしてください（プロジェクトは実習 1 と同じもので良い）。
 *
 * Created by suino on 2015/02/26.
 */
public class NotificationActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        // TODO ここで通知を表示する
        // Intent の準備。明示的 Intent でも、暗黙的 Intent でもどちらでも構わない
        Intent intent = new Intent(this, FromNotificationActivity.class);
        PendingIntent activityIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        Notification notification = builder
                .setWhen(System.currentTimeMillis())
                .setContentTitle("通知だヨ！")
                .setContentText("通知の詳しい内容をここに書きます。")
                .setSmallIcon(R.drawable.ic_launcher)
                .setContentIntent(activityIntent)
                .build();

        // 直接インスタンス化せず、Context を経由してインスタンスを取得する
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        // 通知の種類に応じて id を割当てることが出来る。
        // id の異なる通知は違うものとして扱われる。
        manager.notify(0, notification);

    }
}
