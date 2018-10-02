package com.example.tao.myapplication;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ViewFlipper;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by taoLen on 10/1/2018.
 */

public class Prologue extends AppCompatActivity {
    MediaPlayer backgroundMusic;
    MediaPlayer backgroundMusic2;
    Animation slideupAnim;

    Handler handler = new Handler();

    @BindView(R.id.prologuePart1)TextView prologuePart1;
    @BindView(R.id.firstLetter)TextView firstLetter;
    @BindView(R.id.titlePrologue)TextView titlePrologue;
    @BindView(R.id.prologue_part2)TextView prologuePart2;
    @BindView(R.id.prologue_part3)TextView prologuePart3;
    @BindView(R.id.prologue_part4)TextView prologuePart4;
    @BindView(R.id.prologue_part5)TextView prologuePart5;
    @BindView(R.id.prologue_part6)TextView prologuePart6;
    @BindView(R.id.vf_prologue)ViewFlipper viewFlipperPrologue;
    @BindView(R.id.continueBtnFromPrologue1)Button continueToPrologu2Btn;
    @BindView(R.id.continueBtnFromPrologue2)Button continueToPrologue3Btn;
    @BindView(R.id.continueBtnFromPrologue3)Button continueToPrologue4Btn;
    @BindView(R.id.continueBtnFromPrologue4)Button continueToPrologue5Btn;
    @BindView(R.id.continueBtnFromPrologue5)Button continueToPrologue6Btn;
    @BindView(R.id.continueBtnFromPrologue6)Button continueToPrologue7Btn;
    @BindView(R.id.prologue_part2b)TextView prologuePart2b;
    @BindView(R.id.prologue_part6b)TextView prologuePart6b;
    @BindView(R.id.prologue_part6c)TextView prologuePart6c;

    String userName = "";
    private static final String NAME = "userName";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prologue);
        ButterKnife.bind(this);

        backgroundMusic = MediaPlayer.create(Prologue.this, R.raw.naruto);
        backgroundMusic2 = MediaPlayer.create(Prologue.this, R.raw.shippudenfight);

        if (getApplicationContext() != null) {
            Typeface typefaceBoldItalic = Typeface.createFromAsset
                    (getAssets(), "fonts/ACaslonPro-BoldItalic.otf");
            Typeface typefaceSimpleItalic = Typeface.createFromAsset
                    (getAssets(), "fonts/ACaslonPro-Italic.otf");

            firstLetter.setTypeface(typefaceSimpleItalic);
            titlePrologue.setTypeface(typefaceBoldItalic);
            prologuePart1.setTypeface(typefaceSimpleItalic);
            prologuePart2.setTypeface(typefaceSimpleItalic);
            prologuePart3.setTypeface(typefaceSimpleItalic);
            prologuePart4.setTypeface(typefaceSimpleItalic);
            prologuePart5.setTypeface(typefaceSimpleItalic);
            prologuePart6.setTypeface(typefaceSimpleItalic);
            prologuePart2b.setTypeface(typefaceSimpleItalic);
            prologuePart6b.setTypeface(typefaceSimpleItalic);
            prologuePart6c.setTypeface(typefaceSimpleItalic);
        }

        //getting bundle from last main menu
        Bundle lastIntent = getIntent().getExtras();
        if(lastIntent != null){
            userName = lastIntent.getString(NAME);
        }

        slideupAnim =
                AnimationUtils
                        .loadAnimation(
                                getApplicationContext(), R.anim.zoom_in);

        viewFlipperPrologue.setInAnimation(AnimationUtils.loadAnimation(
                Prologue.this, android.R.anim.fade_in));
        viewFlipperPrologue.setOutAnimation(AnimationUtils.loadAnimation(
                Prologue.this, android.R.anim.fade_out));

        continueToPrologu2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prologuePart1.startAnimation(slideupAnim);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        viewFlipperPrologue.setDisplayedChild(1);
                    }
                },1000);
            }
        });
        continueToPrologue3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prologuePart2.startAnimation(slideupAnim);
                prologuePart2b.startAnimation(slideupAnim);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        viewFlipperPrologue.setDisplayedChild(2);
                    }
                },1000);
            }
        });
        continueToPrologue4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prologuePart3.startAnimation(slideupAnim);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        viewFlipperPrologue.setDisplayedChild(3);
                    }
                },1000);
            }
        });
        continueToPrologue5Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prologuePart4.startAnimation(slideupAnim);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        viewFlipperPrologue.setDisplayedChild(4);
                    }
                },1000);
            }
        });
        continueToPrologue6Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prologuePart5.startAnimation(slideupAnim);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        viewFlipperPrologue.setDisplayedChild(5);
                    }
                },1000);
            }
        });
        continueToPrologue7Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prologuePart6.startAnimation(slideupAnim);
                prologuePart2b.startAnimation(slideupAnim);
                prologuePart6b.startAnimation(slideupAnim);
                prologuePart6c.startAnimation(slideupAnim);
                backgroundMusic.stop();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        backgroundMusic2.seekTo(110000);
                        backgroundMusic2.start();
                        Intent intent = new Intent(Prologue.this, WarriorChoiceActivity.class);
                        intent.putExtra(NAME, userName);
                        startActivity(intent);
                    }
                },1000);

            }
        });

    } //onCreate

}
