package com.blakcode.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {
    TextView btn;
    private EditText InputUserName,InputEmail,InputPassword,InputConfirmPassword;
    Button btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_registration);
        btn = findViewById(R.id.alreadyHaveAccount);
        InputUserName = findViewById(R.id.InputUserName);
        InputEmail = findViewById(R.id.InputEmail);
        InputPassword = findViewById(R.id.InputPassword);
        InputConfirmPassword = findViewById(R.id.InputComfirmPassword);
        btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createCredential();
            }
        });



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegistrationActivity.this,LoginActivity.class));
            }
        });
    }

    private void createCredential() {
        String username= InputUserName.getText().toString();
        String email= InputEmail.getText().toString();
        String password= InputPassword.getText().toString();
        String confirmpassword= InputConfirmPassword.getText().toString();

        if (username.isEmpty() || username.length()<7){
            showError(InputUserName,"Username is not valid,Username must be at least seven(7) Characters");
        }
        else if (email.isEmpty() || !email.contains("@")){
            showError(InputEmail,"Email is not valid");
        }
        else if (password.isEmpty() || password.length()<7){
            showError(InputPassword,"Password is not valid,Password must be at least seven(7) Characters");
        }

        else if (confirmpassword.isEmpty() || !confirmpassword.equals(password)){
            showError(InputConfirmPassword,"Password is not match!");
        }
        else {
            Toast.makeText(this, "You have Successfully Registered", Toast.LENGTH_SHORT).show();
        }
    }

    private void showError(EditText input, String your_username_is_not_valid) {
        input.setError(your_username_is_not_valid);
        input.requestFocus();
    }


}