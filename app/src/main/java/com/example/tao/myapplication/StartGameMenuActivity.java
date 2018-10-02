package com.example.tao.myapplication;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by taoLen on 9/29/2018.
 */

public class StartGameMenuActivity
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
    MediaPlayer backgroundMusic;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_game_menu_activity);
        ButterKnife.bind(this);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            editTxt.setShowSoftInputOnFocus(false);
        }
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        backgroundMusic = MediaPlayer.create(StartGameMenuActivity.this, R.raw.naruto);
        if (getApplicationContext() != null) {
            Typeface typefaceBoldItalic = Typeface.createFromAsset
                    (getAssets(), "fonts/ACaslonPro-BoldItalic.otf");
            tvStartGame.setTypeface(typefaceBoldItalic);
        }


        //start new game sending to NewGame intent
        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                configureStartBtn();
            }

            private void configureStartBtn() {
                backgroundMusic.seekTo(1500);
                backgroundMusic.start();
                userName = editTxt.getText().toString();
                if (TextUtils.isEmpty(userName)) {
                    editTxt.setError("Please input a userName");
                    return;
                }
                Intent i = new Intent(StartGameMenuActivity.this, NewGame.class);
                i.putExtra(NAME, userName);
                startActivity(i);
            }
        });


        optionsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                    boolean settingsCanWrite = Settings.System.canWrite(getApplicationContext());
                    if(!settingsCanWrite) {
                        // If do not have write settings permission then open the Can modify system settings panel.
                        Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS);
                        startActivity(intent);
                    }else {
                        // If has permission then show an alert dialog with message.
                        AlertDialog alertDialog = new AlertDialog.Builder(StartGameMenuActivity.this).create();
                        alertDialog.setMessage("You have system write settings permission now.");
                        alertDialog.show();
                    }
                }
                startActivity(new Intent(StartGameMenuActivity.this, OptionsActivity.class));
            }
        });


    }


    @Override
    public void onClick(View v) {
        Bundle params = new Bundle();
        params.putInt("ButtonID", v.getId());
        String btnName;
        switch (v.getId()) {
            case R.id.newGamebtn:
                btnName = "New Game Clicked";
                Log.d(StartGameMenuActivity.class.getSimpleName() + "", btnName);
                break;
            case R.id.optionsBtn:
                btnName = "Options Btn clicked";
                Log.d(StartGameMenuActivity.class.getSimpleName() + "", btnName);
                startActivity(new Intent(StartGameMenuActivity.this, OptionsActivity.class));
                break;
            default:
                btnName = "OtherButton";
                Log.d(StartGameMenuActivity.class.getSimpleName() + "", btnName);
                break;
        }
    }
}
