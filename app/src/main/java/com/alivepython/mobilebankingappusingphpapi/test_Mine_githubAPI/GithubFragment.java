package com.alivepython.mobilebankingappusingphpapi.test_Mine_githubAPI;

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

public class GithubFragment extends Fragment {
    View root;

    GithubWebService service;

    List<GithubModel> gitList=new ArrayList<>();
    RecyclerView recyclerView;
    GithubAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root= inflater.inflate(R.layout.github_fragment, container, false);

        recyclerView=root.findViewById(R.id.historyRecyclerIdForGit);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        service= GithubRetrofit.getService();
        loadGitUserInfo();

        return root;
    }

    private void loadGitUserInfo() {

        Call<List<GithubModel>> allInfo=service.listOfGithub();
        allInfo.enqueue(new Callback<List<GithubModel>>() {
            @Override
            public void onResponse(Call<List<GithubModel>> call, Response<List<GithubModel>> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(getActivity(), "response failed", Toast.LENGTH_SHORT).show();
                    return;
                }
                gitList= response.body();
                Toast.makeText(getActivity(), "size"+gitList.size(), Toast.LENGTH_SHORT).show();
                adapter= new GithubAdapter(gitList);
                recyclerView.setAdapter(adapter);


            }

            @Override
            public void onFailure(Call<List<GithubModel>> call, Throwable t) {
                Toast.makeText(getActivity(), "onFailure onFailure", Toast.LENGTH_SHORT).show();
            }
        });
    }
}