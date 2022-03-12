package com.alivepython.mobilebankingappusingphpapi.main_Apps_mobileBanking.ui.history;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alivepython.mobilebankingappusingphpapi.R;
import com.alivepython.mobilebankingappusingphpapi.main_Apps_mobileBanking.model.History;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.viewHolder> {
    List<History> myHistories;

    public HistoryAdapter(List<History> allHistories) {
        this.myHistories = allHistories;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.history_item,parent,false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        History tempHistory = myHistories.get(position);

        holder.historyType.setText(tempHistory.getType());
        holder.historyAmount.setText(tempHistory.getAmount());
        holder.historyNumber.setText(tempHistory.getNumber());
        holder.historyDate.setText(tempHistory.getDateTime());

    }

    @Override
    public int getItemCount() {
        if (myHistories ==null || myHistories.size()==0){
            return 0;
        }else {
            return myHistories.size();
        }
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        TextView historyType, historyAmount, historyNumber, historyDate;


        public viewHolder(View itemView){
            super(itemView);

            historyType= itemView.findViewById(R.id.typeTV);
            historyAmount= itemView.findViewById(R.id.amountTV);
            historyNumber= itemView.findViewById(R.id.numberTV);
            historyDate= itemView.findViewById(R.id.dateTimeTV);
        }
    }
}
