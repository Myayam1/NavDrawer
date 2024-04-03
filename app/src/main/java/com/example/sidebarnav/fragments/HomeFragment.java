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

import kotlin.collections.ArrayDeque;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        return view;
    }
}
