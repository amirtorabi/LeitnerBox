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

public class AdapterReview extends RecyclerView.Adapter<AdapterReview.OrginalHolder> {

    private List<Group> groupList;
    Context context;

    public AdapterReview(List<Group> groupList, Context context) {
        this.groupList = groupList;
        this.context = context;
    }

    @NonNull
    @Override
    public OrginalHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_exam, viewGroup, false);
        return new OrginalHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrginalHolder orginalHolder, int i) {

        Group group = groupList.get(i);

        orginalHolder.txtGroupName.setText(group.getGroupName());
        orginalHolder.txtTotalCart.setText(group.getTotalCartInGroup());


    }

    @Override
    public int getItemCount() {
        return groupList.size();
    }

    public class OrginalHolder extends RecyclerView.ViewHolder {

        TextView txtTotalCart;
        TextView txtGroupName;
        View viewGroupColor;

        public OrginalHolder(@NonNull View itemView) {
            super(itemView);

            txtTotalCart = itemView.findViewById(R.id.txtTotalCart);
            txtGroupName = itemView.findViewById(R.id.txtGroupName);
            viewGroupColor = itemView.findViewById(R.id.viewGroupColor);
        }
    }
}
