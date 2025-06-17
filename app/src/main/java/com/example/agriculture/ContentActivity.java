package com.example.agriculture;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.card.MaterialCardView;

/**
 * Main content activity that displays various farming resources and information
 * Organized into different categories for easy access
 */
public class ContentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        // Set up toolbar
        setupToolbar();
        
        // Set up click listeners for content cards
        setupClickListeners();
    }

    /**
     * Sets up the toolbar with back navigation
     */
    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle("Farm Resources");
        }
    }

    /**
     * Sets up click listeners for all content cards
     * Each card navigates to its respective detailed activity
     */
    private void setupClickListeners() {
        // Soil Health Card
        MaterialCardView soilHealthCard = findViewById(R.id.card_soil_health);
        soilHealthCard.setOnClickListener(v -> {
            startActivity(new Intent(this, SoilHealthActivity.class));
        });

        // Weather Card
        MaterialCardView weatherCard = findViewById(R.id.card_weather);
        weatherCard.setOnClickListener(v -> {
            startActivity(new Intent(this, WeatherActivity.class));
        });

        // Market Prices Card
        MaterialCardView marketCard = findViewById(R.id.card_market);
        marketCard.setOnClickListener(v -> {
            startActivity(new Intent(this, MarketActivity.class));
        });

        // Agronomy Tips Card
        MaterialCardView agronomyCard = findViewById(R.id.card_agronomy);
        agronomyCard.setOnClickListener(v -> {
            startActivity(new Intent(this, AgronomyActivity.class));
        });

        // Pest & Disease Card
        MaterialCardView pestCard = findViewById(R.id.card_pest);
        pestCard.setOnClickListener(v -> {
            startActivity(new Intent(this, PestDiseaseActivity.class));
        });

        // Fertilizer Info Card
        MaterialCardView fertilizerCard = findViewById(R.id.card_fertilizer);
        fertilizerCard.setOnClickListener(v -> {
            startActivity(new Intent(this, FertilizerActivity.class));
        });

        // Government Policy Card
        MaterialCardView policyCard = findViewById(R.id.card_policy);
        policyCard.setOnClickListener(v -> {
            startActivity(new Intent(this, PolicyActivity.class));
        });

        // Nearby Services Card
        MaterialCardView servicesCard = findViewById(R.id.card_services);
        servicesCard.setOnClickListener(v -> {
            startActivity(new Intent(this, ServicesActivity.class));
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