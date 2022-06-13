// Eric Chen
// ID: 89351145
package com.example.mycalculator;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private TextView screen;
    private TextView operationtext;
    private Button btnadd;
    private Button btnsubtract;
    private Button btnmultiply;
    private Button btndivide;
    private Button btnpower;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //set MainActivity to your layout
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        screen = (TextView) findViewById(R.id.screen);
        operationtext = (TextView) findViewById(R.id.textView2);
        btnadd = (Button) findViewById(R.id.btnadd);
        btnsubtract = (Button) findViewById(R.id.btnsubtract);
        btnmultiply = (Button) findViewById(R.id.btnmultiply);
        btndivide = (Button) findViewById(R.id.btndivide);
        btnpower = (Button) findViewById(R.id.btnpower);

        //create calculator object and connect workspace to layout workspace and initialize to 0
        final Calculator calc = new Calculator();
        screen.setText("0");
        // number buttons
        findViewById(R.id.btn0).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                screen.setText(calc.btn0()); // RETURN THE CONCATENATED INTEGER
                // reset colors and highlights when button click
                operationtext.setText("N/A");
                btnadd.setTextColor(Color.BLACK);
                btnsubtract.setTextColor(Color.BLACK);
                btnmultiply.setTextColor(Color.BLACK);
                btndivide.setTextColor(Color.BLACK);
                btnpower.setTextColor(Color.BLACK);
            }
        });
        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                screen.setText(calc.btnnum(1)); // RETURN THE CONCATENATED INTEGER
                operationtext.setText("N/A");
                btnadd.setTextColor(Color.BLACK);
                btnsubtract.setTextColor(Color.BLACK);
                btnmultiply.setTextColor(Color.BLACK);
                btndivide.setTextColor(Color.BLACK);
                btnpower.setTextColor(Color.BLACK);
            }
        });
        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                screen.setText(calc.btnnum(2)); // RETURN THE CONCATENATED INTEGER
                operationtext.setText("N/A");
                btnadd.setTextColor(Color.BLACK);
                btnsubtract.setTextColor(Color.BLACK);
                btnmultiply.setTextColor(Color.BLACK);
                btndivide.setTextColor(Color.BLACK);
                btnpower.setTextColor(Color.BLACK);
            }
        });
        findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                screen.setText(calc.btnnum(3)); // RETURN THE CONCATENATED INTEGER
                operationtext.setText("N/A");
                btnadd.setTextColor(Color.BLACK);
                btnsubtract.setTextColor(Color.BLACK);
                btnmultiply.setTextColor(Color.BLACK);
                btndivide.setTextColor(Color.BLACK);
                btnpower.setTextColor(Color.BLACK);
            }
        });
        findViewById(R.id.btn4).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                screen.setText(calc.btnnum(4)); // RETURN THE CONCATENATED INTEGER
                operationtext.setText("N/A");
                btnadd.setTextColor(Color.BLACK);
                btnsubtract.setTextColor(Color.BLACK);
                btnmultiply.setTextColor(Color.BLACK);
                btndivide.setTextColor(Color.BLACK);
                btnpower.setTextColor(Color.BLACK);
            }
        });
        findViewById(R.id.btn5).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                screen.setText(calc.btnnum(5)); // RETURN THE CONCATENATED INTEGER
                operationtext.setText("N/A");
                btnadd.setTextColor(Color.BLACK);
                btnsubtract.setTextColor(Color.BLACK);
                btnmultiply.setTextColor(Color.BLACK);
                btndivide.setTextColor(Color.BLACK);
                btnpower.setTextColor(Color.BLACK);
            }
        });
        findViewById(R.id.btn6).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                screen.setText(calc.btnnum(6)); // RETURN THE CONCATENATED INTEGER
                operationtext.setText("N/A");
                btnadd.setTextColor(Color.BLACK);
                btnsubtract.setTextColor(Color.BLACK);
                btnmultiply.setTextColor(Color.BLACK);
                btndivide.setTextColor(Color.BLACK);
                btnpower.setTextColor(Color.BLACK);
            }
        });
        findViewById(R.id.btn7).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                screen.setText(calc.btnnum(7)); // RETURN THE CONCATENATED INTEGER
                operationtext.setText("N/A");
                btnadd.setTextColor(Color.BLACK);
                btnsubtract.setTextColor(Color.BLACK);
                btnmultiply.setTextColor(Color.BLACK);
                btndivide.setTextColor(Color.BLACK);
                btnpower.setTextColor(Color.BLACK);
            }
        });
        findViewById(R.id.btn8).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                screen.setText(calc.btnnum(8)); // RETURN THE CONCATENATED INTEGER
                operationtext.setText("N/A");
                btnadd.setTextColor(Color.BLACK);
                btnsubtract.setTextColor(Color.BLACK);
                btnmultiply.setTextColor(Color.BLACK);
                btndivide.setTextColor(Color.BLACK);
                btnpower.setTextColor(Color.BLACK);
            }
        });
        findViewById(R.id.btn9).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                screen.setText(calc.btnnum(9)); // RETURN THE CONCATENATED INTEGER
                operationtext.setText("N/A");
                btnadd.setTextColor(Color.BLACK);
                btnsubtract.setTextColor(Color.BLACK);
                btnmultiply.setTextColor(Color.BLACK);
                btndivide.setTextColor(Color.BLACK);
                btnpower.setTextColor(Color.BLACK);
            }
        });
        // PRIORITY 1 operations
        findViewById(R.id.btnadd).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                screen.setText(calc.btnadd());
                // highlight current operation
                operationtext.setText("+");
                btnadd.setTextColor(Color.WHITE);
                btnsubtract.setTextColor(Color.BLACK);
                btnmultiply.setTextColor(Color.BLACK);
                btndivide.setTextColor(Color.BLACK);
                btnpower.setTextColor(Color.BLACK);
            }
        });
        findViewById(R.id.btnsubtract).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                screen.setText(calc.btnsubtract());
                // highlight current operation
                operationtext.setText("-");
                btnadd.setTextColor(Color.BLACK);
                btnsubtract.setTextColor(Color.WHITE);
                btnmultiply.setTextColor(Color.BLACK);
                btndivide.setTextColor(Color.BLACK);
                btnpower.setTextColor(Color.BLACK);

            }
        });

        // PRIORITY 2 operations
        findViewById(R.id.btnmultiply).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                screen.setText(calc.btnmultiply());
                // highlight current operation
                operationtext.setText("×");
                btnadd.setTextColor(Color.BLACK);
                btnsubtract.setTextColor(Color.BLACK);
                btnmultiply.setTextColor(Color.WHITE);
                btndivide.setTextColor(Color.BLACK);
                btnpower.setTextColor(Color.BLACK);
            }
        });

        findViewById(R.id.btndivide).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                screen.setText(calc.btndivide());
                // highlight current operation
                operationtext.setText("÷");
                btnadd.setTextColor(Color.BLACK);
                btnsubtract.setTextColor(Color.BLACK);
                btnmultiply.setTextColor(Color.BLACK);
                btndivide.setTextColor(Color.WHITE);
                btnpower.setTextColor(Color.BLACK);
            }
        });

        // PRIORITY 3 operations
        findViewById(R.id.btnpower).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                screen.setText(calc.btnpower());
                // highlight current operation
                operationtext.setText("x^y");
                btnadd.setTextColor(Color.BLACK);
                btnsubtract.setTextColor(Color.BLACK);
                btnmultiply.setTextColor(Color.BLACK);
                btndivide.setTextColor(Color.BLACK);
                btnpower.setTextColor(Color.WHITE);
            }
        });
        // equals and ac
        findViewById(R.id.btnequals).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                screen.setText(calc.btnequals());
                operationtext.setText("N/A");
                btnadd.setTextColor(Color.BLACK);
                btnsubtract.setTextColor(Color.BLACK);
                btnmultiply.setTextColor(Color.BLACK);
                btndivide.setTextColor(Color.BLACK);
                btnpower.setTextColor(Color.BLACK);
            }
        });

        findViewById(R.id.btnclear).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                screen.setText(calc.btnclear());
                operationtext.setText("N/A");
                btnadd.setTextColor(Color.BLACK);
                btnsubtract.setTextColor(Color.BLACK);
                btnmultiply.setTextColor(Color.BLACK);
                btndivide.setTextColor(Color.BLACK);
                btnpower.setTextColor(Color.BLACK);
            }
        });
        // decimal, percent, sign, make sure they ar en not in operation by using slectflag
        findViewById(R.id.btndecimal).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                if (calc.getSelectflag() == 0){
                    screen.setText(calc.btndecimal());
                }
            }
        });
        findViewById(R.id.btnpercent).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                if (calc.getSelectflag() == 0) {
                    screen.setText(calc.btnpercent());
                }
            }
        });
        findViewById(R.id.btnsign).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                if (calc.getSelectflag() == 0){
                    screen.setText(calc.btnsign());
                }
            }
        });
        // log root square
        findViewById(R.id.btnln).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                // when not cleared (number on display) and is not currently selecting operation
                if (calc.getSelectflag() == 0 && calc.getClearflag() == 0){
                    screen.setText(calc.returnLogrootsquare("ln"));
                }
                // if currently selecting operation or just cleared
                else if (calc.getSelectflag() == 1 || calc.getClearflag() == 1){
                    calc.setLogrootsquare("ln");
                    operationtext.setText("ln");
                }
            }
        });
        findViewById(R.id.btnsquare).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                // when not cleared (number on display) and is not currently selecting operation
                if (calc.getSelectflag() == 0 && calc.getClearflag() == 0){
                    screen.setText(calc.returnLogrootsquare("^2"));
                }
                // if currently selecting operation or just cleared
                else if (calc.getSelectflag() == 1 || calc.getClearflag() == 1){
                    calc.setLogrootsquare("^2");
                    operationtext.setText("x^2");
                }
            }
        });
        findViewById(R.id.btnroot).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                // when not cleared (number on display) and is not currently selecting operation
                if (calc.getSelectflag() == 0 && calc.getClearflag() == 0){
                    screen.setText(calc.returnLogrootsquare("rt"));
                }
                // if currently selecting operation or just cleared
                else if (calc.getSelectflag() == 1 || calc.getClearflag() == 1){
                    calc.setLogrootsquare("rt");
                    operationtext.setText("√");
                }
            }
        });
    }
}