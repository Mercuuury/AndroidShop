package com.example.eshop.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eshop.R;

import java.util.ArrayList;

public class CategoriesRvAdapter extends RecyclerView.Adapter<CategoriesRvAdapter.CategoriesHolder> {
    ArrayList<String> data;
    Context context;

    public CategoriesRvAdapter(Context context, ArrayList<String> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public CategoriesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategoriesHolder(LayoutInflater.from(context).inflate(R.layout.rv_category, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesHolder holder, int position) {
        holder.categoryTitle.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class CategoriesHolder extends RecyclerView.ViewHolder {
        TextView categoryTitle;

        public CategoriesHolder(@NonNull View itemView) {
            super(itemView);
            categoryTitle = itemView.findViewById(R.id.rv_category_title);
        }
    }
}
