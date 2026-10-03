package com.example.test3;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    String deg_rad_mode = "degree mode"; /*default*/

    /*
    NUMBERS SECTION
    */
    public void onClick1(View v) {
        Log.d("MainActivity", "Button clicked");
        TextView label = findViewById(R.id.numbers_lbl);
        label.setText(label.getText() + "1");
    }
    public void onClick2(View v) {
        TextView label = findViewById(R.id.numbers_lbl);
        label.setText(label.getText() + "2");
    }
    public void onClick3(View v) {
        TextView label = findViewById(R.id.numbers_lbl);
        label.setText(label.getText() + "3");
    }
    public void onClick4(View v) {
        TextView label = findViewById(R.id.numbers_lbl);
        label.setText(label.getText() + "4");
    }
    public void onClick5(View v) {
        TextView label = findViewById(R.id.numbers_lbl);
        label.setText(label.getText() + "5");
    }
    public void onClick6(View v) {
        TextView label = findViewById(R.id.numbers_lbl);
        label.setText(label.getText() + "6");
    }
    public void onClick7(View v) {
        TextView label = findViewById(R.id.numbers_lbl);
        label.setText(label.getText() + "7");
    }
    public void onClick8(View v) {
        TextView label = findViewById(R.id.numbers_lbl);
        label.setText(label.getText() + "8");
    }
    public void onClick9(View v) {
        TextView label = findViewById(R.id.numbers_lbl);
        label.setText(label.getText() + "9");
    }
    public void onClick0(View v) {
        TextView label = findViewById(R.id.numbers_lbl);
        label.setText(label.getText() + "0");
    }


    /*
    OPERATIONS SECTION
     */
    public void sum(View v) {
        TextView label = findViewById(R.id.numbers_lbl);
        String n = label.getText().toString();
        label.setText(n+"+");
    }
    public void minus(View v) {
        TextView label = findViewById(R.id.numbers_lbl);
        String n = label.getText().toString();
        label.setText(n+"-");
    }
    public void multiply(View v) {
        TextView label = findViewById(R.id.numbers_lbl);
        String n = label.getText().toString();
        label.setText(n+"*");
    }
    public void divide(View v) {
        TextView label = findViewById(R.id.numbers_lbl);
        String n = label.getText().toString();
        label.setText(n+"/");
    }
    public void sin(View v) {
        TextView label = findViewById(R.id.numbers_lbl);
        String n = label.getText().toString();
        label.setText(n+"sin(");
    }
    public void cos(View v) {
        TextView label = findViewById(R.id.numbers_lbl);
        String n = label.getText().toString();
        label.setText(n+"cos(");
    }
    public void tan(View v) {
        TextView label = findViewById(R.id.numbers_lbl);
        String n = label.getText().toString();
        label.setText(n+"tan(");
    }
    public void deg_rad(View v) {
        TextView label = findViewById(R.id.lbl_deg_rad);
        Button btn = findViewById(R.id.btn_deg_rad);
        if (deg_rad_mode == "degree mode") {
            deg_rad_mode = "radian mode";
            btn.setText("deg");
        }
        else {
            deg_rad_mode = "degree mode";
            btn.setText("rad");
        }

        label.setText(deg_rad_mode);
    }
    public void dot(View v) {
        TextView label = findViewById(R.id.numbers_lbl);
        String n = label.getText().toString();
        label.setText(n+".");
    }
    public void close_parenthesis(View v) {
        TextView label = findViewById(R.id.numbers_lbl);
        String n = label.getText().toString();
        label.setText(n+")");
    }


    /*
    MORE
     */
    public void equal(View v) {
        TextView label = findViewById(R.id.numbers_lbl);
        String expression = label.getText().toString();

        double result = calculate(expression);

        label.setText(String.valueOf(result));
    }
    public double calculate(String expression) {
        String[] numbers = expression.split("[+\\-*/]");
        String[] operators = expression.split("[0-9.]+|sin\\([^)]*\\)|cos\\([^)]*\\)|tan\\([^)]*\\)");

        double result = evaluate(numbers[0]);

        for (int i = 1; i < numbers.length; i++) {
            String operator = operators[i].trim();
            double number = evaluate(numbers[i]);

            switch (operator) {
                case "+":
                    result += number;
                    break;
                case "-":
                    result -= number;
                    break;
                case "*":
                    result *= number;
                    break;
                case "/":
                    result /= number;
                    break;
            }
        }

        return result;
    }
    public double evaluate(String trig) {
        trig = trig.trim();

        if (trig.startsWith("sin(")) {
            double num = Double.parseDouble(trig.substring(4, trig.length() - 1)); /*extracts num from the given indexes: sin( *** ) */
            if (deg_rad_mode == "radian mode")
            {
                return Math.sin(Math.toRadians(num));
            }
            else {
                return Math.sin(num);
            }
        }

        else if (trig.startsWith("cos(")) {
            double num = Double.parseDouble(trig.substring(4, trig.length() - 1));
            if (deg_rad_mode == "radian mode")
            {
                return Math.cos(Math.toRadians(num));
            }
            else {
                return Math.cos(num);
            }
        }

        else if (trig.startsWith("tan(")) {
            double num = Double.parseDouble(trig.substring(4, trig.length() - 1));
            if (deg_rad_mode == "radian mode")
            {
                return Math.tan(Math.toRadians(num));
            }
            else {
                return Math.tan(num);
            }
        }
        return Double.parseDouble(trig);
    }
    public void ce(View v) {
        TextView label = findViewById(R.id.numbers_lbl);
        label.setText("");
    }

}
