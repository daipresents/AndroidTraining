package jp.mixi.assignment.sharedpreferences.sharedpreferencesassignment;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * TODO
 * (課題) SharedPreferencesを利用してアプリケーションを終了しても保存されるカウンターを作成してください。
 * また、そのカウントを画面上に表示してください。その際、onSharedPreferenceChanged内から変更を行なってください。
 */
public class MainActivity extends Activity implements SharedPreferences.OnSharedPreferenceChangeListener {

    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.sp = getSharedPreferences("count", MODE_PRIVATE);
        sp.registerOnSharedPreferenceChangeListener(this);

        TextView countView = (TextView) findViewById(R.id.count);
        if (sp.contains("count")) {
            countView.setText(String.valueOf(sp.getInt("count", 0)));
        } else {
            countView.setText("0");
        }

        Button button = (Button) findViewById(R.id.countup);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView countView = (TextView) findViewById(R.id.count);
                int count = Integer.parseInt(countView.getText().toString()) + 1;
                countView.setText(String.valueOf(count));

                SharedPreferences.Editor editor = sp.edit();
                editor.putInt("count", count);
                editor.commit();
                Log.v("count up.", String.valueOf(count));
            }
        });
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if ("count".equals(key)) {
            Log.v("committed.", String.valueOf(sp.getInt("count", 0)));

        } else {
            Log.v("the key is ", key);
        }
    }

    protected void onDestroy(){
        getSharedPreferences("count", MODE_PRIVATE).unregisterOnSharedPreferenceChangeListener(this);
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
