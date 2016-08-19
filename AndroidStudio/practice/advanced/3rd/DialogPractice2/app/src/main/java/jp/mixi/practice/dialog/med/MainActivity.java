
package jp.mixi.practice.dialog.med;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * TODO
 * (実習) DialogPractice2 のプロジェクトに、Activity と Fragment が配置されています。
 * TODO コメントの指示通りのプログラムを記述してください。
 */
public class MainActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list = (ListView) findViewById(R.id.ListView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1);
        adapter.add("hoge");
        adapter.add("fuga");
        adapter.add("piyo");
        adapter.add("foo");
        adapter.add("bar");
        adapter.add("baz");
        list.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();

        registerForContextMenu(findViewById(R.id.ListView));
    }

    @Override
    protected void onStop() {
        unregisterForContextMenu(findViewById(R.id.ListView));

        super.onStop();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        // TODO: 長押しメニューに、削除・キャンセル、の 2 つの項目を表示する => DONE.
        getMenuInflater().inflate(R.menu.main, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        // TODO: 長押しメニューの、削除、の項目の選択をハンドリングして、確認のためのダイアログを
        // ListItemSelectionDialogFragment を使用して表示する

        // MenuItemからContextMenuInfoを取得し、AdapterContextMenuInfoにキャストします
        ContextMenuInfo menuInfo = item.getMenuInfo();
        AdapterView.AdapterContextMenuInfo adapterInfo = (AdapterView.AdapterContextMenuInfo) menuInfo;

        // AdapterContextMenuInfoから長押ししたリストアイテムのpositionを取得します
        int position = adapterInfo.position;

        DialogFragment fragment = new ListItemSelectionDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        fragment.setArguments(bundle);
        // 引数にFramentManagerとtagを設定します
        fragment.show(getSupportFragmentManager(), "list_item_selection_dialog_fragment");

        return super.onContextItemSelected(item);
    }
}