package com.example.agriculture;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CropsActivity extends AppCompatActivity {
    private RecyclerView rvActiveCrops;
    private CalendarView calendarView;
    private TextView tvTotalCrops;
    private TextView tvHarvestedCrops;
    private FloatingActionButton fabAddCrop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crops);

        // Initialize views
        initializeViews();
        setupToolbar();
        setupRecyclerView();
        setupCalendarView();
        setupClickListeners();
        
        // Load initial data
        loadCropData();
    }

    private void initializeViews() {
        rvActiveCrops = findViewById(R.id.rvActiveCrops);
        calendarView = findViewById(R.id.calendarView);
        tvTotalCrops = findViewById(R.id.tvTotalCrops);
        tvHarvestedCrops = findViewById(R.id.tvHarvestedCrops);
        fabAddCrop = findViewById(R.id.fabAddCrop);
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
        rvActiveCrops.setLayoutManager(new LinearLayoutManager(this));
        // TODO: Set up adapter for active crops
    }

    private void setupCalendarView() {
        calendarView.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
            // TODO: Show crop activities for selected date
            String date = String.format("%d-%02d-%02d", year, month + 1, dayOfMonth);
            Toast.makeText(this, "Selected date: " + date, Toast.LENGTH_SHORT).show();
        });
    }

    private void setupClickListeners() {
        fabAddCrop.setOnClickListener(v -> {
            // TODO: Show dialog to add new crop
            Toast.makeText(this, "Add new crop", Toast.LENGTH_SHORT).show();
        });
    }

    private void loadCropData() {
        // TODO: Load crop data from database
        // For now, we'll just set some dummy data
        tvTotalCrops.setText("Total Crops: 5");
        tvHarvestedCrops.setText("Harvested Crops: 2");
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