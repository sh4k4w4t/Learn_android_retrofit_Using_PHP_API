package com.alivepython.mobilebankingappusingphpapi.ui.history;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alivepython.mobilebankingappusingphpapi.R;
import com.alivepython.mobilebankingappusingphpapi.interfaces.WebService;
import com.alivepython.mobilebankingappusingphpapi.model.DataController;
import com.alivepython.mobilebankingappusingphpapi.model.History;
import com.alivepython.mobilebankingappusingphpapi.model.MyRetrofit;
import com.alivepython.mobilebankingappusingphpapi.model.UserModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HistoryFragment extends Fragment {
    View rootView;

    List<History> allHistory= new ArrayList<>();
    RecyclerView recyclerView;
    HistoryAdapter adapter;

    WebService service;
    UserModel user;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView= inflater.inflate(R.layout.fragment_history,container,false);

        recyclerView= rootView.findViewById(R.id.historyRecyclerId);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        service= MyRetrofit.getInstance();
        user = DataController.instance.getCurrentUser();
        LoadHistory();


        return rootView;
    }

    private void LoadHistory() {
        Call<List<History>> loadHistory= service.getHistoryList(user.getUserPhone(),user.getUserPin());

        loadHistory.enqueue(new Callback<List<History>>() {
            @Override
            public void onResponse(Call<List<History>> call, Response<List<History>> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(getActivity(), "response failed", Toast.LENGTH_SHORT).show();
                    return;
                }
//                allHistory.clear();
                allHistory=response.body();
                Toast.makeText(getActivity(), "size: "+allHistory.size(), Toast.LENGTH_SHORT).show();
                adapter = new HistoryAdapter(allHistory);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<History>> call, Throwable t) {
                Toast.makeText(getActivity(), "onFailure", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
