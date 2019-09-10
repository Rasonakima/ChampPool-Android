package com.dev.yazidi.champpool.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.dev.yazidi.champpool.R;

import java.util.List;

public class PoolAdapter extends BaseAdapter {

    private List<String> pool;
    private Context context;
    private LayoutInflater inflater;

    public PoolAdapter(List<String> pool, Context context) {
        this.pool = pool;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return pool.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {

            view = inflater.inflate(R.layout.item_pool, viewGroup, false);

            ImageView champion_name = (ImageView) view.findViewById(R.id.pool_champion_name);

            champion_name.setImageResource(context.getResources().getIdentifier(pool.get(i).toLowerCase(), "drawable", context.getPackageName()));
        }
        return view;
    }
}
