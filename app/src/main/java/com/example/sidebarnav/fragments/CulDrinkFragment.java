package com.example.sidebarnav.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sidebarnav.MyAdapter;
import com.example.sidebarnav.MyModel;
import com.example.sidebarnav.R;

import java.util.ArrayList;
import java.util.List;

public class CulDrinkFragment extends Fragment {
    private RecyclerView recyclerView;
    private MyAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View view = inflater.inflate(R.layout.fragment_culinary_drink, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));

        adapter = new MyAdapter(getList());
        recyclerView.setAdapter(adapter);

        return view;
    }

    private List<MyModel> getList() {
        List<MyModel> myModels = new ArrayList<>();

        String[] drinkNames = getResources().getStringArray(R.array.drink_names);
        String[] drinkDescs = getResources().getStringArray(R.array.drink_descs);
        String[] drinkImgs = getResources().getStringArray(R.array.drink_imgs);

        for (int i = 0; i < drinkNames.length; i++) {
            myModels.add(new MyModel(drinkNames[i], drinkDescs[i], drinkImgs[i]));
        }

        return myModels;
    }
}
