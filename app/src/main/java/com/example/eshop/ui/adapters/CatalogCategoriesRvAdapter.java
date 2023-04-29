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

public class CatalogCategoriesRvAdapter extends RecyclerView.Adapter<CatalogCategoriesRvAdapter.CatalogCategoriesHolder> {
    ArrayList<String> data;
    Context context;

    public CatalogCategoriesRvAdapter(Context context, ArrayList<String> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public CatalogCategoriesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CatalogCategoriesHolder(LayoutInflater.from(context).inflate(R.layout.rv_catalog_category, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CatalogCategoriesHolder holder, int position) {
        holder.catalogCategoryTitle.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class CatalogCategoriesHolder extends RecyclerView.ViewHolder {
        TextView catalogCategoryTitle;

        public CatalogCategoriesHolder(@NonNull View itemView) {
            super(itemView);
            catalogCategoryTitle = itemView.findViewById(R.id.rv_catalog_category_title);
        }
    }
}
