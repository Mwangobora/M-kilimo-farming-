package com.example.agriculture;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class LoginActivity extends AppCompatActivity {
    private EditText emailInput, passwordInput;
    private Button loginButton;
    private TextView signUpLink, forgotPasswordLink;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize database helper
        dbHelper = new DatabaseHelper(this);

        // Initialize views
        emailInput = findViewById(R.id.email_input);
        passwordInput = findViewById(R.id.password_input);
        loginButton = findViewById(R.id.login_button);
        signUpLink = findViewById(R.id.signup_link);
        forgotPasswordLink = findViewById(R.id.forgot_password_link);

        // Check network and database connection
        if (!isNetworkAvailable()) {
            showSnackbar("No internet connection available");
        }

        // Set click listeners
        loginButton.setOnClickListener(v -> attemptLogin());
        signUpLink.setOnClickListener(v -> startActivity(new Intent(LoginActivity.this, SignUpActivity.class)));
        forgotPasswordLink.setOnClickListener(v -> startActivity(new Intent(LoginActivity.this, ResetPasswordActivity.class)));
    }

    private void attemptLogin() {
        String email = emailInput.getText().toString().trim();
        String password = passwordInput.getText().toString().trim();

        if (email.isEmpty() || password.isEmpty()) {
            showSnackbar("Please fill in all fields");
            return;
        }

        if (!isNetworkAvailable()) {
            showSnackbar("No internet connection available");
            return;
        }

        // Check credentials in database
        if (dbHelper.checkUser(email, password)) {
            startActivity(new Intent(LoginActivity.this, DashboardActivity.class));
            finish();
        } else {
            showSnackbar("Invalid email or password");
        }
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private void showSnackbar(String message) {
        Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG).show();
    }
} 