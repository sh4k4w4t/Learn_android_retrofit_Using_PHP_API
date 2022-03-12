package com.alivepython.mobilebankingappusingphpapi.main_Apps_mobileBanking.ui.allService;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alivepython.mobilebankingappusingphpapi.R;


public class AllServiceFragment extends Fragment {
    View rootView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView=inflater.inflate(R.layout.fragment_all_service, container, false);





        return rootView;
    }
}