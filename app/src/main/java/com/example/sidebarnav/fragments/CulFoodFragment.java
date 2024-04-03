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

public class CulFoodFragment extends Fragment {
    private RecyclerView recyclerView;
    private MyAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View view = inflater.inflate(R.layout.fragment_culinary_food, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));

        adapter = new MyAdapter(getList());
        recyclerView.setAdapter(adapter);

        return view;
    }

    private List<MyModel> getList() {
        List<MyModel> myModels = new ArrayList<>();

        String[] foodNames = getResources().getStringArray(R.array.food_names);
        String[] foodDescs = getResources().getStringArray(R.array.food_descs);
        String[] foodImgs = getResources().getStringArray(R.array.food_imgs);

        for (int i = 0; i < foodNames.length; i++) {
            myModels.add(new MyModel(foodNames[i], foodDescs[i], foodImgs[i]));
        }

        return myModels;
    }
}
