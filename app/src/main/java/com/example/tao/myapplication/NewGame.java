package com.example.tao.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by taoLen on 9/29/2018.
 */

public class NewGame extends AppCompatActivity {
    @BindView(R.id.backBtn)Button backButton;
    @BindView(R.id.mageChoice)Button mageBtnChoice;
    @BindView(R.id.userName)TextView tvUserName;
    @BindView(R.id.knightChoice)TextView knightBtnChoice;
    @BindView(R.id.rogueChoice)TextView rogueBtnChoice;

    String userName = "";
    private static final String NAME = "userName";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);
        ButterKnife.bind(this);

        //getting bundle from last main menu
        Bundle lastIntent = getIntent().getExtras();
        if(lastIntent != null){
            userName = lastIntent.getString(NAME);
        }
        tvUserName.setText(userName);

        configureBackButton();
        configureKnightOption();
        configureMageOption();
        configureRogueOption();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.game_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.new_game:
                return true;
            case R.id.help:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void configureMageOption(){
        mageBtnChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewGame.this, Prologue.class);
                intent.putExtra(NAME, userName);
                startActivity(intent);
            }
        });
    }
    private void configureKnightOption(){
        knightBtnChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewGame.this, WarriorChoiceActivity.class);
                intent.putExtra(NAME, userName);
                startActivity(intent);
            }
        });
    }
    private void configureRogueOption(){
        rogueBtnChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewGame.this, RogueChoiceActivity.class);
                intent.putExtra(NAME, userName);
                startActivity(intent);
            }
        });
    }
    private void configureBackButton(){
        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                finish();
            }
        });
    }
}
