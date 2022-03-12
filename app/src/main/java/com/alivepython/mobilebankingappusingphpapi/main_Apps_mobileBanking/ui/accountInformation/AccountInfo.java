package com.alivepython.mobilebankingappusingphpapi.main_Apps_mobileBanking.ui.accountInformation;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.alivepython.mobilebankingappusingphpapi.R;
import com.alivepython.mobilebankingappusingphpapi.main_Apps_mobileBanking.model.DataController;
import com.alivepython.mobilebankingappusingphpapi.main_Apps_mobileBanking.model.UserModel;

public class AccountInfo extends Fragment {
    View rootView;
    TextView userTextView, phoneNumberTextView, balanceTextView;
    UserModel userModel;

    @SuppressLint("SetTextI18n")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView= inflater.inflate(R.layout.fragment_account_info,container,false);

        userTextView= rootView.findViewById(R.id.textView5);
        phoneNumberTextView= rootView.findViewById(R.id.textView6);
        balanceTextView= rootView.findViewById(R.id.textView7);

        userModel= DataController.getInstance().getCurrentUser();



        userTextView.setText("User Name: "+userModel.getUserName());
        phoneNumberTextView.setText("Phone Number: "+userModel.getUserPhone());
        balanceTextView.setText("Balance: "+userModel.getUserBalance());





        return rootView;
    }
}
