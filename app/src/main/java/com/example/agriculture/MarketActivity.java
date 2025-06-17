package com.example.agriculture;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MarketActivity extends AppCompatActivity {
    private TextView tvMarketStatus;
    private TextView tvLastUpdated;
    private LineChart priceChart;
    private RecyclerView rvPrices;
    private FloatingActionButton fabRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);

        // Initialize views
        initializeViews();
        setupToolbar();
        setupRecyclerView();
        setupChart();
        setupClickListeners();
        
        // Load initial data
        loadMarketData();
    }

    private void initializeViews() {
        tvMarketStatus = findViewById(R.id.tvMarketStatus);
        tvLastUpdated = findViewById(R.id.tvLastUpdated);
        priceChart = findViewById(R.id.priceChart);
        rvPrices = findViewById(R.id.rvPrices);
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
        rvPrices.setLayoutManager(new LinearLayoutManager(this));
        // TODO: Set up adapter for price list
    }

    private void setupChart() {
        // Sample data for the chart
        List<Entry> entries = new ArrayList<>();
        entries.add(new Entry(0, 100));
        entries.add(new Entry(1, 120));
        entries.add(new Entry(2, 115));
        entries.add(new Entry(3, 130));
        entries.add(new Entry(4, 125));

        LineDataSet dataSet = new LineDataSet(entries, "Price Trend");
        dataSet.setColor(Color.BLUE);
        dataSet.setValueTextColor(Color.BLACK);

        LineData lineData = new LineData(dataSet);
        priceChart.setData(lineData);
        priceChart.invalidate();
    }

    private void setupClickListeners() {
        fabRefresh.setOnClickListener(v -> {
            // TODO: Implement market data refresh
            Toast.makeText(this, "Refreshing market data...", Toast.LENGTH_SHORT).show();
            loadMarketData();
        });
    }

    private void loadMarketData() {
        // TODO: Load market data from API
        // For now, we'll just set some dummy data
        tvMarketStatus.setText("Market Status: Open");
        tvLastUpdated.setText("Last Updated: " + java.time.LocalDateTime.now().toString());
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