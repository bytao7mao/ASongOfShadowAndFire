package com.example.tao.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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

public class NewGameActivity
        extends AppCompatActivity
        implements View.OnClickListener {

    @BindView(R.id.backBtn)Button backButton;
    @BindView(R.id.titansChoice)Button titanChoice;
    @BindView(R.id.userName)TextView tvUserName;
    @BindView(R.id.demiGodChoice)Button demiGodChoice;

    String userName = "";
    private static final String NAME = "userName";
    private static final String TITAN = "TITAN";
    private static final String DEMIGOD = "DEMIGOD";
    String titan = "Titan";
    String demigod = "DemiGod";

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
        backButton.setOnClickListener(this);
        titanChoice.setOnClickListener(this);
        demiGodChoice.setOnClickListener(this);
    }
    //---[for LANDSCAPE mode]--->
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i("GameMenuActivityTAO", "onRestoreInstanceState() " + userName);

        if (savedInstanceState!=null){
            tvUserName.setText(savedInstanceState.getString("username"));
        }
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("GameMenuActivityTAO", "onSaveInstanceStace() " + userName);

        outState.putString("username", userName);
    }
    //---[LANDSCAPE mode]---> END
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
    //[CLICK LISTENER in SWITCH MODE] --->
    @Override
    public void onClick(View view) {
        String activity = null;
        switch (view.getId()){
            case R.id.backBtn:
                activity = "back button";
                Log.i(NewGameActivity.class.getSimpleName() +"", activity);
                configureBackButton();
                break;
            case R.id.titansChoice:
                activity = "titan choice";
                Log.i(NewGameActivity.class.getSimpleName() +"", activity);
                configureTitanOption();
                break;
            case R.id.demiGodChoice:
                activity = "demigod choice";
                Log.i(NewGameActivity.class.getSimpleName() +"", activity);
                configureDemiGodOption();
                break;
            default:
                activity = "default";
                Log.i(NewGameActivity.class.getSimpleName() +"", activity);
                break;
        }
    }
    //[CLICK LISTENER in SWITCH MODE] ---> END
    //-----------------------------------------
    //[METHODS for buttons] --- >
    private void configureTitanOption(){
        Intent intent = new Intent(NewGameActivity.this, Prologue.class);
        intent.putExtra(NAME, userName);
        intent.putExtra(TITAN, titan);
        startActivity(intent);
    }
    private void configureDemiGodOption(){
        Intent intent = new Intent(NewGameActivity.this, Prologue.class);
        intent.putExtra(NAME, userName);
        intent.putExtra(DEMIGOD, demigod);
        startActivity(intent);
    }
    private void configureBackButton(){
        finish();
    }
    //[METHODS for buttons] --- > END
}
