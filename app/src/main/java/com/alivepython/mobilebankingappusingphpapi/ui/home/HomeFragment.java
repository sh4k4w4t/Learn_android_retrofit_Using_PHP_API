package com.alivepython.mobilebankingappusingphpapi.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.alivepython.mobilebankingappusingphpapi.R;

public class HomeFragment extends Fragment implements View.OnClickListener {
    View rootView;
    ImageView rechargeImageView,cashOutImageView,sendMoneyImageView,historyImageView,paymentImageView,offerImageView,chatSupportImageView,notificationImageView,accountSettingImageView;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView=inflater.inflate(R.layout.fragment_home,container,false);
        serializedUI();



        return rootView;
    }

    @Override
    public void onClick(View view) {
        int id=view.getId();
        switch (id){
            case R.id.rechargeImageView:
                RechargeImageClick();
                break;

            case R.id.cashOutImageView:
                CashOutImageClick();
                break;
        }

    }

    private void CashOutImageClick() {
        Navigation.findNavController(rootView).navigate(R.id.action_nav_home_to_nav_cashOut);
    }

    private void RechargeImageClick() {
        Navigation.findNavController(rootView).navigate(R.id.action_nav_home_to_nav_recharge);
    }

    private void serializedUI() {
        rechargeImageView =rootView.findViewById(R.id.rechargeImageView);
        cashOutImageView =rootView.findViewById(R.id.cashOutImageView);
        sendMoneyImageView =rootView.findViewById(R.id.sendMoneyImageView);
        historyImageView =rootView.findViewById(R.id.historyImageView);
        paymentImageView =rootView.findViewById(R.id.paymentImageView);
        offerImageView =rootView.findViewById(R.id.offerImageView);
        chatSupportImageView =rootView.findViewById(R.id.chatSupportImageView);
        notificationImageView =rootView.findViewById(R.id.notificationImageView);
        accountSettingImageView =rootView.findViewById(R.id.accountSettingImageView);

        rechargeImageView.setOnClickListener(this);
        cashOutImageView.setOnClickListener(this);
        sendMoneyImageView.setOnClickListener(this);
        historyImageView.setOnClickListener(this);
        paymentImageView.setOnClickListener(this);
        offerImageView.setOnClickListener(this);
        chatSupportImageView.setOnClickListener(this);
        notificationImageView.setOnClickListener(this);
        accountSettingImageView.setOnClickListener(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        rootView = null;
    }
}