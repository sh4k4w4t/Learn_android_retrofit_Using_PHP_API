package com.alivepython.mobilebankingappusingphpapi.test_JsonPlaceHolder_bs_posts;

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

public class Posts_Fragment extends Fragment {
    View rootView;

    Posts_Interface posts_interface;

    List<Posts_model> allModels = new ArrayList<>();
    RecyclerView recyclerView;
    Posts_recycleView_adapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView=  inflater.inflate(R.layout.fragment_posts, container, false);

        recyclerView= rootView.findViewById(R.id.posts_recycleViewId);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        posts_interface= Posts_Retrofit.getServices();
        LoadAllModel();

    return rootView;
    }

    private void LoadAllModel() {
        Call<List<Posts_model>> call= posts_interface.getAllPostModelList();
        call.enqueue(new Callback<List<Posts_model>>() {
            @Override
            public void onResponse(Call<List<Posts_model>> call, Response<List<Posts_model>> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(getActivity(), "Failed 1", Toast.LENGTH_SHORT).show();
                    return;
                }
                allModels=response.body();
                adapter= new Posts_recycleView_adapter(allModels);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Posts_model>> call, Throwable t) {
                Toast.makeText(getActivity(), "Failed 2", Toast.LENGTH_SHORT).show();
            }
        });
    }
}