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

public class LoginActivity extends AppCompatActivity {

    TextView btn;
    EditText InputEmail,InputPassword;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
         getSupportActionBar().hide();


        setContentView(R.layout.activity_login);
         btn = findViewById(R.id.texViewSignUp);
        InputEmail = findViewById(R.id.InputEmail);
        InputPassword = findViewById(R.id.InputPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createCredential();
            }


        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             startActivity(new Intent(LoginActivity.this,RegistrationActivity.class));
            }
        });

    }


    private void createCredential() {

        String email= InputEmail.getText().toString();
        String password= InputPassword.getText().toString();


         if (email.isEmpty() || !email.contains("@")){
            showError(InputEmail,"Email is not valid");
        }
        else if (password.isEmpty() || password.length()<7){
            showError(InputPassword,"Password is not valid,Password must be at least seven(7) Characters");
        }


        else {
            Toast.makeText(this, "You have Login Successfully", Toast.LENGTH_SHORT).show();
        }
    }

    private void showError(EditText input, String your_username_is_not_valid) {
        input.setError(your_username_is_not_valid);
        input.requestFocus();
    }

}
