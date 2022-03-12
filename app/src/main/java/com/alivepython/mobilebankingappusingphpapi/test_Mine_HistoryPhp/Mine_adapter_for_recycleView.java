package com.alivepython.mobilebankingappusingphpapi.test_Mine_HistoryPhp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alivepython.mobilebankingappusingphpapi.R;

import java.util.List;

public class Mine_adapter_for_recycleView extends RecyclerView.Adapter<Mine_adapter_for_recycleView.viewHolder>{
    List<Mine_Model> mineHistories;

    public Mine_adapter_for_recycleView(List<Mine_Model> mineHistories) {
        this.mineHistories = mineHistories;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.mine_history_item,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Mine_Model tempMineModel= mineHistories.get(position);

        holder.historyType.setText(tempMineModel.getType());
        holder.historyAmount.setText(tempMineModel.getAmount());
        holder.historyNumber.setText(tempMineModel.getNumber());
        holder.historyDate.setText(tempMineModel.getDateTime());

    }

    @Override
    public int getItemCount() {

        if (mineHistories==null || mineHistories.size()==0){
            return 0;
        }else {
            return mineHistories.size();
        }
    }


    public class viewHolder extends RecyclerView.ViewHolder{

        TextView historyType, historyAmount, historyNumber, historyDate;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            historyType= itemView.findViewById(R.id.typeTV);
            historyAmount= itemView.findViewById(R.id.amountTV);
            historyNumber= itemView.findViewById(R.id.numberTV);
            historyDate= itemView.findViewById(R.id.dateTimeTV);
        }

    }


}
