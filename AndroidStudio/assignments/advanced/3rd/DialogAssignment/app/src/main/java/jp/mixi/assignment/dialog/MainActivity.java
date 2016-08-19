
package jp.mixi.assignment.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;

import java.io.Serializable;
import java.util.zip.Inflater;

public class MainActivity extends FragmentActivity implements Serializable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.show_assignmentdialog).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                showAssignmentDialog();
            }
        });
    }

    private void showAssignmentDialog() {
        // TODO:ダイアログを表示する処理を実装してください
        DialogFragment fragment = new AssignmentDialogFragment();
        fragment.show(getSupportFragmentManager(), "alert_dialog_fragment");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    // TODO:独自DialogFragmentを実装してください
    // TODO:コンテンツ領域にはEditTextを配置した独自レイアウトを使用してください。また、そのためのレイアウトxmlを作成してください。
    public static class AssignmentDialogFragment extends DialogFragment {

        View layout;

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return null;
        }

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {

            LayoutInflater inflater = (LayoutInflater)getActivity().getSystemService(LAYOUT_INFLATER_SERVICE);
            this.layout = inflater.inflate(R.layout.dialog, (ViewGroup) getActivity().findViewById(R.id.dialog_layout));

            // TODO: ダイアログで、はい・いいえ の選択肢を表示する
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setView(layout);
            builder.setMessage("Input your name.")
                    // OKボタン
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // TODO: OKボタンを押した時は入力した情報を SharedPreferences に保存するように実装してください。
                            Log.v(AssignmentDialogFragment.class.getSimpleName(), "OK.");
                            EditText editText = (EditText) layout.findViewById(R.id.yourName);
                            String yourName = editText.getText().toString();

                            SharedPreferences sp = getActivity().getSharedPreferences("sample", MODE_PRIVATE);
                            SharedPreferences.Editor editor = sp.edit();
                            editor.putString("name", yourName);
                            editor.commit();

                            Log.v(MainActivity.class.getSimpleName(), "name: " + yourName);

                        }
                    })
                    // Cancelボタン
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Log.v(AssignmentDialogFragment.class.getSimpleName(), "Canceled.");
                        }
                    });
            // Dialogを作成して返却
            return builder.create();
        }

    }
}
