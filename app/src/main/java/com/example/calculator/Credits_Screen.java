package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Credits_Screen extends AppCompatActivity {
    Button return_btn;
    TextView tv;
    Intent gi, si;
    String result;

    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits_screen);

        return_btn = findViewById(R.id.Return_button);
        tv = findViewById(R.id.TV);

        gi = getIntent();
        result = gi.getStringExtra("result");
        tv.setText("last result was: "+result);
    }

    public void back_pressed(View view) {
        Intent si = new Intent(this, MainActivity.class);
        startActivity(si);
    }
}