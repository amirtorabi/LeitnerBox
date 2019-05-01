package com.example.leitnerbox.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.leitnerbox.R;
import com.example.leitnerbox.model.Group;

import java.util.List;

public class AdapterExam extends RecyclerView.Adapter<AdapterExam.OrginalViewHolder> {

    List<Group> groupList;
    Context context;

    public AdapterExam(List<Group> groupList, Context context) {
        this.groupList = groupList;
        this.context = context;
    }

    @NonNull
    @Override
    public OrginalViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemView = LayoutInflater.from(context).inflate(R.layout.item_group, viewGroup,false);
        return new OrginalViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull OrginalViewHolder orginalViewHolder, int i) {

        Group groupItem = groupList.get(i);
        orginalViewHolder.txtGroupName.setText(groupItem.getGroupName());
        orginalViewHolder.txtTotalCart.setText(groupItem.getTotalCartInGroup());

    }

    @Override
    public int getItemCount() {
        return groupList.size();
    }

    public class OrginalViewHolder extends RecyclerView.ViewHolder {

        TextView txtTotalCart;
        TextView txtGroupName;
        View viewGroupColor;

        public OrginalViewHolder(@NonNull View itemView) {
            super(itemView);

            txtTotalCart = itemView.findViewById(R.id.txtTotalCart);
            txtGroupName = itemView.findViewById(R.id.txtGroupName);
            viewGroupColor = itemView.findViewById(R.id.viewGroupColor);
        }
    }
}
