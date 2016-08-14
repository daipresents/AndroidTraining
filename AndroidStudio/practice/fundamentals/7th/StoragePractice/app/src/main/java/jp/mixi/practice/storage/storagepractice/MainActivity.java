package jp.mixi.practice.storage.storagepractice;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * TODO
 * (実習) 内部ストレージ、外部ストレージにそれぞれファイルを保存してください。
 * 内部ストレージにはテキストファイル、外部ストレージには画像ファイルを保存してください。
 * 外部ストレージに保存されたファイルをファイラーなどで参照してみてください。
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Internal
        Button internalFileSaveButton = (Button) findViewById(R.id.internalFileSave);
        internalFileSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String FILENAME = "com.daipresents.internal";
                EditText editTextInternal = (EditText) findViewById(R.id.text);

                FileOutputStream fos = null;
                try {

                    fos = openFileOutput(FILENAME, MODE_PRIVATE);
                    fos.write(editTextInternal.getText().toString().getBytes());

                } catch (IOException e) {
                    Log.v("ERROR: ", e.getMessage());
                } finally {
                    try {
                        if (fos != null) {
                            fos.close();
                        }
                    } catch (IOException e) {
                        Log.v("ERROR: ", e.getMessage());
                    }
                }

                BufferedReader reader = null;
                try {
                    reader = new BufferedReader(new InputStreamReader(openFileInput(FILENAME)));
                    Log.v("READ_FILE: ", reader.readLine());

                } catch (IOException e) {
                    Log.v("ERROR: ", e.getMessage());
                } finally {
                    try {
                        if (reader != null) {
                            reader.close();
                        }
                    } catch (IOException e) {
                        Log.v("ERROR: ", e.getMessage());
                    }
                }
            }
        });

        //External
        Button externalFileSaveButton = (Button) findViewById(R.id.externalFileSave);
        externalFileSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("External Strage Path:", getExternalFilesDir(Environment.DIRECTORY_PICTURES).getAbsolutePath());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
