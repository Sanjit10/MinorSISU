package com.sanjit.sisu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class Register extends AppCompatActivity {

    EditText username_register, email_register, password_register, confirm_password_register;
    Button register_button;

    FirebaseFirestore fstore;
    String userId;
    FirebaseAuth fAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username_register = findViewById(R.id.username_register);
        email_register = findViewById(R.id.email_register);
        password_register = findViewById(R.id.password_register);
        confirm_password_register = findViewById(R.id.confirm_password_register);
        register_button = findViewById(R.id.register_button);

        fAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();


        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = username_register.getText().toString();
                String email = email_register.getText().toString();
                String password = password_register.getText().toString();
                String confirm_password = confirm_password_register.getText().toString();
                if (username.isEmpty()) {
                    username_register.setError("Username is required");
                    username_register.requestFocus();
                } else if (email.isEmpty()) {
                    email_register.setError("Email is required");
                    email_register.requestFocus();
                } else if (password.isEmpty()) {
                    password_register.setError("Password is required");
                    password_register.requestFocus();
                } else if (confirm_password.isEmpty()) {
                    confirm_password_register.setError("Confirm password is required");
                    confirm_password_register.requestFocus();
                } else if (!password.equals(confirm_password)) {
                    confirm_password_register.setError("Password does not match");
                    confirm_password_register.requestFocus();
                }else if (password.length() < 12)
                {
                    password_register.setError("Password must be 12 characters long");
                    password_register.requestFocus();
                }
                } else {

                }
    };


}

