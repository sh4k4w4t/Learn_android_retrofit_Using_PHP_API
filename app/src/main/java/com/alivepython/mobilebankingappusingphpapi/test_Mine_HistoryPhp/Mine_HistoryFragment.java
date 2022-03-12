package com.alivepython.mobilebankingappusingphpapi.test_Mine_HistoryPhp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alivepython.mobilebankingappusingphpapi.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Mine_HistoryFragment extends Fragment {
    View rootView;

    Mine_Web_Service mine_web_service;

    List<Mine_Model> allHistorys= new ArrayList<>();
    RecyclerView recyclerView;
    Mine_adapter_for_recycleView adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView= inflater.inflate(R.layout.fragment_mine_history, container, false);

        recyclerView= rootView.findViewById(R.id.historyRecyclerIdNO);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mine_web_service= Mine_Retrofit.getMine_service();
        loadHistory();




        return rootView;
    }

    private void loadHistory() {
        Call<List<Mine_Model>> loadHistories= mine_web_service.mine_GetHistoryList("0171","0171");
        loadHistories.enqueue(new Callback<List<Mine_Model>>() {
            @Override
            public void onResponse(Call<List<Mine_Model>> call, Response<List<Mine_Model>> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(getActivity(), "Failed 1", Toast.LENGTH_SHORT).show();
                    return;
                }
                allHistorys=response.body();
                Toast.makeText(getActivity(), "Success: "+allHistorys.size(), Toast.LENGTH_SHORT).show();
                adapter= new Mine_adapter_for_recycleView(allHistorys);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Mine_Model>> call, Throwable t) {
                Toast.makeText(getActivity(), "Failed 2", Toast.LENGTH_SHORT).show();

            }
        });
    }
}