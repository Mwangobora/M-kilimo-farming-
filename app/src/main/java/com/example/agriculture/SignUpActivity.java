package com.example.agriculture;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.agriculture.databinding.ActivitySignUpBinding;
import com.google.android.material.snackbar.Snackbar;

public class SignUpActivity extends AppCompatActivity {
    private ActivitySignUpBinding binding;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        dbHelper = new DatabaseHelper(this);

        binding.signupButton.setOnClickListener(v -> attemptSignUp());
        binding.loginLink.setOnClickListener(v -> {
            startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
            finish();
        });
    }

    private void attemptSignUp() {
        String name = binding.nameInput.getText().toString().trim();
        String email = binding.emailInput.getText().toString().trim();
        String phone = binding.phoneInput.getText().toString().trim();
        String password = binding.passwordInput.getText().toString().trim();
        String confirmPassword = binding.confirmPasswordInput.getText().toString().trim();

        // Validation
        if (TextUtils.isEmpty(name)) {
            showError("Please enter your name");
            return;
        }

        if (TextUtils.isEmpty(email)) {
            showError("Please enter your email");
            return;
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            showError("Please enter a valid email address");
            return;
        }

        if (TextUtils.isEmpty(phone)) {
            showError("Please enter your phone number");
            return;
        }

        if (TextUtils.isEmpty(password)) {
            showError("Please enter a password");
            return;
        }

        if (password.length() < 6) {
            showError("Password must be at least 6 characters");
            return;
        }

        if (!password.equals(confirmPassword)) {
            showError("Passwords do not match");
            return;
        }

        // Check if email already exists
        if (dbHelper.checkEmail(email)) {
            showError("Email already registered");
            return;
        }

        // Add user to database
        if (dbHelper.addUser(email, password, name, phone)) {
            Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
            finish();
        } else {
            showError("Registration failed. Please try again.");
        }
    }

    private void showError(String message) {
        Snackbar.make(binding.getRoot(), message, Snackbar.LENGTH_LONG).show();
    }
} 