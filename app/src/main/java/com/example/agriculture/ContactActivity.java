package com.example.agriculture;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ContactActivity extends AppCompatActivity {
    private EditText nameInput, emailInput, messageInput;
    private Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        nameInput = findViewById(R.id.nameInput);
        emailInput = findViewById(R.id.emailInput);
        messageInput = findViewById(R.id.messageInput);
        sendButton = findViewById(R.id.sendButton);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameInput.getText().toString().trim();
                String email = emailInput.getText().toString().trim();
                String message = messageInput.getText().toString().trim();
                if (name.isEmpty() || email.isEmpty() || message.isEmpty()) {
                    Toast.makeText(ContactActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    // TODO: Handle contact form submission
                    Toast.makeText(ContactActivity.this, "Message sent!", Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        });
    }
} 