package com.alivepython.mobilebankingappusingphpapi.test_JsonPlaceHolder_bs_posts;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alivepython.mobilebankingappusingphpapi.R;

import java.util.List;

public class Posts_recycleView_adapter extends RecyclerView.Adapter<Posts_recycleView_adapter.viewHolder>{

    List<Posts_model> allModel;

    public Posts_recycleView_adapter(List<Posts_model> allModel) {
        this.allModel = allModel;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.posts_history_item,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Posts_model temp= allModel.get(position);

        holder.userID.setText(String.valueOf(temp.getUserId()));
        holder.idNo.setText(String.valueOf(temp.getId()));
        holder.title.setText(temp.getTitle());
        holder.body.setText(temp.getBody());

    }

    @Override
    public int getItemCount() {
        if (allModel.size()==0 || allModel == null){
        return 0;
        }else {
            return allModel.size();
        }
    }


    public class viewHolder extends RecyclerView.ViewHolder{
        TextView userID,title,body,idNo;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            userID= itemView.findViewById(R.id.posts_user_id);
            idNo= itemView.findViewById(R.id.posts_id_no);
            title= itemView.findViewById(R.id.posts_title);
            body= itemView.findViewById(R.id.posts_body);
        }
    }
}