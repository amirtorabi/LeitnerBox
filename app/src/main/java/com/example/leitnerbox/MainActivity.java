package com.example.leitnerbox;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {

    Toolbar mToolbar;
    DrawerLayout mDrawer;
    NavigationView mNavi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.m_toolbar);
        setSupportActionBar(mToolbar);

        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        mNavi = (NavigationView) findViewById(R.id.navigation_view);
        mNavi.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle aToggle = new ActionBarDrawerToggle(this, mDrawer, mToolbar, R.string.open_drawer, R.string.close_drawer);
        mDrawer.addDrawerListener(aToggle);
        aToggle.syncState();



    }

    public void setSupportActionBar(Toolbar mToolbar) {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int mId = item.getItemId();

        switch (mId) {

            case R.id.test:
                Toast.makeText(this, "test Selected", Toast.LENGTH_SHORT).show();
                break;

            case R.id.amar:
                Toast.makeText(this, "amar Selected", Toast.LENGTH_SHORT).show();
                break;

            case R.id.backup:
                Toast.makeText(this, "backup Selected", Toast.LENGTH_SHORT).show();
                break;

            case R.id.restore:
                Toast.makeText(this, "restore Selected", Toast.LENGTH_SHORT).show();
                break;

            case R.id.send2excel:
                Toast.makeText(this, "send2excel  Selected", Toast.LENGTH_SHORT).show();
                break;

        }

        //change this to end
        mDrawer.closeDrawer(GravityCompat.START);

        return true;

    }

    @Override
    public void onBackPressed() {

        if (mDrawer.isDrawerOpen(GravityCompat.START)) {

            mDrawer.closeDrawer(GravityCompat.START);

        } else {

            super.onBackPressed();

        }

    }

}


