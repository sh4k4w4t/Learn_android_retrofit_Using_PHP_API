package com.alivepython.mobilebankingappusingphpapi.ui.recharge;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.alivepython.mobilebankingappusingphpapi.R;
import com.alivepython.mobilebankingappusingphpapi.interfaces.WebService;
import com.alivepython.mobilebankingappusingphpapi.model.DataController;
import com.alivepython.mobilebankingappusingphpapi.model.MyRetrofit;
import com.alivepython.mobilebankingappusingphpapi.model.UserModel;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RechargeFragment extends Fragment {

    View rootView;
    EditText phoneNumber,amountNumber;
    Button rechargeButton;
    ProgressBar progressBar;
    UserModel user;
    WebService service;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView= inflater.inflate(R.layout.fragment_recharge,container,false);
        seriallizedUI();


        rechargeButton.setOnClickListener(view -> {
            if (phoneNumber.getText().toString().equals("") || amountNumber.getText().toString().equals("")){
                Toast.makeText(getActivity(), "Fill up all information", Toast.LENGTH_SHORT).show();
            }else {
                progressBar.setVisibility(View.VISIBLE);
                RechargeNow(phoneNumber.getText().toString(),amountNumber.getText().toString());
            }
        });




        return rootView;
    }

    private void seriallizedUI() {
        phoneNumber=rootView.findViewById(R.id.editTextPhoneNumber);
        amountNumber=rootView.findViewById(R.id.editTextRechargeAmmount);
        rechargeButton=rootView.findViewById(R.id.buttonSubmit);
        progressBar=rootView.findViewById(R.id.rechargeProgressBar);

        user= DataController.instance.getCurrentUser();
        service= MyRetrofit.getInstance();
    }

    private void RechargeNow(String number, String ammount){
        Call<ResponseBody> rechargeNow= service.rechargeNow(number,ammount,user.getUserPhone(),user.getUserPin());
        rechargeNow.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                progressBar.setVisibility(View.GONE);
                if (!response.isSuccessful()){
                    Toast.makeText(getActivity(), "Request Failed", Toast.LENGTH_SHORT).show();
                return;
                }

                String res="";
                try {
                    res= response.body().string();
                    if (res.equals("1")){
                        Toast.makeText(getActivity(), "recharge Success", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(getActivity(), "recharge failed", Toast.LENGTH_SHORT).show();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                progressBar.setVisibility(View.GONE);

            }
        });
    }
}
