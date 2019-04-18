package com.example.leitnerbox.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.daimajia.numberprogressbar.NumberProgressBar;
import com.daimajia.numberprogressbar.OnProgressBarListener;
import com.example.leitnerbox.R;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class ProgressBarActivity extends AppCompatActivity {

    NumberProgressBar numberProgressBar;
    CardView myCardView;
    private Animation animation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);

        setupNumberProgressBar();

         animation = AnimationUtils.loadAnimation(this, R.anim.swing_up_left);


        animateCard();


    }

    //Add font to this activity
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    public void setupNumberProgressBar() {

        numberProgressBar = findViewById(R.id.number_progress_bar);

        //Remove % sign
        numberProgressBar.setSuffix(null);

        numberProgressBar.setProgress(0);


//Add to progress
        //        btnSetProgrss.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                numberProgressBar.incrementProgressBy(1);
//            }
//        });

        numberProgressBar.setOnProgressBarListener(new OnProgressBarListener() {
            @Override
            public void onProgressChange(int current, int max) {
                if (current == max) {

                    //progress finished
                    numberProgressBar.setProgress(0);
                    Toast.makeText(ProgressBarActivity.this, "Finish", Toast.LENGTH_SHORT).show();
                }
            }


        });
    }

    public void animateCard() {

        myCardView = findViewById(R.id.myCardView);

        myCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCardView.startAnimation(animation);

            }
        });

    }

}
