package com.example.agriculture;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Switch;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class SettingsActivity extends AppCompatActivity {
    private Switch notificationsSwitch;
    private Switch darkModeSwitch;
    private Switch locationSwitch;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Settings");

        preferences = getSharedPreferences("AppSettings", MODE_PRIVATE);
        
        notificationsSwitch = findViewById(R.id.notificationsSwitch);
        darkModeSwitch = findViewById(R.id.darkModeSwitch);
        locationSwitch = findViewById(R.id.locationSwitch);

        // Load saved preferences
        notificationsSwitch.setChecked(preferences.getBoolean("notifications", true));
        darkModeSwitch.setChecked(preferences.getBoolean("darkMode", false));
        locationSwitch.setChecked(preferences.getBoolean("location", true));

        // Set up switch listeners
        notificationsSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            preferences.edit().putBoolean("notifications", isChecked).apply();
        });

        darkModeSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            preferences.edit().putBoolean("darkMode", isChecked).apply();
            // TODO: Implement dark mode toggle
        });

        locationSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            preferences.edit().putBoolean("location", isChecked).apply();
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
} 