package com.example.agriculture;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.agriculture.databinding.ActivityDashboardBinding;
import com.google.android.material.navigation.NavigationView;

public class DashboardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = "DashboardActivity";
    private ActivityDashboardBinding binding;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "Creating DashboardActivity");
        
        try {
            binding = ActivityDashboardBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());
            Log.d(TAG, "View binding successful");

            setSupportActionBar(binding.toolbar);
            drawerLayout = binding.drawerLayout;
            navigationView = binding.navView;

            // Set up navigation drawer
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawerLayout, binding.toolbar,
                    R.string.navigation_drawer_open,
                    R.string.navigation_drawer_close);
            drawerLayout.addDrawerListener(toggle);
            toggle.syncState();

            navigationView.setNavigationItemSelectedListener(this);

            // Set default fragment
            if (savedInstanceState == null) {
                Log.d(TAG, "Setting up default fragment");
                try {
                    DashboardFragment dashboardFragment = new DashboardFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, dashboardFragment)
                            .commit();
                    navigationView.setCheckedItem(R.id.nav_dashboard);
                    Log.d(TAG, "Default fragment set successfully");
                } catch (Exception e) {
                    Log.e(TAG, "Error setting up default fragment", e);
                    android.widget.Toast.makeText(this, "Error loading dashboard: " + e.getMessage(), 
                        android.widget.Toast.LENGTH_LONG).show();
                }
            }

            // Update navigation header with user info
            updateNavigationHeader();
        } catch (Exception e) {
            Log.e(TAG, "Error in onCreate", e);
            android.widget.Toast.makeText(this, "Error initializing dashboard: " + e.getMessage(),
                android.widget.Toast.LENGTH_LONG).show();
        }
    }

    private void updateNavigationHeader() {
        try {
            View headerView = navigationView.getHeaderView(0);
            TextView userName = headerView.findViewById(R.id.nav_header_name);
            TextView userEmail = headerView.findViewById(R.id.nav_header_email);

            // TODO: Get user info from SharedPreferences or Database
            userName.setText("John Doe");
            userEmail.setText("john.doe@example.com");
        } catch (Exception e) {
            Log.e(TAG, "Error updating navigation header", e);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        Fragment fragment = null;
        String title = "";

        try {
            if (id == R.id.nav_dashboard) {
                fragment = new DashboardFragment();
                title = "Dashboard";
            } else if (id == R.id.nav_weather) {
                startActivity(new Intent(this, WeatherActivity.class));
            } else if (id == R.id.nav_crops) {
                startActivity(new Intent(this, CropsActivity.class));
            } else if (id == R.id.nav_market) {
                startActivity(new Intent(this, MarketActivity.class));
            } else if (id == R.id.nav_equipment) {
                startActivity(new Intent(this, EquipmentActivity.class));
            } else if (id == R.id.nav_reports) {
                startActivity(new Intent(this, ReportsActivity.class));
            } else if (id == R.id.nav_profile) {
                startActivity(new Intent(this, AccountActivity.class));
            } else if (id == R.id.nav_settings) {
                startActivity(new Intent(this, SettingsActivity.class));
            } else if (id == R.id.nav_help) {
                startActivity(new Intent(this, HelpActivity.class));
            } else if (id == R.id.nav_contact) {
                startActivity(new Intent(this, ContactActivity.class));
            } else if (id == R.id.nav_feedback) {
                startActivity(new Intent(this, UserFeedbackActivity.class));
            } else if (id == R.id.nav_logout) {
                // TODO: Implement logout functionality
                startActivity(new Intent(this, LoginActivity.class));
                finish();
            }

            if (fragment != null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, fragment)
                        .commit();
                getSupportActionBar().setTitle(title);
            }
        } catch (Exception e) {
            Log.e(TAG, "Error in navigation item selection", e);
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
} 