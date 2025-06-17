package com.example.agriculture;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class WeatherActivity extends AppCompatActivity {
    private TextView tvTemperature;
    private TextView tvWeatherDescription;
    private TextView tvWeatherAlert;
    private RecyclerView rvForecast;
    private FloatingActionButton fabRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        // Initialize views
        initializeViews();
        setupToolbar();
        setupRecyclerView();
        setupClickListeners();
        
        // Load initial weather data
        loadWeatherData();
    }

    private void initializeViews() {
        tvTemperature = findViewById(R.id.tvTemperature);
        tvWeatherDescription = findViewById(R.id.tvWeatherDescription);
        tvWeatherAlert = findViewById(R.id.tvWeatherAlert);
        rvForecast = findViewById(R.id.rvForecast);
        fabRefresh = findViewById(R.id.fabRefresh);
    }

    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    private void setupRecyclerView() {
        rvForecast.setLayoutManager(new LinearLayoutManager(this));
        // TODO: Set up adapter for forecast items
    }

    private void setupClickListeners() {
        fabRefresh.setOnClickListener(v -> {
            // TODO: Implement weather data refresh
            Toast.makeText(this, "Refreshing weather data...", Toast.LENGTH_SHORT).show();
            loadWeatherData();
        });
    }

    private void loadWeatherData() {
        // TODO: Implement weather data loading from API
        // For now, we'll just set some dummy data
        tvTemperature.setText("25°C");
        tvWeatherDescription.setText("Sunny");
        tvWeatherAlert.setText("No active weather alerts");
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