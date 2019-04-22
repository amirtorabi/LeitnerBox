package com.example.leitnerbox.model;


import android.content.Context;

import com.example.leitnerbox.R;

import java.util.ArrayList;
import java.util.List;


public class Group {
    private Context context;

    String groupName;
    String totalCartInGroup;
    int groupColor;

    public Group(String groupName, String totalCartInGroup, int groupColor) {
        this.groupName = groupName;
        this.totalCartInGroup = totalCartInGroup;
        this.groupColor = groupColor;
    }

    private List<Group> groups;




    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getTotalCartInGroup() {
        return totalCartInGroup;
    }

    public void setTotalCartInGroup(String totalCartInGroup) {
        this.totalCartInGroup = totalCartInGroup;
    }

    public int getGroupColor() {
        return groupColor;
    }

    public void setGroupColor(int groupColor) {
        this.groupColor = groupColor;
    }
}
