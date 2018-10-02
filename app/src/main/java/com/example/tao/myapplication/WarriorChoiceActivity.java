package com.example.tao.myapplication;

import android.content.res.Resources;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WarriorChoiceActivity
        extends AppCompatActivity
        implements GlobalPlayerAttr.Warrior {

    MediaPlayer backgroundMusic;

    @BindView(R.id.hpView)TextView hpText;
    @BindView(R.id.attView)TextView attkView;
    @BindView(R.id.defView)TextView goldView;
    @BindView(R.id.vf)ViewFlipper viewFlipper;
    @BindView(R.id.toPageTwo)Button toPageTwo;
    @BindView(R.id.toPageThree)Button toPageThree;
    @BindView(R.id.toPageFour)Button toPageFour;
    @BindView(R.id.theLady)Button theLadyBtn;
    @BindView(R.id.theLover)Button theLover;
    @BindView(R.id.theSerpent)Button theSerpent;
    @BindView(R.id.toEndOfChapter)Button toEndoFChapterOne;
    @BindView(R.id.firstTv)TextView firstPageTv;
    @BindView(R.id.secondTv)TextView secondPageTv;
    @BindView(R.id.avatarId)ImageView avatarId;
    @BindView(R.id.nameView)TextView nameView;
    @BindView(R.id.toPageFive)Button toPageFive;

    String userName = "";
    private static final String NAME = "userName";
    String nameOfUserFormatted_page_two="";
    String nameOfUserFormatted_page_one="";
    String getUserName="";
    Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        backgroundMusic = MediaPlayer.create(WarriorChoiceActivity.this, R.raw.shippudenfight);

        //getting bundle from last main menu
        Bundle lastIntent = getIntent().getExtras();
        if(lastIntent != null){
            userName = lastIntent.getString(NAME);
        }

        hpText.append((String.valueOf(GlobalPlayerAttr.Warrior.HP)));
        attkView.append((String.valueOf(GlobalPlayerAttr.Warrior.ATTACK)));
        goldView.append((String.valueOf(GlobalPlayerAttr.Warrior.GOLD)));

        res = getResources();
        nameOfUserFormatted_page_one = res.getString(R.string.page_one_text, userName);
        firstPageTv.setText(nameOfUserFormatted_page_one);
        nameOfUserFormatted_page_two = res.getString(R.string.page_two_text, userName);
        secondPageTv.setText(nameOfUserFormatted_page_two);
        getUserName = res.getString(R.string.userName, userName);
        nameView.setText(getUserName);

        if (getApplicationContext() != null) {
            Typeface typefaceSimpleItalic = Typeface.createFromAsset
                    (getAssets(), "fonts/ACaslonPro-Italic.otf");
            firstPageTv.setTypeface(typefaceSimpleItalic);
            firstPageTv.setTextColor(this.getResources().getColor(R.color.colorAccent));
            firstPageTv.setTextSize(25);

        }

        viewFlipper.setInAnimation(AnimationUtils.loadAnimation(
                WarriorChoiceActivity.this, android.R.anim.fade_in));
        viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(
                WarriorChoiceActivity.this, android.R.anim.fade_out));

        toPageTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewFlipper.setDisplayedChild(1);
                hpText.setText("HP: " +(String.valueOf(GlobalPlayerAttr.Warrior.HP - 10)));

            }
        });
        toPageThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.setDisplayedChild(2);
                hpText.setText("HP: " + (String.valueOf(GlobalPlayerAttr.Warrior.HP - 30)));
            }
        });
        toPageFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.setDisplayedChild(3);
            }
        });
        toPageFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.setDisplayedChild(4);
            }
        });

        theLadyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.setDisplayedChild(1);
                GlobalPlayerAttr.BirthSign.Lady = true;
                avatarId.setImageResource(R.drawable.icon1);
            }
        });
        theLover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.setDisplayedChild(1);
                GlobalPlayerAttr.BirthSign.Lover = true;
                avatarId.setImageResource(R.drawable.icon2);
            }
        });
        theSerpent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.setDisplayedChild(1);
                GlobalPlayerAttr.BirthSign.Serpent = true;
                avatarId.setImageResource(R.drawable.icon3);
            }
        });
        toEndoFChapterOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //to another activity "Chapter #2"
                // - summary of the end of chapter
                // - 2 variants, die or go to "Chapter #2"
            }
        });



    }
}
