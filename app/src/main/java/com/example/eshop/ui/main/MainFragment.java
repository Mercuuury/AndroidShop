package com.example.eshop.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.eshop.ProductActivity;
import com.example.eshop.R;
import com.example.eshop.RecyclerViewInterface;
import com.example.eshop.databinding.FragmentMainBinding;
import com.example.eshop.ui.adapters.CategoriesRvAdapter;
import com.example.eshop.ui.adapters.ProductsRvAdapter;

import java.util.ArrayList;
import java.util.Arrays;


public class MainFragment extends Fragment implements RecyclerViewInterface {
    private FragmentMainBinding binding;
    private Context ctx;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.ctx = context;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(inflater, container, false);

        ArrayList<String> categories = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.categories)));
        LinearLayoutManager linLtMgrCategories = new GridLayoutManager(ctx, 2, GridLayoutManager.HORIZONTAL, false);
        CategoriesRvAdapter catRvAdapter = new CategoriesRvAdapter(ctx, categories);
        binding.rvCategories.setLayoutManager(linLtMgrCategories);
        binding.rvCategories.setAdapter(catRvAdapter);

        ArrayList<String> products = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.products)));
        LinearLayoutManager linLtMgrProducts = new LinearLayoutManager(ctx, LinearLayoutManager.VERTICAL, false);
        ProductsRvAdapter prodRvAdapter = new ProductsRvAdapter(ctx, products, this);
        binding.rvProducts.setLayoutManager(linLtMgrProducts);
        binding.rvProducts.setAdapter(prodRvAdapter);

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(ctx, ProductActivity.class);
        startActivity(intent);
    }
}