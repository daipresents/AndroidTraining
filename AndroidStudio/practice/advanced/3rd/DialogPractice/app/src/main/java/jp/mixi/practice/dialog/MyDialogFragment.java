package jp.mixi.practice.dialog;

/**
 * Created by daipr on 2016/08/20.
 */


import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Dialogを使用して、コンテンツ領域に独自レイアウトは表示するサンプルです。
 */
public class MyDialogFragment extends DialogFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // 独自のレイアウトをコンテンツ領域表示する場合、ここでViewをinfrateして返却する
        return inflater.inflate(R.layout.dialog, container, false);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Dialogを生成
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        // タイトルを設定
        dialog.setTitle(R.string.paractice);
        return dialog;
    }

}
