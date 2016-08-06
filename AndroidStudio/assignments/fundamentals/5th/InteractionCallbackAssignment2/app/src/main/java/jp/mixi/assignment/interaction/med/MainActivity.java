
package jp.mixi.assignment.interaction.med;

import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.widget.TextView;

/**
 * TODO
 * (課題) TextWatcher を利用して、EditText に入力された文字数をカウントする TextView を作成してください。
 */
public class MainActivity extends Activity {

    private TextWatcher mTextWatcher = new TextWatcher() {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            TextView textEdit = (TextView) findViewById(R.id.textEdit);
            CharSequence targetText = textEdit.getText();

            if (textEdit != null) {
                TextView countView = (TextView) findViewById(R.id.countView);
                countView.setText(String.valueOf(targetText.length()));
            }

        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        @Override
        public void afterTextChanged(Editable s) {}
    };

    @Override
    protected void onStart() {
        super.onStart();

        TextView textEdit = (TextView) findViewById(R.id.textEdit);
        textEdit.addTextChangedListener(mTextWatcher);
    }

    @Override
    protected void onStop() {
        super.onStop();
        TextView textEdit = (TextView) findViewById(R.id.textEdit);
        textEdit.removeTextChangedListener(mTextWatcher);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
