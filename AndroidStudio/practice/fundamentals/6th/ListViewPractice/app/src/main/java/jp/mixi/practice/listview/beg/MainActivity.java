
package jp.mixi.practice.listview.beg;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * TODO
 * (実習) カスタマイズしたリストアイテムを表示するで説明したプロジェクトを写経して実行してください。
 * 余裕がある場合はViewの再利用についてについても試してみて下さい。
 * 説明したプロジェクトはAndroidTraining/projects/fundamentals/6th/CustomListItemSampleにあります。
 *
 * TODO
 * (実習) 実習1の画面にボタンを配置し、ボタンをタップしたらListViewの先頭を表示するようにして下さい。
 ヒント:ListView には smoothScrollToPosition メソッドがあります。
 スクリーンショット
 */
public class MainActivity extends Activity {

    Activity context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         context = this;

        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 20; i++){
            list.add("hoge" + i);
        }

        final ListView listView = (ListView) findViewById(R.id.ListView);
        listView.setAdapter(new CustomListItemAdapter(context, list));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str = (String) parent.getItemAtPosition(position);
                Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
            }
        });

        View buttonForTop = findViewById(R.id.buttonForTop);
        buttonForTop.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                listView.smoothScrollToPosition(0);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

}
