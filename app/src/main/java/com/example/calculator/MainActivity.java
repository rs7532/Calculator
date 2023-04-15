package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {

    EditText display;
    Button plus, minus, multiply, divisor, ac, equals, credits;
    public String result;
    Intent si, gi;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.Display);

        plus = findViewById(R.id.plus_button);
        minus = findViewById(R.id.minus_button);
        multiply = findViewById(R.id.multiply_button);
        divisor = findViewById(R.id.divisor_button);
        ac = findViewById(R.id.AC_button);
        equals = findViewById(R.id.equals_button);
        credits = findViewById(R.id.credits_button);
        gi = getIntent();
    }

    @SuppressLint("SetTextI18n")
    public void plus_pressed(View view) {
        display.setText(display.getText().toString() + "+");
        display.setSelection(display.getText().length());
    }

    @SuppressLint("SetTextI18n")
    public void minus_pressed(View view) {
        display.setText(display.getText().toString() + "-");
        display.setSelection(display.getText().length());
    }

    @SuppressLint("SetTextI18n")
    public void multiply_pressed(View view) {
        display.setText(display.getText().toString() + "*");
        display.setSelection(display.getText().length());
    }

    @SuppressLint("SetTextI18n")
    public void divisor_pressed(View view) {
        display.setText(display.getText().toString() + "/");
        display.setSelection(display.getText().length());
    }

    public void equals_pressed(View view) {
        Context context = Context.enter();
        context.setOptimizationLevel(-1);
        Scriptable scriptable = context.initStandardObjects();
        result = context.evaluateString(scriptable, display.getText().toString(), "Javascript", 1, null).toString();
        result = result.replace(".0", "");
        display.setText(result);
    }

    public void AC_pressed(View view) {
        display.setText("");
    }

    public void credits_pressed(View view) {
        si = new Intent(this, Credits_Screen.class);
        si.putExtra("result", result);
        startActivity(si);
    }
}