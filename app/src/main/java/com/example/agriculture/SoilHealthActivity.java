package com.example.agriculture;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class SoilHealthActivity extends AppCompatActivity {
    private RecyclerView rvTestingCenters;
    private TestingCenterAdapter testingCenterAdapter;
    private List<TestingCenter> testingCenters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soil_health);

        // Setup toolbar
        setupToolbar();

        // Initialize views
        rvTestingCenters = findViewById(R.id.rvTestingCenters);
        FloatingActionButton fabScheduleTest = findViewById(R.id.fabScheduleTest);

        // Setup RecyclerView
        setupRecyclerView();

        // Setup click listeners
        setupClickListeners(fabScheduleTest);
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
        testingCenters = new ArrayList<>();
        // Add sample testing centers
        testingCenters.add(new TestingCenter("Agricultural Research Center", "123 Main St", "9:00 AM - 5:00 PM", "₹500"));
        testingCenters.add(new TestingCenter("Soil Testing Lab", "456 Farm Rd", "8:00 AM - 4:00 PM", "₹400"));
        testingCenters.add(new TestingCenter("Government Soil Lab", "789 Agri Circle", "10:00 AM - 6:00 PM", "₹300"));

        testingCenterAdapter = new TestingCenterAdapter(testingCenters);
        rvTestingCenters.setLayoutManager(new LinearLayoutManager(this));
        rvTestingCenters.setAdapter(testingCenterAdapter);
    }

    private void setupClickListeners(FloatingActionButton fabScheduleTest) {
        fabScheduleTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Implement test scheduling functionality
                Toast.makeText(SoilHealthActivity.this, "Schedule Test feature coming soon!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // Testing Center data class
    private static class TestingCenter {
        private String name;
        private String address;
        private String hours;
        private String price;

        public TestingCenter(String name, String address, String hours, String price) {
            this.name = name;
            this.address = address;
            this.hours = hours;
            this.price = price;
        }

        public String getName() { return name; }
        public String getAddress() { return address; }
        public String getHours() { return hours; }
        public String getPrice() { return price; }
    }

    // Testing Center Adapter
    private class TestingCenterAdapter extends RecyclerView.Adapter<TestingCenterAdapter.ViewHolder> {
        private List<TestingCenter> centers;

        public TestingCenterAdapter(List<TestingCenter> centers) {
            this.centers = centers;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull android.view.ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.item_testing_center, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            TestingCenter center = centers.get(position);
            holder.tvName.setText(center.getName());
            holder.tvAddress.setText(center.getAddress());
            holder.tvHours.setText(center.getHours());
            holder.tvPrice.setText(center.getPrice());
        }

        @Override
        public int getItemCount() {
            return centers.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            android.widget.TextView tvName, tvAddress, tvHours, tvPrice;

            ViewHolder(View itemView) {
                super(itemView);
                tvName = itemView.findViewById(R.id.tvName);
                tvAddress = itemView.findViewById(R.id.tvAddress);
                tvHours = itemView.findViewById(R.id.tvHours);
                tvPrice = itemView.findViewById(R.id.tvPrice);
            }
        }
    }
} 