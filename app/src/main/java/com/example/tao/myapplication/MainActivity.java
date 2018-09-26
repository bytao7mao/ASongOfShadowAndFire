package com.example.tao.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ViewFlipper;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.txView)TextView userNameView;
    @BindView(R.id.hpView)TextView hpText;
    @BindView(R.id.attView)TextView attkView;
    @BindView(R.id.defView)TextView defView;
    @BindView(R.id.vf)ViewFlipper viewFlipper;
    @BindView(R.id.nextBtn)Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        userNameView.setText("Marius este TAO");
        hpText.append(" 100");
        attkView.append(" 10");
        defView.append(" 10");

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewFlipper.setDisplayedChild(1);
            }
        });
    }
}
