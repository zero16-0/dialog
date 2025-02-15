package com.example.dialog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLoginDialog();
            }
        });
    }

    private void showLoginDialog() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Login");
        alertDialog.setMessage("Enter your credentials");


        View dialogView = getLayoutInflater().inflate(R.layout.custom_dialog, null);
        alertDialog.setView(dialogView);

        final EditText etUser = dialogView.findViewById(R.id.etCustomDialogUser);
        final EditText etPassword = dialogView.findViewById(R.id.etCustomDialogPassword);
        Button btnDialogLogin = dialogView.findViewById(R.id.btnDialogLogin);
        Button btnDialogCancel = dialogView.findViewById(R.id.btnDialogCancel);

        AlertDialog dialog = alertDialog.create();


        btnDialogLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUser.getText().toString();
                String password = etPassword.getText().toString();

                if (username.equals("admin") && password.equals("admin")) {

                    Toast.makeText(MainActivity.this, "Login successful!", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();


                    Intent intent = new Intent(MainActivity.this, Activity2.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Invalid credentials!", Toast.LENGTH_SHORT).show();
                    etUser.setText("");
                    etPassword.setText("");
                }
            }
        });

        btnDialogCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}