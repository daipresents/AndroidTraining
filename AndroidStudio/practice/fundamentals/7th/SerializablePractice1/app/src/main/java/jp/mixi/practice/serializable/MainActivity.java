package jp.mixi.practice.serializable;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * TODO
 * （実習）JSONの文字列をパースし、画面に表示してください。
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NetworkClient client = new NetworkClient();
        String user = client.getUser(123);

        Log.v("=1=", user);

        // 1. 取得したデータをUserクラスにマッピングしてください。
        User userObj = new User();
        try {
            JSONObject json = new JSONObject(user);
            userObj.setId(json.getInt("id"));
            userObj.setName(json.getString("name"));
            if (!json.isNull("age")){
                userObj.setAge(json.getInt("age"));
            }
            if (!json.isNull("keyword")) {
                userObj.setKeyword(json.getString("keyword"));
            }

            JSONObject statusJson = (JSONObject) json.get("status");
            Log.v("=2=", statusJson.toString());

            User.Status status = new User.Status();
            status.setText(statusJson.getString("text"));

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            status.setPostedDate(sdf.parse(statusJson.getString("postedTime")));

            userObj.setStatus(status);

        }catch (Exception e){
            Log.v("EXCEPTION", "Exception occurred at creating user object. " + e.getMessage());
        }

        // 各項目を画面に表示してください
        TextView id = (TextView) findViewById(R.id.userId);
        id.setText(String.valueOf(userObj.getId()));

        TextView name = (TextView) findViewById(R.id.userName);
        name.setText(userObj.getName());

        TextView age = (TextView) findViewById(R.id.userAge);
        age.setText(String.valueOf(userObj.getAge()));

        if (userObj.getKeyword() != null) {
            TextView keyword = (TextView) findViewById(R.id.userKeyword);
            keyword.setText(userObj.getKeyword());
        }
        if (userObj.getStatus() != null) {
            TextView status = (TextView) findViewById(R.id.userStatusText);
            status.setText(userObj.getStatus().getText() + ":" + userObj.getStatus().getPostedDate().toString());
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}

