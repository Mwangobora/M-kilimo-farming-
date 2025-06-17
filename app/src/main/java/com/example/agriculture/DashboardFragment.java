package com.example.agriculture;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.agriculture.databinding.FragmentDashboardBinding;

public class DashboardFragment extends Fragment {
    private static final String TAG = "DashboardFragment";
    private FragmentDashboardBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        try {
            Log.d(TAG, "Creating dashboard view");
            binding = FragmentDashboardBinding.inflate(inflater, container, false);
            return binding.getRoot();
        } catch (Exception e) {
            Log.e(TAG, "Error creating dashboard view", e);
            if (getContext() != null) {
                android.widget.Toast.makeText(getContext(),
                        "Error loading dashboard view: " + e.getMessage(),
                        android.widget.Toast.LENGTH_LONG).show();
            }
            TextView errorView = new TextView(getContext());
            errorView.setText("Error loading dashboard");
            return errorView;
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, "View created, setting up click listeners");

        try {
            // Get card views
            CardView cardWeather = view.findViewById(R.id.card_weather);
            CardView cardCrops = view.findViewById(R.id.card_crops);
            CardView cardMarket = view.findViewById(R.id.card_market);
            CardView cardEquipment = view.findViewById(R.id.card_equipment);
            CardView cardReports = view.findViewById(R.id.card_reports);
            CardView cardFeedback = view.findViewById(R.id.card_feedback);
            CardView cardContent = view.findViewById(R.id.card_content);

            // Set click listeners
            if (cardWeather != null) {
                cardWeather.setOnClickListener(v -> {
                    Log.d(TAG, "Weather card clicked");
                    startActivity(new Intent(getActivity(), WeatherActivity.class));
                });
            }

            if (cardCrops != null) {
                cardCrops.setOnClickListener(v -> {
                    Log.d(TAG, "Crops card clicked");
                    startActivity(new Intent(getActivity(), CropsActivity.class));
                });
            }

            if (cardMarket != null) {
                cardMarket.setOnClickListener(v -> {
                    Log.d(TAG, "Market card clicked");
                    startActivity(new Intent(getActivity(), MarketActivity.class));
                });
            }

            if (cardEquipment != null) {
                cardEquipment.setOnClickListener(v -> {
                    Log.d(TAG, "Equipment card clicked");
                    startActivity(new Intent(getActivity(), EquipmentActivity.class));
                });
            }

            if (cardReports != null) {
                cardReports.setOnClickListener(v -> {
                    Log.d(TAG, "Reports card clicked");
                    startActivity(new Intent(getActivity(), ReportsActivity.class));
                });
            }

            if (cardFeedback != null) {
                cardFeedback.setOnClickListener(v -> {
                    Log.d(TAG, "Feedback card clicked");
                    startActivity(new Intent(getActivity(), UserFeedbackActivity.class));
                });
            }

            if (cardContent != null) {
                cardContent.setOnClickListener(v -> {
                    Log.d(TAG, "Content card clicked");
                    startActivity(new Intent(getActivity(), ContentActivity.class));
                });
            }
        } catch (Exception e) {
            Log.e(TAG, "Error setting up click listeners", e);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
