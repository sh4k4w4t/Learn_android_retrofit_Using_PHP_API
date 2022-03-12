package com.alivepython.mobilebankingappusingphpapi.test_Mine_shakawat_json_From_Cpanel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alivepython.mobilebankingappusingphpapi.R;

import java.util.List;

public class GithubAdapter extends RecyclerView.Adapter<GithubAdapter.viewHolder>{

    List<GithubModel> githubModelList;

    public GithubAdapter(List<GithubModel> githubModelList) {
        this.githubModelList = githubModelList;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.github_history_item,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        GithubModel tempGitHubModel= githubModelList.get(position);

        holder.loginGit.setText(tempGitHubModel.getLogin());
        holder.idGit.setText(tempGitHubModel.getId());
        holder.nodeIdGit.setText(tempGitHubModel.getNode_id());
        holder.avatarGit.setText(tempGitHubModel.getAvatar_url());

    }

    @Override
    public int getItemCount() {

        if (githubModelList==null || githubModelList.size()==0){
            return 0;
        }else {
            return githubModelList.size();
        }
    }


    public class viewHolder extends RecyclerView.ViewHolder{
        TextView loginGit, idGit, nodeIdGit, avatarGit;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            loginGit = itemView.findViewById(R.id.loginGit);
            idGit = itemView.findViewById(R.id.idGit);
            nodeIdGit = itemView.findViewById(R.id.nodeIdGit);
            avatarGit = itemView.findViewById(R.id.avatarGit);
        }
    }
}
