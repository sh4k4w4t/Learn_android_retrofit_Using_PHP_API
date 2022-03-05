package com.alivepython.mobilebankingappusingphpapi.ui.cashout;

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

public class CashOutFragment extends Fragment {

    View rootView;
    EditText agentNumber, cashOutAmount;
    Button cashOutButton;
    ProgressBar loadingProgressBar;
    UserModel user;
    WebService service;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView= inflater.inflate(R.layout.fragment_cashout,container,false);
        seriallizedUI();


        cashOutButton.setOnClickListener(view -> {
            if (agentNumber.getText().toString().equals("") || cashOutAmount.getText().toString().equals("")){
                Toast.makeText(getActivity(), "Fill up all information", Toast.LENGTH_SHORT).show();
            }else {
                loadingProgressBar.setVisibility(View.VISIBLE);
                CashOutNow(agentNumber.getText().toString(), cashOutAmount.getText().toString());
            }
        });




        return rootView;
    }

    private void seriallizedUI() {
        agentNumber =rootView.findViewById(R.id.editTextPhoneNumber);
        cashOutAmount =rootView.findViewById(R.id.editTextRechargeAmmount);
        cashOutButton =rootView.findViewById(R.id.buttonSubmit);
        loadingProgressBar =rootView.findViewById(R.id.rechargeProgressBar);

        user= DataController.instance.getCurrentUser();
        service= MyRetrofit.getInstance();
    }

    private void CashOutNow(String number, String amount){
        Call<ResponseBody> cashOut= service.cashOutNow(number,amount,user.getUserPhone(),user.getUserPin());
        cashOut.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                loadingProgressBar.setVisibility(View.GONE);
                if (!response.isSuccessful()){
                    Toast.makeText(getActivity(), "Request Failed", Toast.LENGTH_SHORT).show();
                return;
                }

                String res="";
                try {
                    res= response.body().string();
                    if (res.equals("1")){
                        Toast.makeText(getActivity(), "Cash out success", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(getActivity(), "Cash out failed", Toast.LENGTH_SHORT).show();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                loadingProgressBar.setVisibility(View.GONE);
                Toast.makeText(getActivity(), "Request Failed", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
