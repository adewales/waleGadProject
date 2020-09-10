package com.example.waleleaderboardapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LeaderAdapter extends RecyclerView.Adapter<LeaderAdapter.LeaderViewHolder> {
    public LeaderAdapter(ArrayList<Leader> leaders) {
        this.leaders = leaders;
    }

    ArrayList<Leader> leaders;

    @NonNull
    @Override
    public LeaderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context= parent.getContext();
        View itemView= LayoutInflater.from(context)
                .inflate(R.layout.layout_leader_list,parent,false);
        return  new LeaderViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull LeaderViewHolder holder, int position) {
        Leader leader= leaders.get(position);
        holder.bind(leader);

    }

    @Override
    public int getItemCount() {
        return leaders.size();
    }

    public class LeaderViewHolder extends  RecyclerView.ViewHolder{
            TextView tvName;
            TextView tvHour;

        public LeaderViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName =(TextView) itemView.findViewById(R.id.tvName);
            tvHour= (TextView) itemView. findViewById(R.id.tvHour);
        }

        public void bind(Leader leader){
            tvName.setText(leader.name);
            tvHour.setText(leader.hours + " Learner Hours, " + leader.country);
        }
    }
}
