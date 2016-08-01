package jp.mixi.assignment.messagingandnotification;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ShowToastActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_TOAST = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_toast);

        View button = findViewById(R.id.toastButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText textBox = (EditText) findViewById(R.id.toastTextBox);
                Intent newIntent = new Intent();
                newIntent.putExtra("inputData", textBox.getText().toString());
                setResult(RESULT_OK, newIntent);
                finish();
            }
        });
    }


}
