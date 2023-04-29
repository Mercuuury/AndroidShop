package com.example.eshop.ui.catalog;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.eshop.R;
import com.example.eshop.databinding.FragmentCatalogBinding;
import com.example.eshop.ui.adapters.CatalogCategoriesRvAdapter;
import com.example.eshop.ui.adapters.CategoriesRvAdapter;
import com.example.eshop.ui.adapters.ProductsRvAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class CatalogFragment extends Fragment {
    private FragmentCatalogBinding binding;
    private Context ctx;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.ctx = context;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCatalogBinding.inflate(inflater, container, false);

        ArrayList<String> categories = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.categories)));
        LinearLayoutManager linLtMgrCategories =new LinearLayoutManager(ctx, LinearLayoutManager.VERTICAL, false);
        CatalogCategoriesRvAdapter catRvAdapter = new CatalogCategoriesRvAdapter(ctx, categories);
        binding.rvCategories.setLayoutManager(linLtMgrCategories);
        binding.rvCategories.setAdapter(catRvAdapter);

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}