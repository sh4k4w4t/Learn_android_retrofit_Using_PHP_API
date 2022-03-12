package com.alivepython.mobilebankingappusingphpapi.main_Apps_mobileBanking.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.alivepython.mobilebankingappusingphpapi.R;

public class GalleryFragment extends Fragment {

    View rootView;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_gallery,container,false);




        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        rootView = null;
    }
}