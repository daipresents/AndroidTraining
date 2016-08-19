package jp.mixi.practice.dialog.med;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * TODO: ダイアログで、はい・いいえ の選択肢を表示する
 * TODO: はい、を選択したら、リストの項目を削除する
 * @author keishin.yokomaku
 *
 */
public class ListItemSelectionDialogFragment extends DialogFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return null;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // AlertDialogはBuilderパターンで生成
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // TODO: ダイアログで、はい・いいえ の選択肢を表示する
        builder.setMessage("Delete?")
                // OKボタン
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // TODO: はい、を選択したら、リストの項目を削除する
                        Log.v(ListItemSelectionDialogFragment.class.getSimpleName(), "OK.");

                        ListView listView = (ListView) getActivity().findViewById(R.id.ListView);
                        String target = (String) listView.getItemAtPosition(getArguments().getInt("position"));
                        ArrayAdapter<String> adapter = (ArrayAdapter<String>) listView.getAdapter();
                        adapter.remove(target);
                    }
                })
                // Cancelボタン
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Log.v(ListItemSelectionDialogFragment.class.getSimpleName(), "Canceled.");
                    }
                });
        // Dialogを作成して返却
        return builder.create();
    }

}