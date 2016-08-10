
package jp.mixi.practice.listview.beg;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

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

        ListView listView = (ListView) findViewById(R.id.ListView);
        listView.setAdapter(new CustomListItemAdapter(context, list));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str = (String) parent.getItemAtPosition(position);
                Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
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
