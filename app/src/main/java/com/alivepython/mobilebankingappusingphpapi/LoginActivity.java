package com.alivepython.mobilebankingappusingphpapi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.alivepython.mobilebankingappusingphpapi.interfaces.WebService;
import com.alivepython.mobilebankingappusingphpapi.model.DataController;
import com.alivepython.mobilebankingappusingphpapi.model.MyRetrofit;
import com.alivepython.mobilebankingappusingphpapi.model.UserModel;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText PhoneNumberText, PinNumberText;
    Button loginButton;
    ProgressBar loadingProgress;
    WebService service;
    DataController dataController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        InitializedUI();

        loginButton.setOnClickListener(view -> {
            if(PinNumberText.getText().toString().equals("") || PhoneNumberText.getText().toString().equals("")){
                Toast.makeText(getApplicationContext(), "Check pin and number", Toast.LENGTH_SHORT).show();
            }
            else {
                loadingProgress.setVisibility(View.VISIBLE);
                SendLoginRequest(PhoneNumberText.getText().toString(),PinNumberText.getText().toString());
            }
        });
    }

    private void SendLoginRequest(String phoneNumber, String pinNumber) {
        service= MyRetrofit.getinstance();
        /*Call<ResponseBody> login=service.loginNow(phoneNumber,pinNumber);
        login.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
                loadingProgress.setVisibility(View.GONE);
                if (!response.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "Response not success.", Toast.LENGTH_SHORT).show();
                    return;
                }
                String serverMsg= "";
                try {
                    assert response.body() != null;
                    serverMsg= response.body().string();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if (serverMsg.equals("Login success")){
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    finish();
                }

                else{Toast.makeText(getApplicationContext(), serverMsg, Toast.LENGTH_SHORT).show();}
            }

            @Override
            public void onFailure(@NonNull Call<ResponseBody> call, @NonNull Throwable t) {
                loadingProgress.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext(), "Response failed.", Toast.LENGTH_SHORT).show();

            }
        });*/

        Call<UserModel> jsonTest = service.jsontest(phoneNumber,pinNumber);
        jsonTest.enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                loadingProgress.setVisibility(View.GONE);
                if (!response.isSuccessful()){
                    return;
                }
                UserModel user= response.body();

                if (user==null){
                    Toast.makeText(getApplicationContext(), "User null", Toast.LENGTH_SHORT).show();
                }
                else if (user.getUserResponse()!=null && user.getUserResponse().equals("0")){
                    Toast.makeText(getApplicationContext(), "Login failed", Toast.LENGTH_SHORT).show();
                }
                else if (user.getUserResponse()!=null && user.getUserResponse().equals("1")){
                    dataController.setCurrentUser(user);

                    Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    finish();
                }
            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {

            }
        });

    }

    private void InitializedUI() {
        PhoneNumberText =findViewById(R.id.editTextPhone);
        PinNumberText =findViewById(R.id.editTextNumber);
        loginButton=findViewById(R.id.buttonLogin);
        loadingProgress=findViewById(R.id.progressBarLoading);
        dataController= DataController.getInstance();
    }
}