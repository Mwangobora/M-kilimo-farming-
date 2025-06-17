package com.example.agriculture;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ComplainsActivity extends AppCompatActivity {
    private EditText complainInput;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complains);

        complainInput = findViewById(R.id.complainInput);
        submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String complain = complainInput.getText().toString().trim();
                if (complain.isEmpty()) {
                    complainInput.setError("Please enter your complaint");
                } else {
                    // TODO: Handle complaint submission
                    Toast.makeText(ComplainsActivity.this, "Complaint submitted!", Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        });
    }
} 