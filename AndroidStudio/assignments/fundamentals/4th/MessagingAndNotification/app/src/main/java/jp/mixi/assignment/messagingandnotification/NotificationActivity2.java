package jp.mixi.assignment.messagingandnotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.NotificationCompat;

/**
 * TODO アイコン、タイトル、詳細メッセージを含む通知を表示してください。
 * 通知をタップしたら、指定した ACTION を受け取ることが出来る Activity を実行するようにしてください。
 * 通知をタップすると、このような画面が表示されます。
 * この画面では、どちらがどの画面に対応しているのかが分からないので、
 * AndroidManifest を編集して分かりやすい表示にしてください
 * Created by suino on 2015/02/26.
 */
public class NotificationActivity2 extends ActionBarActivity {
    public static final String ACITON_VIEW_MY_OWN = "jp.mixi.assignment.messagingandnotification.android.intent.action.VIEW_MY_OWN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification2);

        // TODO intent には、ACTION_VIEW_MY_OWN の action をセットするだけにしておく
        Intent intent = new Intent();
        intent.setAction(ACITON_VIEW_MY_OWN);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        Notification notification = builder
                // 通知の日時
                .setWhen(System.currentTimeMillis())
                // 通知のタイトル
                .setContentTitle("タイトルだよ2")
                // 通知の詳細メッセージ
                .setContentText("しょうさいめっせーじだよ2")
                // 通知のアイコン
                .setSmallIcon(R.drawable.ic_launcher)
                .setTicker("通知だヨ！2")
                .setContentIntent(pendingIntent)
                .setOnlyAlertOnce(true)
                .setAutoCancel(true)
                .build();

        // TODO ここで通知を表示する
        NotificationManager manager = (NotificationManager) getSystemService(this.NOTIFICATION_SERVICE);
        manager.notify(0, notification);

        // TODO 通知をタップした時に、複数の選択肢が表示されるが、どれがどの Activity に対応しているかがわかりづらくなっているので、AndroidManifest を編集して表示をわかりやすくする
    }
}
