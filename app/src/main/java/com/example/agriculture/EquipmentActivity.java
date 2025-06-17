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

public class EquipmentActivity extends AppCompatActivity {
    private TextView tvTotalEquipment;
    private TextView tvMaintenanceDue;
    private RecyclerView rvActiveEquipment;
    private RecyclerView rvMaintenanceSchedule;
    private FloatingActionButton fabAddEquipment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipment);

        // Initialize views
        initializeViews();
        setupToolbar();
        setupRecyclerViews();
        setupClickListeners();
        
        // Load initial data
        loadEquipmentData();
    }

    private void initializeViews() {
        tvTotalEquipment = findViewById(R.id.tvTotalEquipment);
        tvMaintenanceDue = findViewById(R.id.tvMaintenanceDue);
        rvActiveEquipment = findViewById(R.id.rvActiveEquipment);
        rvMaintenanceSchedule = findViewById(R.id.rvMaintenanceSchedule);
        fabAddEquipment = findViewById(R.id.fabAddEquipment);
    }

    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    private void setupRecyclerViews() {
        rvActiveEquipment.setLayoutManager(new LinearLayoutManager(this));
        rvMaintenanceSchedule.setLayoutManager(new LinearLayoutManager(this));
        // TODO: Set up adapters for equipment and maintenance lists
    }

    private void setupClickListeners() {
        fabAddEquipment.setOnClickListener(v -> {
            // TODO: Show dialog to add new equipment
            Toast.makeText(this, "Add new equipment", Toast.LENGTH_SHORT).show();
        });
    }

    private void loadEquipmentData() {
        // TODO: Load equipment data from database
        // For now, we'll just set some dummy data
        tvTotalEquipment.setText("Total Equipment: 5");
        tvMaintenanceDue.setText("Maintenance Due: 2");
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