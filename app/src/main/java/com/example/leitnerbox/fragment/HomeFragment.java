package com.example.leitnerbox.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.leitnerbox.R;
import com.example.leitnerbox.adapter.AdapterBox;
import com.example.leitnerbox.adapter.AdapterGroup;
import com.example.leitnerbox.model.Box;
import com.example.leitnerbox.model.Group;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    private View rootView;
    List<Group> groupList;
    List<Box> boxList;

    AdapterGroup adapterGroup;
    AdapterBox adapterBox;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         rootView = inflater.inflate(R.layout.fragment_home, container, false);

        initViews();
        setupBoxRecyclerView();



        return rootView;
    }



    private void initViews() {

        RecyclerView rv_group = rootView.findViewById(R.id.rv_group);


        //create data
        groupList = new ArrayList<Group>();

        groupList.add(new Group("ریاضی", "10"+ " کارت", R.color.deep_orange_500));
        groupList.add(new Group("علوم", "20"+ " کارت", R.color.purple_400));
        groupList.add(new Group("هنر", "30"+ " کارت", R.color.cyan_500));

        adapterGroup = new AdapterGroup(groupList, rootView.getContext());

        LinearLayoutManager layoutManager = new LinearLayoutManager(rootView.getContext());
        rv_group.setLayoutManager(layoutManager);


        rv_group.setAdapter(adapterGroup);

    }

    private void setupBoxRecyclerView() {

        RecyclerView rv_box = rootView.findViewById(R.id.rv_box);

        boxList = new ArrayList<Box>();

        boxList.add(new Box("کل کارت های جعبه", "0 کارت"));
        boxList.add(new Box("خانه 1", "0 کارت"));
        boxList.add(new Box("خانه 2", "0 کارت"));
        boxList.add(new Box("خانه 3", "0 کارت"));
        boxList.add(new Box("خانه 4", "0 کارت"));
        boxList.add(new Box("خانه 5", "0 کارت"));

        adapterBox = new AdapterBox( rootView.getContext(),boxList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(rootView.getContext());
        rv_box.setLayoutManager(layoutManager);


        rv_box.setAdapter(adapterBox);


    }
}
