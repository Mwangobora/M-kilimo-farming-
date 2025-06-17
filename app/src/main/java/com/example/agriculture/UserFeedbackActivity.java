package com.example.agriculture;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class UserFeedbackActivity extends AppCompatActivity {
    private EditText feedbackInput;
    private RatingBar ratingBar;
    private Button submitButton;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_feedback);

        dbHelper = new DatabaseHelper(this);
        
        feedbackInput = findViewById(R.id.feedbackInput);
        ratingBar = findViewById(R.id.ratingBar);
        submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String feedback = feedbackInput.getText().toString().trim();
                float rating = ratingBar.getRating();
                
                if (validateFeedback(feedback)) {
                    // TODO: Implement actual feedback submission
                    Toast.makeText(UserFeedbackActivity.this, 
                        "Thank you for your feedback!", 
                        Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        });
    }

    private boolean validateFeedback(String feedback) {
        if (feedback.isEmpty()) {
            feedbackInput.setError("Feedback is required");
            return false;
        }
        return true;
    }
} 