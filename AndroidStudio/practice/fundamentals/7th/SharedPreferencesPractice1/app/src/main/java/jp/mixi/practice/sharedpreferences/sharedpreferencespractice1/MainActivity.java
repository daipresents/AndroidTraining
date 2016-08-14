package jp.mixi.practice.sharedpreferences.sharedpreferencespractice1;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * TODO
 * (実習) SharedPreferencesに値を保存、取得をしてください。
 * アプリケーションを終了しても保存した値を取得できることの確認をしてください。
 * また、保存した値を削除してください。
 */
public class MainActivity extends Activity {

    public SharedPreferences getmPrivatePreferences() {
        return this.mPrivatePreferences;
    }

    private SharedPreferences mPrivatePreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView savedDataStringTextView = (TextView) findViewById(R.id.savedDataString);
        TextView savedDataIntTextView = (TextView) findViewById(R.id.savedDataInt);
        TextView savedDataBooleanTextView = (TextView) findViewById(R.id.savedDataBoolean);
        TextView savedDataLongTextView = (TextView) findViewById(R.id.savedDataLong);
        TextView savedDataFloatTextView = (TextView) findViewById(R.id.savedDataFloat);

        this.mPrivatePreferences = this.getSharedPreferences("person", MODE_PRIVATE);

        // privatePreferencesに値が存在すればその値を表示をしてください。
        if (getmPrivatePreferences().contains("savedDataString")) {
            savedDataStringTextView.setText(getmPrivatePreferences().getString("savedDataString", ""));
        }
        if (getmPrivatePreferences().contains("savedDataInt")) {
            savedDataIntTextView.setText(String.valueOf(getmPrivatePreferences().getInt("savedDataInt", 0)));
        }
        if (getmPrivatePreferences().contains("savedDataBoolean")) {
            savedDataBooleanTextView.setText(String.valueOf(getmPrivatePreferences().getBoolean("savedDataBoolean", false)));
        }
        if (getmPrivatePreferences().contains("savedDataLong")) {
            savedDataLongTextView.setText(String.valueOf(getmPrivatePreferences().getLong("savedDataLong", 100L)));
        }
        if (getmPrivatePreferences().contains("savedDataFloat")) {
            savedDataFloatTextView.setText(String.valueOf(getmPrivatePreferences().getFloat("savedDataFloat", 1.1F)));
        }

        // privatePreferencesにString,int,boolean,long,floatで何らかの値を保存してください。
        Button saveButton = (Button) findViewById(R.id.save);
        saveButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView savedDataStringTextView = (TextView) findViewById(R.id.savedDataString);
                TextView savedDataIntTextView = (TextView) findViewById(R.id.savedDataInt);
                TextView savedDataBooleanTextView = (TextView) findViewById(R.id.savedDataBoolean);
                TextView savedDataLongTextView = (TextView) findViewById(R.id.savedDataLong);
                TextView savedDataFloatTextView = (TextView) findViewById(R.id.savedDataFloat);

                SharedPreferences.Editor editor = getmPrivatePreferences().edit();
                editor.putString("savedDataString", savedDataStringTextView.getText().toString());
                editor.putInt("savedDataInt", Integer.valueOf(savedDataIntTextView.getText().toString()));
                editor.putBoolean("savedDataBoolean", Boolean.valueOf(savedDataBooleanTextView.getText().toString()));
                editor.putLong("savedDataLong", Long.valueOf(savedDataLongTextView.getText().toString()));
                editor.putFloat("savedDataFloat", Float.valueOf(savedDataFloatTextView.getText().toString()));
                editor.commit();
            }
        });

        Button clearButton = (Button) findViewById(R.id.clear);
        clearButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // 内容をクリアする処理を書いてください。
                SharedPreferences.Editor editor = getmPrivatePreferences().edit();
                editor.remove("savedDataString");
                editor.remove("savedDataInt");
                editor.remove("savedDataBoolean");
                editor.remove("savedDataLong");
                editor.remove("savedDataFloat");
                editor.commit();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
