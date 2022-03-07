package com.alivepython.mobilebankingappusingphpapi.ui.accountInformation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.alivepython.mobilebankingappusingphpapi.R;
import com.alivepython.mobilebankingappusingphpapi.model.DataController;
import com.alivepython.mobilebankingappusingphpapi.model.UserModel;

public class AccountInfo extends Fragment {
    View rootView;
    TextView userTextView, phoneNumberTextView, balanceTextView;
    UserModel userModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView= inflater.inflate(R.layout.fragment_account_info,container,false);

        userTextView= rootView.findViewById(R.id.textView5);
        phoneNumberTextView= rootView.findViewById(R.id.textView6);
        balanceTextView= rootView.findViewById(R.id.textView7);

        userModel= DataController.getInstance().getCurrentUser();

//        userTextView.setText(userModel.getUserName());
//        phoneNumberTextView.setText(userModel.getUserPhone());
//        balanceTextView.setText(userModel.getUserBalance());





        return rootView;
    }
}
