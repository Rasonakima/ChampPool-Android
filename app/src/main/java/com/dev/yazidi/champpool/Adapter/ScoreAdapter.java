package com.dev.yazidi.champpool.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dev.yazidi.champpool.Model.Score;
import com.dev.yazidi.champpool.R;

import java.util.List;

public class ScoreAdapter extends RecyclerView.Adapter<ScoreAdapter.ScoreViewHolder> {
    Context context;
    private List<Score> scores;

    public ScoreAdapter(List<Score> scores) {
        this.scores = scores;
    }

    @Override
    public ScoreViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ScoreViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_score, parent, false));
    }

    @Override
    public void onBindViewHolder(ScoreViewHolder holder, int position) {
        holder.champion_name.setText(scores.get(position).getChampion());
        holder.champion_lane.setText(scores.get(position).getLane());
        holder.champion_score.setText(String.valueOf(scores.get(position).getScore()));
    }

    @Override
    public int getItemCount() {
        return scores.size();
    }

    class ScoreViewHolder extends RecyclerView.ViewHolder {
        TextView champion_name, champion_lane, champion_score;

        public ScoreViewHolder(View itemView) {
            super(itemView);
            champion_name = (TextView) itemView.findViewById(R.id.item_champion_name);
            champion_lane = (TextView) itemView.findViewById(R.id.item_champion_lane);
            champion_score = (TextView) itemView.findViewById(R.id.item_champion_score);
        }
    }
}
