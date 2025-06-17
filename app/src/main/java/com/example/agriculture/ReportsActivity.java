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

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ReportsActivity extends AppCompatActivity {
    private BarChart productionChart;
    private TextView tvTotalRevenue;
    private TextView tvTotalExpenses;
    private TextView tvNetProfit;
    private RecyclerView rvReports;
    private FloatingActionButton fabGenerateReport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports);

        // Initialize views
        initializeViews();
        setupToolbar();
        setupRecyclerView();
        setupChart();
        setupClickListeners();
        
        // Load initial data
        loadReportData();
    }

    private void initializeViews() {
        productionChart = findViewById(R.id.productionChart);
        tvTotalRevenue = findViewById(R.id.tvTotalRevenue);
        tvTotalExpenses = findViewById(R.id.tvTotalExpenses);
        tvNetProfit = findViewById(R.id.tvNetProfit);
        rvReports = findViewById(R.id.rvReports);
        fabGenerateReport = findViewById(R.id.fabGenerateReport);
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
        rvReports.setLayoutManager(new LinearLayoutManager(this));
        // TODO: Set up adapter for reports list
    }

    private void setupChart() {
        // Sample data for the chart
        List<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(0, 100));
        entries.add(new BarEntry(1, 120));
        entries.add(new BarEntry(2, 115));
        entries.add(new BarEntry(3, 130));
        entries.add(new BarEntry(4, 125));

        BarDataSet dataSet = new BarDataSet(entries, "Production");
        dataSet.setColor(Color.BLUE);

        BarData barData = new BarData(dataSet);
        productionChart.setData(barData);
        productionChart.invalidate();
    }

    private void setupClickListeners() {
        fabGenerateReport.setOnClickListener(v -> {
            // TODO: Show dialog to generate new report
            Toast.makeText(this, "Generate new report", Toast.LENGTH_SHORT).show();
        });
    }

    private void loadReportData() {
        // TODO: Load report data from database
        // For now, we'll just set some dummy data
        tvTotalRevenue.setText("Total Revenue: $10,000");
        tvTotalExpenses.setText("Total Expenses: $6,000");
        tvNetProfit.setText("Net Profit: $4,000");
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