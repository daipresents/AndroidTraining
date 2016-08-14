package jp.mixi.assignment.serializable.beg;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private Activity mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainActivity = this;

        // 1. NetworkClientからgetUserでJSONのデータを取得し、取得したデータを適切なクラスを作成し、当てはめてください。
        NetworkClient client = new NetworkClient();
        String user = client.getUser(123);
        String friends = client.getFriends();

        Log.v("user: ", user);
        Log.v("friends: ", friends);

        User userObj = getUser(user);

        TextView textView = (TextView) findViewById(R.id.userId);
        textView.setText(userObj.getUserId());

        // 2. さらにgetFriendsで友人の名前の一覧をListViewで表示してください。
        ArrayList<User> friendList = new ArrayList<User>();

        try {
            JSONArray friendsJson = new JSONArray(friends);
            for (int i = 0; i < friendsJson.length(); i++) {
                JSONObject friendJson = (JSONObject) friendsJson.get(i);
                User friend = getUser(friendJson.toString());
                friendList.add(friend);
            }

        } catch (Exception e) {
             Log.v("ERROR: ", e.getMessage());
        }


        ListView listView = (ListView) findViewById(R.id.ListView);
        ArrayAdapter<User> adapter = new ArrayAdapter<User>(mainActivity,
                android.R.layout.simple_list_item_1, friendList);
        listView.setAdapter(adapter);

        // タップした時の動作を定義する
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(mainActivity, DetailActivity.class);
                User user = (User) parent.getItemAtPosition(position);
                intent.putExtra("friend", user);

                startActivity(intent);

            }
        });
        // 3. タップした友人の全情報をDetailActivityで表示してください。

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private User getUser(String userJsonString){
        User user = new User();

        try {
            JSONObject userJson = new JSONObject(userJsonString);
            user.setUserId(userJson.getString("id"));
            user.setName(userJson.getString("name"));
            if (!userJson.isNull("age")) {
                user.setAge(userJson.getInt("age"));
            }
            if (!userJson.isNull("keyword")) {
                user.setKeyword("keyword");
            }

            user.setYear(userJson.getJSONObject("joinDate").getInt("year"));
            user.setYear(userJson.getJSONObject("joinDate").getInt("month"));
            user.setYear(userJson.getJSONObject("joinDate").getInt("date"));

            user.setPostedTime(userJson.getJSONObject("status").getString("postedTime"));
            user.setText(userJson.getJSONObject("status").getString("text"));

            return user;

        } catch (Exception e) {
            Log.v("ERROR: ", e.getMessage());
            return null;
        }
    }
}
