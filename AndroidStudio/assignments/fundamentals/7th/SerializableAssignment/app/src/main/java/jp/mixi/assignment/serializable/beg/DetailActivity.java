package jp.mixi.assignment.serializable.beg;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class DetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        User user = (User) getIntent().getSerializableExtra("friend");

        TextView friendUserId = (TextView) findViewById(R.id.friendUserId);
        friendUserId.setText(user.getUserId());

        TextView friendName = (TextView) findViewById(R.id.friendName);
        friendName.setText(user.getName());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
