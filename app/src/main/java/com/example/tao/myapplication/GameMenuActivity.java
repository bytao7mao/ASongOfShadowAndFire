package com.example.tao.myapplication;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by taoLen on 9/29/2018.
 */

public class GameMenuActivity
        extends AppCompatActivity
        implements View.OnClickListener {

    private static final String NAME = "userName";
    String userName = "";
    @BindView(R.id.newGamebtn)
    Button startGame;
    @BindView(R.id.editTxt)
    EditText editTxt;
    @BindView(R.id.tvStartGame)
    TextView tvStartGame;
    @BindView(R.id.optionsBtn)
    Button optionsBtn;
    MediaPlayer menuMusic;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_menu_activity);
        ButterKnife.bind(this);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        menuMusic = MediaPlayer.create(GameMenuActivity.this, R.raw.medici);
        if (getApplicationContext() != null) {
            Typeface typefaceBoldItalic = Typeface.createFromAsset
                    (getAssets(), "fonts/ACaslonPro-BoldItalic.otf");
            tvStartGame.setTypeface(typefaceBoldItalic);
        }
        menuMusic.start();
        menuMusic.setLooping(true);

        startGame.setOnClickListener(this);
        optionsBtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Bundle params = new Bundle();
        params.putInt("ButtonID", v.getId());
        String btnName;
        switch (v.getId()) {
            case R.id.newGamebtn:
                btnName = "New Game Clicked";
                Log.d(GameMenuActivity.class.getSimpleName() + "", btnName);
                //start new game sending to NewGameActivity intent
                configureStartNewButton();
                break;
            case R.id.optionsBtn:
                btnName = "Options Btn clicked";
                Log.d(GameMenuActivity.class.getSimpleName() + "", btnName);
                //startActivity(new Intent(GameMenuActivity.this, OptionsActivity.class));
                optionsBtnStart();
                break;
            default:
                btnName = "OtherButton";
                Log.d(GameMenuActivity.class.getSimpleName() + "", btnName);
                break;
        }
    }
    private void configureStartNewButton() {
        menuMusic.stop();
        userName = editTxt.getText().toString();
        if (TextUtils.isEmpty(userName)) {
            editTxt.setError("Please input a userName");
            return;
        }
        Intent i = new Intent(GameMenuActivity.this, NewGameActivity.class);
        i.putExtra(NAME, userName);
        startActivity(i);
    }
    private void optionsBtnStart(){
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            boolean settingsCanWrite = Settings.System.canWrite(getApplicationContext());
            if(!settingsCanWrite) {
                // If do not have write settings permission then open the Can modify system settings panel.
                Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS);
                startActivity(intent);
            }else {
                // If has permission then show an alert dialog with message.
                AlertDialog alertDialog = new AlertDialog.Builder(GameMenuActivity.this).create();
                alertDialog.setMessage("You have system write settings permission now.");
                alertDialog.show();
            }
        }
        startActivity(new Intent(GameMenuActivity.this, OptionsActivity.class));
    }
}
