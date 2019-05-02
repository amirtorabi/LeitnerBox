package com.example.leitnerbox.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.leitnerbox.R;
import com.example.leitnerbox.model.Box;
import com.example.leitnerbox.utils.FaNum;

import java.util.List;

public class AdapterBox extends RecyclerView.Adapter<AdapterBox.OriginalViewHolder> {

    Context context;
    List<Box> boxList;

    public AdapterBox(Context context, List<Box> boxList) {
        this.context = context;
        this.boxList = boxList;
    }

    @NonNull
    @Override
    public OriginalViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_box, viewGroup,false);
        return new OriginalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OriginalViewHolder holder, int i) {

        Box box = boxList.get(i);

        holder.tvBoxTitle.setText(FaNum.convert2PerisanNumber(box.getBoxNumber()));
        holder.tvBoxCartNumber.setText(FaNum.convert2PerisanNumber(box.getBoxTotalCards()));


    }

    @Override
    public int getItemCount() {
        return boxList.size();
    }

    public class OriginalViewHolder extends RecyclerView.ViewHolder {

        TextView tvBoxTitle;
        TextView tvBoxCartNumber;

        public OriginalViewHolder(@NonNull View view) {
            super(view);

            tvBoxTitle = view.findViewById(R.id.tvBoxTitle);
            tvBoxCartNumber = view.findViewById(R.id.tvBoxCartNumber);


        }
    }
}