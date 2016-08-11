
package jp.mixi.assignment.listview.beg;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * TODO
 * (課題) 課題3で作成したListViewをタップしたら、
 * 次画面に遷移してタップしたアイテムの情報を表示するようにしてください。
 * スクリーンショット
 */
public class BookActivity extends Activity {

    @SuppressWarnings("unused")
    private static final String TAG = BookActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        // TODO:MainActiviyから送られてきたtitleを表示してください。
        TextView bookTitle = (TextView) findViewById(R.id.BookTitle);
        bookTitle.setText(getIntent().getStringExtra("title"));
    }
}
