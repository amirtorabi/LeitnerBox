package com.example.leitnerbox.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.leitnerbox.R;
import com.example.leitnerbox.utils.Tools;
import com.example.leitnerbox.utils.ViewAnimation;

public class CardFragment extends Fragment {

    private View rootView;

    //++++++++++++++
    private View parent_view;

    private NestedScrollView nested_scroll_view;
    private View lyt_expand_text, lyt_expand_text2, lyt_expand, lyt_expand2;
    private ImageButton bt_toggle_text, bt_toggle_text2;
    private Boolean chkShow = false;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_card, container, false);


        initComponent();

        return rootView;
    }


    private void initComponent() {

        // First Expansion Panel
        lyt_expand_text = (View) rootView.findViewById(R.id.lyt_expand_text);
        lyt_expand = (View) rootView.findViewById(R.id.lyt_expand);
        lyt_expand_text.setVisibility(View.GONE);

        bt_toggle_text = (ImageButton) rootView.findViewById(R.id.bt_toggle1);

        bt_toggle_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleText1(bt_toggle_text, lyt_expand_text);
            }
        });


        lyt_expand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                toggleText1(bt_toggle_text, lyt_expand_text);

            }
        });

//        // input section
//        bt_toggle_input = (ImageButton) rootView.findViewById(R.id.bt_toggle_input);
//        bt_hide_input = (Button) rootView.findViewById(R.id.bt_hide_input);
//        bt_save_input = (Button) rootView.findViewById(R.id.bt_save_input);
//        lyt_expand_input = (View) rootView.findViewById(R.id.lyt_expand_input);
//        lyt_expand_input.setVisibility(View.GONE);
//
//        bt_toggle_input.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                toggleSectionInput(bt_toggle_input);
//            }
//        });
//
//        bt_hide_input.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                toggleSectionInput(bt_toggle_input);
//            }
//        });
//
//        bt_save_input.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(parent_view, "Data saved", Snackbar.LENGTH_SHORT).show();
//                toggleSectionInput(bt_toggle_input);
//            }
//        });

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
                toggleText1(bt_toggle_text2, lyt_expand_text2);


            }
        });


        lyt_expand2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleText1(bt_toggle_text2, lyt_expand_text2);

            }
        });


    }

    private void toggleText1(View btnView, final View layout) {

        if (chkShow) {
            ViewAnimation.collapse(layout);
            chkShow = false;
        }

        boolean show = toggleArrow(btnView);
        if (show) {

            ViewAnimation.expand(layout, new ViewAnimation.AnimListener() {
                @Override
                public void onFinish() {
                    Tools.nestedScrollTo(nested_scroll_view, layout);
                    chkShow = true;
                }
            });
        } else {
            ViewAnimation.collapse(layout);

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

}

