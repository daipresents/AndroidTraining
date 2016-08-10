
package jp.mixi.practice.listview.beg;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * TODO
 * (実習) カスタマイズしたリストアイテムを表示するで説明したプロジェクトを写経して実行してください。
 * 余裕がある場合はViewの再利用についてについても試してみて下さい。
 * 説明したプロジェクトはAndroidTraining/projects/fundamentals/6th/CustomListItemSampleにあります。
 */
public class CustomListItemAdapter extends ArrayAdapter<String> {

    private LayoutInflater mLayoutInflater;

    public CustomListItemAdapter (Context context, List<String> objects){
        super(context, 0, objects);
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View view = null;

        if (convertView == null){
            view = mLayoutInflater.inflate(R.layout.custom_list_item, parent, false);

            String item = getItem(position);

            ViewHolder holder = new ViewHolder();
            holder.title = (TextView) view.findViewById(R.id.TitleText);
            holder.title.setText("Title:" + item);
            holder.subTitle = (TextView) view.findViewById(R.id.SubTitleText);
            holder.subTitle.setText("SubTitle:" + item);
            view.setTag(holder);

        } else {
            view = convertView;
        }

        return view;
    }
}
