package com.example.leitnerbox;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.leitnerbox.activity.SettingActivity;
import com.example.leitnerbox.adapter.ViewPagerAdapter;
import com.example.leitnerbox.fragment.CardFragment;
import com.example.leitnerbox.fragment.HomeFragment;
import com.example.leitnerbox.utils.ViewAnimation;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar mToolbar;
    DrawerLayout mDrawer;
    NavigationView mNavi;
    TabLayout tabLayout;
    ViewPager viewPager;

    //FOR FAB
    private View back_drop;
    private boolean rotate = false;
    private View lyt_new_group, lyt_import_flash_cart, lyt_prepare_flash_cart, lyt_new_cart;
    //FOR FAB

    HomeFragment homeFragment;
    CardFragment cardFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initToolbar();
        initNavigationMenu();

        setupViewPager();

        setupFab();


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

            case R.id.setting:
                startActivity(new Intent(this, SettingActivity.class));
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

    //Add font to this activity
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    private void initToolbar() {


        mToolbar = (Toolbar) findViewById(R.id.m_toolbar);
        setSupportActionBar(mToolbar);

    }

    private void initNavigationMenu() {


        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        mNavi = (NavigationView) findViewById(R.id.navigation_view);
        mNavi.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle aToggle = new ActionBarDrawerToggle(this, mDrawer, mToolbar, R.string.open_drawer, R.string.close_drawer);
        mDrawer.addDrawerListener(aToggle);
        aToggle.syncState();
    }

    private void setupViewPager() {
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        viewPagerAdapter.addFragment(homeFragment = new HomeFragment(), "خانه");
        viewPagerAdapter.addFragment(cardFragment = new CardFragment(), "مشاهده کارت ها");

        viewPager.setAdapter(viewPagerAdapter);

        // set the default tab to the second tab
        viewPager.setCurrentItem(1);

        tabLayout.setupWithViewPager(viewPager);

    }

    public void setSupportActionBar(Toolbar mToolbar) {

    }

    //FAB
    private void setupFab() {

        back_drop = findViewById(R.id.back_drop);

        final FloatingActionButton fab_new_group = (FloatingActionButton) findViewById(R.id.fab_new_group);
        final FloatingActionButton fab_import_flash_cart = (FloatingActionButton) findViewById(R.id.fab_import_flash_cart);
        final FloatingActionButton fab_prepare_flash_cart = (FloatingActionButton) findViewById(R.id.fab_prepare_flash_cart);
        final FloatingActionButton fab_new_cart = (FloatingActionButton) findViewById(R.id.fab_new_cart);
        final FloatingActionButton fab_add = (FloatingActionButton) findViewById(R.id.fab_add);

        lyt_new_group = findViewById(R.id.lyt_new_group);
        lyt_import_flash_cart = findViewById(R.id.lyt_import_flash_cart);
        lyt_prepare_flash_cart = findViewById(R.id.lyt_prepare_flash_cart);
        lyt_new_cart = findViewById(R.id.lyt_new_cart);

        ViewAnimation.initShowOut(lyt_new_group);
        ViewAnimation.initShowOut(lyt_import_flash_cart);
        ViewAnimation.initShowOut(lyt_prepare_flash_cart);
        ViewAnimation.initShowOut(lyt_new_cart);
        back_drop.setVisibility(View.GONE);

        fab_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleFabMode(v);
            }
        });

        back_drop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleFabMode(fab_add);
            }
        });

        fab_new_group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "fab_new_group clicked", Toast.LENGTH_SHORT).show();

                ViewAnimation.showOut(lyt_new_group);
                toggleFabMode(fab_add);

            }
        });

        fab_import_flash_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "fab_import_flash_cart clicked", Toast.LENGTH_SHORT).show();
                toggleFabMode(fab_add);

            }
        });

        fab_prepare_flash_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "fab_prepare_flash_cart clicked", Toast.LENGTH_SHORT).show();
                toggleFabMode(fab_add);

            }
        });

        fab_new_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "fab_new_cart clicked", Toast.LENGTH_SHORT).show();
                toggleFabMode(fab_add);

            }
        });

    }

    private void toggleFabMode(View v) {
        rotate = ViewAnimation.rotateFab(v, !rotate);
        if (rotate) {
            ViewAnimation.showIn(lyt_new_group);
            ViewAnimation.showIn(lyt_import_flash_cart);
            ViewAnimation.showIn(lyt_prepare_flash_cart);
            ViewAnimation.showIn(lyt_new_cart);
            back_drop.setVisibility(View.VISIBLE);
        } else {
            ViewAnimation.showOut(lyt_new_group);
            ViewAnimation.showOut(lyt_import_flash_cart);
            ViewAnimation.showOut(lyt_prepare_flash_cart);
            ViewAnimation.showOut(lyt_new_cart);
            back_drop.setVisibility(View.GONE);
        }
    }


}


