package com.example.leitnerbox.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.leitnerbox.R;
import com.example.leitnerbox.adapter.AdapterGroup;
import com.example.leitnerbox.model.Group;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    private View rootView;
    List<Group> groups;
    AdapterGroup adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         rootView = inflater.inflate(R.layout.fragment_home, container, false);

        initViews();



        return rootView;
    }

    private void initViews() {

        RecyclerView recyclerView = rootView.findViewById(R.id.rv_group);


        //create data
        groups = new ArrayList<Group>();

        groups.add(new Group("ریاضی", "10", R.color.deep_orange_500));
        groups.add(new Group("علوم", "20", R.color.purple_400));
        groups.add(new Group("هنر", "30", R.color.cyan_500));

        adapter = new AdapterGroup(groups, rootView.getContext());

        LinearLayoutManager layoutManager = new LinearLayoutManager(rootView.getContext());
        recyclerView.setLayoutManager(layoutManager);


        recyclerView.setAdapter(adapter);

    }
}
