package com.example.eshop.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eshop.R;
import com.example.eshop.RecyclerViewInterface;

import java.util.ArrayList;

public class ProductsRvAdapter extends RecyclerView.Adapter<ProductsRvAdapter.ProductsHolder> {
    ArrayList<String> data;
    Context context;
    private final RecyclerViewInterface recyclerViewInterface;

    public ProductsRvAdapter(Context context, ArrayList<String> data, RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.data = data;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public ProductsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.rv_product, parent, false);
        return new ProductsHolder(view, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsHolder holder, int position) {
        holder.productTitle.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ProductsHolder extends RecyclerView.ViewHolder {
        TextView productTitle;

        public ProductsHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            productTitle = itemView.findViewById(R.id.rv_product_title);

            itemView.setOnClickListener(view -> {
                if (recyclerViewInterface != null) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        recyclerViewInterface.onItemClick(pos);
                    }
                }
            });
        }
    }
}
