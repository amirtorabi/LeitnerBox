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

public class AdapterGroup extends RecyclerView.Adapter<AdapterGroup.PersonViewHolder> {

    private List<Group> groupList;
    private Context context;

    public AdapterGroup(List<Group> groupList, Context context) {
        this.groupList = groupList;
        this.context = context;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_group, parent, false);


        return new PersonViewHolder(view);
    }

    //Data Binding
    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int i) {

        Group group = groupList.get(i);

        holder.txtGroupName.setText(group.getGroupName());
        holder.txtTotalCart.setText(group.getTotalCartInGroup());

    }

    @Override
    public int getItemCount() {
        return groupList.size();
    }


    class PersonViewHolder extends RecyclerView.ViewHolder {

        TextView txtGroupName;
        TextView txtTotalCart;
        View viewGroupColor;

        public PersonViewHolder(@NonNull View view) {
            super(view);

            txtGroupName = view.findViewById(R.id.txtGroupName);
            txtTotalCart = view.findViewById(R.id.txtTotalCart);
            viewGroupColor = view.findViewById(R.id.viewGroupColor);
        }
    }


}
