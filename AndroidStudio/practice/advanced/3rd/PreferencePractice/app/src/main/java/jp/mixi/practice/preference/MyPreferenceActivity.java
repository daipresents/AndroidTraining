package jp.mixi.practice.preference;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.PreferenceScreen;
import android.util.Log;

/**
 * TODO
 * (実習) 下記の画像のような設定画面を実装してください。 => DONE.
 「自動同期の間隔」は「連絡先の同期設定」がONの場合のみ有効にしてください。 => DONE
 「自動同期の間隔」は変更内容を Summary に反映させてください。
 */
public class MyPreferenceActivity extends android.preference.PreferenceActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        Log.v(MyPreferenceActivity.class.getSimpleName(), "key: " + key);

        if ("pref_cat_address_sync_setting".equals(key)) {
            ListPreference timingList = (ListPreference) findPreference("pref_cat_address_sync_sub_timing_list");
            CheckBoxPreference addressSync = (CheckBoxPreference) findPreference("pref_cat_address_sync_setting");
            if (addressSync.isChecked()){
                Log.v(MyPreferenceActivity.class.getSimpleName(), "checked.");
                timingList.setEnabled(true);
            }else{
                Log.v(MyPreferenceActivity.class.getSimpleName(), "un checked.");
                timingList.setEnabled(false);
            }
            //timingList.setSummary(timingList.getv.getText());
        } else if ("pref_cat_address_sync_sub_timing_list".equals(key)){
            ListPreference timingList = (ListPreference) findPreference("pref_cat_address_sync_sub_timing_list");
            timingList.setSummary("Changed!");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        getPreferenceScreen().getSharedPreferences()
                .registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        getPreferenceScreen().getSharedPreferences()
                .unregisterOnSharedPreferenceChangeListener(this);
    }
}
