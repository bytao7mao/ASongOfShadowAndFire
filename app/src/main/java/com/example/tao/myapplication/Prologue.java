package com.example.tao.myapplication;

import android.content.res.Resources;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
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
    Resources res;
    String god_name="";
    String god_name2 ="";
    String titan_demigod_2b="";
    String god_name_for_part_3 ="";
    String god_name_for_part_4 ="";
    String god_name_for_part_5 ="";
    String god_name_for_part_6 = "";

    @BindView(R.id.prologuePart1)TextView prologuePart1;
    @BindView(R.id.prologuePart1b)TextView prologuePart1b;
    @BindView(R.id.firstLetter)TextView firstLetter;
    @BindView(R.id.titlePrologue)TextView titlePrologue;
    @BindView(R.id.prologue_part2)TextView prologuePart2;
    @BindView(R.id.prologue_part3)TextView prologuePart3;
    @BindView(R.id.prologue_part4)TextView prologuePart4;
    @BindView(R.id.prologue_part5)TextView prologuePart5;
    @BindView(R.id.prologue_part6)TextView prologuePart6;
    @BindView(R.id.vf_prologue)ViewFlipper viewFlipperPrologue;
    @BindView(R.id.continueBtnFromPrologue1No)Button continueToPrologu2Btn;
    @BindView(R.id.continueBtnFromPrologue1Yes)Button continueToPrologu2BtnB;
    @BindView(R.id.continueBtnFromPrologue2)Button continueToPrologue3Btn;
    @BindView(R.id.continueBtnFromPrologue3)Button continueToPrologue4Btn;
    @BindView(R.id.continueBtnFromPrologue4)Button continueToPrologue5Btn;
    @BindView(R.id.continueBtnFromPrologue5)Button continueToPrologue6Btn;
    @BindView(R.id.continueBtnFromPrologue6)Button continueToPrologue7Btn;
    @BindView(R.id.prologue_part2b)TextView prologuePart2b;
    @BindView(R.id.prologue_part6b)TextView prologuePart6b;
    @BindView(R.id.prologue_part6c)TextView prologuePart6c;

    private static final String NAME = "userName";
    private static final String TITAN = "TITAN";
    private static final String DEMIGOD = "DEMIGOD";
    String userName = "";
    String titan = "";
    String demigod = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prologue);
        ButterKnife.bind(this);

        backgroundMusic = MediaPlayer.create(Prologue.this, R.raw.naruto);
        backgroundMusic2 = MediaPlayer.create(Prologue.this, R.raw.shippudenfight);
        backgroundMusic.seekTo(1500);
        backgroundMusic.start();
        //getting bundle from last main menu
        Bundle lastIntent = getIntent().getExtras();
        if(lastIntent != null) {
            userName = lastIntent.getString(NAME);
            titan = lastIntent.getString(TITAN);
            demigod = lastIntent.getString(DEMIGOD);
        }

        //settting the choices of the user with Resources class
        res = getResources();
        if (titan!=null){
            //titan: 2,4,5,6,7
            //username: 1,3
            god_name = res.getString(R.string.prologue_part1,
                    titan, titan, titan, titan);
            god_name2 = res.getString(R.string.prologue_part2,
                    userName, userName, userName, titan, titan, titan);
            titan_demigod_2b = res.getString(R.string.prologue_part2b,
                    titan);
        } else if (demigod!=null){
            //demigod: 2,4,5,6,7
            //username: 1,3
            god_name = res.getString(R.string.prologue_part1,
                    demigod, demigod, demigod, demigod);
            god_name2 = res.getString(R.string.prologue_part2,
                    userName, userName, userName, demigod, demigod, demigod);
            titan_demigod_2b = res.getString(R.string.prologue_part2b,
                    demigod);
        }
        god_name_for_part_3 = res.getString(R.string.prologue_part3,
                userName, userName, userName, userName);
        god_name_for_part_4 = res.getString(R.string.prologue_part4,
                userName, userName);
        god_name_for_part_5 = res.getString(R.string.prologue_part5,
                userName, userName, userName);
        god_name_for_part_6 = res.getString(R.string.prologue_part6,
                userName, userName);


        if (titan!=null){
            prologuePart1.setText(god_name);
            String repl = prologuePart1.getText().toString();
            repl = repl.replaceAll(titan, "<font color='red'>"+titan+"</font>");
            prologuePart1.setText(Html.fromHtml(repl));

            prologuePart2.setText(god_name2);
            String repl2 = prologuePart2.getText().toString();
            repl2 = repl2.replaceAll(titan, "<font color='red'>"+titan+"</font>");
            prologuePart2.setText(Html.fromHtml(repl2));

            prologuePart2b.setText(titan_demigod_2b);
            String repl3 = prologuePart2b.getText().toString();
            repl3 = repl3.replaceAll(titan, "<font color='red'>"+titan+"</font>");
            prologuePart2b.setText(Html.fromHtml(repl3));
        } else if (demigod!=null){
            prologuePart1.setText(god_name);
            String repl = prologuePart1.getText().toString();
            repl = repl.replaceAll(demigod, "<font color='red'>"+demigod+"</font>");
            prologuePart1.setText(Html.fromHtml(repl));

            prologuePart2.setText(god_name2);
            String repl2 = prologuePart2.getText().toString();
            repl2 = repl2.replaceAll(demigod, "<font color='red'>"+demigod+"</font>");
            prologuePart2.setText(Html.fromHtml(repl2));

            prologuePart2b.setText(titan_demigod_2b);
            String repl3 = prologuePart2b.getText().toString();
            repl3 = repl3.replaceAll(demigod, "<font color='red'>"+demigod+"</font>");
            prologuePart2b.setText(Html.fromHtml(repl3));
        }
        
        prologuePart3.setText(god_name_for_part_3);
        prologuePart4.setText(god_name_for_part_4);
        prologuePart5.setText(god_name_for_part_5);
        prologuePart6.setText(god_name_for_part_6);

        if (getApplicationContext() != null) {
            Typeface typefaceBoldItalic = Typeface.createFromAsset
                    (getAssets(), "fonts/ACaslonPro-BoldItalic.otf");
            Typeface typefaceSimpleItalic = Typeface.createFromAsset
                    (getAssets(), "fonts/ACaslonPro-Italic.otf");

            firstLetter.setTypeface(typefaceSimpleItalic);
            titlePrologue.setTypeface(typefaceBoldItalic);
            prologuePart1.setTypeface(typefaceSimpleItalic);
            prologuePart1b.setTypeface(typefaceSimpleItalic);
            prologuePart2.setTypeface(typefaceSimpleItalic);
            prologuePart3.setTypeface(typefaceSimpleItalic);
            prologuePart4.setTypeface(typefaceSimpleItalic);
            prologuePart5.setTypeface(typefaceSimpleItalic);
            prologuePart6.setTypeface(typefaceSimpleItalic);
            prologuePart2b.setTypeface(typefaceSimpleItalic);
            prologuePart6b.setTypeface(typefaceSimpleItalic);
            prologuePart6c.setTypeface(typefaceSimpleItalic);
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
        continueToPrologu2BtnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
                prologuePart6c.startAnimation(slideupAnim);
                backgroundMusic.stop();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        backgroundMusic2.seekTo(110000);
                        backgroundMusic2.start();


                        //TODO: add new intent
                    }
                },1000);
            }
        });
    } //onCreate
}
