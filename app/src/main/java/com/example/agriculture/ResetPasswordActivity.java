package com.example.agriculture;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ResetPasswordActivity extends AppCompatActivity {
    private EditText emailInput;
    private Button resetButton;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        dbHelper = new DatabaseHelper(this);
        
        emailInput = findViewById(R.id.emailInput);
        resetButton = findViewById(R.id.resetButton);

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailInput.getText().toString().trim();
                if (validateEmail(email)) {
                    // TODO: Implement actual password reset logic
                    Toast.makeText(ResetPasswordActivity.this, 
                        "Password reset instructions sent to " + email, 
                        Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        });
    }

    private boolean validateEmail(String email) {
        if (email.isEmpty()) {
            emailInput.setError("Email is required");
            return false;
        }
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailInput.setError("Enter a valid email address");
            return false;
        }
        return true;
    }
} 