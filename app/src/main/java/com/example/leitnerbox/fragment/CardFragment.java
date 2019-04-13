package com.example.leitnerbox.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.leitnerbox.R;
import com.example.leitnerbox.utils.ViewAnimation;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class CardFragment extends Fragment {

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         view = inflater.inflate(R.layout.fragment_card, container, false);

        return inflater.inflate(R.layout.fragment_card, container, false);
    }

}
