package com.mjm.savepreference;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //save value in SharedPreference
        Preference.save("key1", "your value");
        Preference.save("key2", "value2");
        Preference.save("key3", "value3");
        Preference.save("key4", "value4");
        Preference.save("key5", "value5");
        Preference.save("key6", "value6");
        Preference.save("key7", "value7");
        Preference.save("key8", "value8");
        Preference.save("key9", "value9");
        Preference.save("key10", "value10");

        //get value from SharedPreference
        String a = Preference.getPreferences().getString("key", "default value");

        Preference.clear("key1");

        Preference.clear(new String[]{"key2", "key5"});

        Preference.clear(new String[]{"key3", "key4"}, "key6");

        Preference.clear(new String[]{"key8", "key7"}, new String[]{"key6", "key10"});

        Preference.clear();
    }

}
