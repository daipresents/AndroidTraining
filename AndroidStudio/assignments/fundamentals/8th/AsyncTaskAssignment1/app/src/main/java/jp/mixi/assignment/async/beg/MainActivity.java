package jp.mixi.assignment.async.beg;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * TODO
 * (課題) SharedPreferences にデータを書き込むための MyIntentService を作成してください。
 */
public class MainActivity extends Activity {

    Activity mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainActivity = this;

        // TODO: それぞれ、ボタンクリックに反応して、SharedPreferences からの読み込みと保存の処理を実装すること。
        Button saveButton = (Button) findViewById(R.id.SaveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(MainActivity.class.toString(), "Save button is clicked");

                // TODO: 保存、読み込みのためのオブジェクトは、 PreferencesEntity クラスを使用する。
                PreferencesEntity data = new PreferencesEntity(new SimpleDateFormat().format(Calendar.getInstance().getTime()), Calendar.getInstance().get(Calendar.SECOND), true);
                Intent intent = new Intent(mainActivity, MyIntentService.class);
                intent.putExtra("data", data);
                startService(intent);
            }
        });

        Button loadButton = (Button) findViewById(R.id.LoadButton);
        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(MainActivity.class.toString(), "Load button is clicked");
                // TODO: 読み込みが終わったら、Toast で、PreferencesEntity が持っているデータのどれか好きなものを表示する
                SharedPreferences sp = getSharedPreferences("a-f-8-sample", MODE_PRIVATE);
                Toast.makeText(mainActivity, sp.getString("stringData", ""), Toast.LENGTH_SHORT).show();

            }
        });

    }
}