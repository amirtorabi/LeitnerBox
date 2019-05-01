package com.example.leitnerbox.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.leitnerbox.R;
import com.example.leitnerbox.adapter.AdapterExam;
import com.example.leitnerbox.model.Group;
import com.example.leitnerbox.utils.Tools;
import com.example.leitnerbox.utils.ViewAnimation;

import java.util.ArrayList;
import java.util.List;

public class CardFragment extends Fragment {

    private View rootView;
    private NestedScrollView nested_scroll_view;
    private View lyt_expand_text1, lyt_expand_text2, lyt_expand1, lyt_expand2;
    private ImageButton bt_toggle_text1, bt_toggle_text2;
    private Boolean chkShow1 = false;
    private Boolean chkShow2 = false;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_card, container, false);


        initComponent();

        setupExamRecyclerView();





        return rootView;
    }

    private void initComponent() {

        // First Expansion Panel
        lyt_expand_text1 = (View) rootView.findViewById(R.id.lyt_expand_text1);
        lyt_expand1 = (View) rootView.findViewById(R.id.lyt_expand);
        lyt_expand_text1.setVisibility(View.GONE);

        bt_toggle_text1 = (ImageButton) rootView.findViewById(R.id.bt_toggle1);

        bt_toggle_text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleText1(bt_toggle_text1);
            }
        });


        lyt_expand1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                toggleText1(bt_toggle_text1);

            }
        });

//

        // nested scrollview
        nested_scroll_view = (NestedScrollView) rootView.findViewById(R.id.nested_scroll_view);


        // Second Expansion Panel

        lyt_expand_text2 = (View) rootView.findViewById(R.id.lyt_expand_text2);
        lyt_expand2 = (View) rootView.findViewById(R.id.lyt_expand2);
        lyt_expand_text2.setVisibility(View.GONE);

        bt_toggle_text2 = (ImageButton) rootView.findViewById(R.id.bt_toggle2);

        bt_toggle_text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleText2(bt_toggle_text2);


            }
        });


        lyt_expand2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleText2(bt_toggle_text2);

            }
        });


    }

    private void toggleText1(View btnView) {

        if (chkShow2) {
            ViewAnimation.collapse(lyt_expand_text2);
            bt_toggle_text2.animate().setDuration(200).rotation(0);
            chkShow2 = false;
        }

        boolean show = toggleArrow(btnView);
        if (show) {

            ViewAnimation.expand(lyt_expand_text1, new ViewAnimation.AnimListener() {
                @Override
                public void onFinish() {
                    Tools.nestedScrollTo(nested_scroll_view, lyt_expand_text1);
                    chkShow1 = true;
                }
            });
        } else {
            ViewAnimation.collapse(lyt_expand_text1);
            chkShow1 = false;
        }
    }

    private void toggleText2(View btnView) {

        if (chkShow1) {
            ViewAnimation.collapse(lyt_expand_text1);
            bt_toggle_text1.animate().setDuration(200).rotation(0);
            chkShow1 = false;
        }

        boolean show = toggleArrow(btnView);
        if (show) {

            ViewAnimation.expand(lyt_expand_text2, new ViewAnimation.AnimListener() {
                @Override
                public void onFinish() {
                    Tools.nestedScrollTo(nested_scroll_view, lyt_expand_text2);
                    chkShow2 = true;
                }
            });
        } else {
            ViewAnimation.collapse(lyt_expand_text2);
            chkShow2 = false;
        }
    }

    public boolean toggleArrow(View view) {
        if (view.getRotation() == 0) {
            view.animate().setDuration(200).rotation(180);
            return true;
        } else {
            view.animate().setDuration(200).rotation(0);
            return false;
        }
    }

    private void setupExamRecyclerView() {
        RecyclerView rv_exam = rootView.findViewById(R.id.rv_exam);

        //create fake data
        List<Group> groupList = new ArrayList<Group>();

        groupList.add(new Group("همه دسته ها", "0"+ " کارت", 0));
        groupList.add(new Group("عمومی", "0"+ " کارت", 0));

        AdapterExam adapterExam = new AdapterExam(groupList, rootView.getContext());

        LinearLayoutManager layoutManager = new LinearLayoutManager(rootView.getContext());
        rv_exam.setLayoutManager(layoutManager);

        rv_exam.setAdapter(adapterExam);
    }

}

