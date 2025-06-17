package com.example.agriculture;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class AccountActivity extends AppCompatActivity {
    private EditText nameInput;
    private EditText emailInput;
    private EditText phoneInput;
    private Button saveButton;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Account Settings");

        dbHelper = new DatabaseHelper(this);
        
        nameInput = findViewById(R.id.nameInput);
        emailInput = findViewById(R.id.emailInput);
        phoneInput = findViewById(R.id.phoneInput);
        saveButton = findViewById(R.id.saveButton);

        // Load user data
        loadUserData();

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInputs()) {
                    // TODO: Implement actual account update
                    Toast.makeText(AccountActivity.this, 
                        "Account updated successfully", 
                        Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        });
    }

    private void loadUserData() {
        // TODO: Load actual user data from database
        nameInput.setText("John Doe");
        emailInput.setText("john@example.com");
        phoneInput.setText("+1234567890");
    }

    private boolean validateInputs() {
        boolean isValid = true;

        if (nameInput.getText().toString().trim().isEmpty()) {
            nameInput.setError("Name is required");
            isValid = false;
        }

        if (emailInput.getText().toString().trim().isEmpty()) {
            emailInput.setError("Email is required");
            isValid = false;
        }

        if (phoneInput.getText().toString().trim().isEmpty()) {
            phoneInput.setError("Phone number is required");
            isValid = false;
        }

        return isValid;
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