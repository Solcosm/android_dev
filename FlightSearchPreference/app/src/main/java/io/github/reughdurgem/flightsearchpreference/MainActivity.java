package io.github.reughdurgem.flightsearchpreference;

import android.content.SharedPreferences;
import android.preference.ListPreference;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

/*
NOTE: Put XML preference file in /res/xml
*/

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Set Title
        setTitle("My Preferences");
        //Display fragment as main content
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new SettingsFragment())
                .commit();
        //Access Preferences of current context (aka MainActivity)
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
    }
}