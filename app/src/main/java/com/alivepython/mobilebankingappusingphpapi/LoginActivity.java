package com.alivepython.mobilebankingappusingphpapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.alivepython.mobilebankingappusingphpapi.interfaces.WebService;
import com.alivepython.mobilebankingappusingphpapi.model.MyRetrofit;

public class LoginActivity extends AppCompatActivity {

    EditText PhoneNumberText, PinNumberText;
    Button loginButton;
    ProgressBar loadingProgress;
    WebService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        InitializedUI();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(PinNumberText.getText().toString().equals("") || PhoneNumberText.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Check pin and number", Toast.LENGTH_SHORT).show();
                }
                else {
                    loadingProgress.setVisibility(View.VISIBLE);
                    SendLoginRequest(PhoneNumberText.getText().toString(),PinNumberText.getText().toString());
                }
            }
        });




    }

    private void SendLoginRequest(String phoneNumber, String pinNumber) {
        service= MyRetrofit.getInstance();

    }

    private void InitializedUI() {
        PhoneNumberText =findViewById(R.id.editTextPhone);
        PinNumberText =findViewById(R.id.editTextNumber);
        loginButton=findViewById(R.id.buttonLogin);
        loadingProgress=findViewById(R.id.progressBarLoading);
    }
}