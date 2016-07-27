package com.lyj.gitdemo.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lyj.gitdemo.R;

public class LeadActivity extends AppCompatActivity {
    private Button btnLogin,btnEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        btnEnter= (Button) findViewById(R.id.btnEnter);
        btnLogin= (Button) findViewById(R.id.btnLogin);
        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LeadActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
