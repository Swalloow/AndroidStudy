package com.swalloow.myretrofit.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.swalloow.myretrofit.R;
import com.swalloow.myretrofit.models.Repo;

import java.util.List;

/**
 * Created by Junyoung on 2016-07-10.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    Context context;
    List<Repo> repos;
    int item_layout;

    public RecyclerAdapter(Context context, List<Repo> repos, int item_layout) {
        this.context = context;
        this.repos = repos;
        this.item_layout = item_layout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, null);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Repo repo = repos.get(position);
        holder.id.setText(repo.getId());
        holder.name.setText(repo.getName());
        holder.fullName.setText(repo.getFull_name());
    }

    @Override
    public int getItemCount() {
        return this.repos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView id;
        TextView name;
        TextView fullName;

        public ViewHolder(View itemView) {
            super(itemView);

            id = (TextView) itemView.findViewById(R.id.id);
            name = (TextView) itemView.findViewById(R.id.name);
            fullName = (TextView) itemView.findViewById(R.id.fullName);
        }
    }
}
