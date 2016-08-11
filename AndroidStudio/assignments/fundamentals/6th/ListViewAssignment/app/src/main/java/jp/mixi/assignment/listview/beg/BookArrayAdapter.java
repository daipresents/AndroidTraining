package jp.mixi.assignment.listview.beg;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by daipr on 2016/08/11.
 */
public class BookArrayAdapter extends ArrayAdapter<Book> {
    private LayoutInflater mLayoutInflater;

    public BookArrayAdapter(Context context, List<Book> objects) {
        // 第2引数はtextViewResourceIdとされていますが、カスタムリストアイテムを使用する場合は特に意識する必要のない引数です
        super(context, 0, objects);
        // レイアウト生成に使用するインフレーター
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = null;

        // ListViewに表示する分のレイアウトが生成されていない場合レイアウトを作成する
        if (convertView == null) {
            // レイアウトファイルからViewを生成する
            view = mLayoutInflater.inflate(R.layout.list_item_book, parent, false);

            // リストアイテムに対応するデータを取得する
            Book book = getItem(position);

            // 各Viewに表示する情報を設定
            TextView title = (TextView) view.findViewById(R.id.Title);
            title.setText(book.getTitle());
            TextView price = (TextView) view.findViewById(R.id.Price);
            price.setText(String.valueOf(book.getPrice()));
            TextView publisher = (TextView) view.findViewById(R.id.Publisher);
            publisher.setText(book.getPublisher());

        } else {
            // レイアウトが存在する場合は再利用する
            view = convertView;
        }
        // 一度作成したレイアウトの表示データを変更しないことにより、再利用されたデータがどこに表示されるかを確認する
        return view;
    }
}
