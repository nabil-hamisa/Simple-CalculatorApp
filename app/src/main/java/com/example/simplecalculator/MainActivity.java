package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener {
    Button negative, clear, clearALL, devise, multiply, minus, equal, dot, add;
    Button one, two, three, four, five, six, seven, eight, nine, zero, doubleZero;
    Double memory1 = null;
    Double memory2 = null;
    String Smemory = "";
    List<String> opMemory = new ArrayList<String>();
    Double Val;
    TextView Ioutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Ioutput = (TextView) findViewById(R.id.Result);
        Ioutput.setEnabled(false);
        /*----------------------operation--------------------*/
        // negative.findViewById(R.id.negative);
        // negative.setOnClickListener(this);

        clear = (Button) findViewById(R.id.clear);
        clear.setOnClickListener(this);

        clearALL = (Button) findViewById(R.id.clearAll);
        clearALL.setOnClickListener(this);

        devise = (Button) findViewById(R.id.devise);
        devise.setOnClickListener(this);


        multiply = (Button) findViewById(R.id.multiply);
        multiply.setOnClickListener(this);

        minus = (Button) findViewById(R.id.minus);
        minus.setOnClickListener(this);

        equal = (Button) findViewById(R.id.equals);
        equal.setOnClickListener(this);

        dot = (Button) findViewById(R.id.dot);
        dot.setOnClickListener(this);

        add = (Button) findViewById(R.id.addition);
        add.setOnClickListener(this);

        negative = (Button) findViewById(R.id.negative);
        negative.setOnClickListener(this);
        /*----------------------operation--------------------*/

        /*----------------------numbers----------------------*/
        one = (Button) findViewById(R.id.one);
        one.setOnClickListener(this);

        two = (Button) findViewById(R.id.two);
        two.setOnClickListener(this);

        three = (Button) findViewById(R.id.three);
        three.setOnClickListener(this);

        four = (Button) findViewById(R.id.four);
        four.setOnClickListener(this);

        five = (Button) findViewById(R.id.five);
        five.setOnClickListener(this);

        six = (Button) findViewById(R.id.six);
        six.setOnClickListener(this);

        seven = (Button) findViewById(R.id.seven);
        seven.setOnClickListener(this);

        eight = (Button) findViewById(R.id.eight);
        eight.setOnClickListener(this);

        nine = (Button) findViewById(R.id.nine);
        nine.setOnClickListener(this);

        zero = (Button) findViewById(R.id.zero);
        zero.setOnClickListener(this);

        doubleZero = (Button) findViewById(R.id.doublezero);
        doubleZero.setOnClickListener(this);
        /*----------------------numbers----------------------*/
    }

    public void onClick(View v) {
        /*----------------------numbers----------------------*/
        switch (v.getId()) {
            case R.id.one: {
                Ioutput.append("1");
            }
            break;
            case R.id.two: {
                Ioutput.append("2");
            }
            break;
            case R.id.three: {
                Ioutput.append("3");
            }
            break;
            case R.id.four: {
                Ioutput.append("4");
            }
            break;
            case R.id.five: {
                Ioutput.append("5");
            }
            break;
            case R.id.six: {
                Ioutput.append("6");
            }
            break;
            case R.id.seven: {
                Ioutput.append("7");
            }
            break;
            case R.id.eight: {
                Ioutput.append("8");
            }
            break;
            case R.id.nine: {
                Ioutput.append("9");
            }
            break;
            case R.id.zero: {
                Ioutput.append("0");
            }
            break;
            case R.id.doublezero: {
                Ioutput.append("00");
            }
            break;

            /*----------------------numbers----------------------*/

            /*----------------------operation--------------------*/
            case R.id.clear: {
                Ioutput.setText("");
            }
            break;
            case R.id.clearAll: {
                Ioutput.setText("");
                memory1 = null;
                memory2 = null;
                Smemory = "";
            }
            break;
            case R.id.negative: {
                String a = Ioutput.getText().toString();
                if (a.startsWith("-")) {
                    a = a.substring(1, a.length());
                    Ioutput.setText(a);
                } else {
                    a = "-" + a;
                    Ioutput.setText(a);
                }
            }
            break;
            case R.id.dot: {
                Ioutput.append(".");
            }
            break;
            case R.id.addition: {
                opMemory.add("+");
                try {
                    Smemory = Ioutput.getText().toString();
                    Val = Double.parseDouble(Smemory);
                    inputHandler(Val);
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Invalid Input!",
                            Toast.LENGTH_SHORT).show();
                }
                Ioutput.setText("");
            }
            break;
            case R.id.minus: {
                opMemory.add("-");
                try {
                    Smemory = Ioutput.getText().toString();
                    Val = Double.parseDouble(Smemory);
                    inputHandler(Val);
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Invalid Input!",
                            Toast.LENGTH_SHORT).show();
                }
                Ioutput.setText("");
            }
            break;
            case R.id.multiply: {
                opMemory.add("*");
                try {
                    Smemory = Ioutput.getText().toString();
                    Val = Double.parseDouble(Smemory);
                    inputHandler(Val);
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Invalid Input!",
                            Toast.LENGTH_SHORT).show();
                }
                Ioutput.setText("");
            }
            break;
            case R.id.devise: {
                opMemory.add("/");
                try {
                    Smemory = Ioutput.getText().toString();
                    Val = Double.parseDouble(Smemory);
                    inputHandler(Val);
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Invalid Input!",
                            Toast.LENGTH_SHORT).show();
                }
                Ioutput.setText("");

            }
            break;
            case R.id.equals: {
                try {
                    Smemory = Ioutput.getText().toString();
                    Val = Double.parseDouble(Smemory);
                    inputHandler(Val);
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Please Enter A Valid Number !",
                            Toast.LENGTH_SHORT).show();
                }
                Ioutput.setText(String.valueOf(memory1));
                memory1 = null;
            }
            break;

            /*----------------------operation--------------------*/
        }
    }

    public Double opMaker(Double a, Double b, String operation) {
        switch (operation) {
            case "+": {
                return a + b;
            }
            case "-": {
                return a - b;
            }
            case "*": {
                return a * b;
            }
            case "/": {
                return a / b;
            }
            case "=": {
                return a;
            }
            default:
                return null;
        }

    }

    public void inputHandler(Double a) {
        if ((memory1 == null) && (memory2 == null) && (a != null)) {
            memory1 = a;
        } else if ((memory2 == null) && (a != null)) {
            memory2 = a;
            for (int i = 0; i <= opMemory.size() - 1; i++) {
                memory1 = opMaker(memory1, memory2, opMemory.get(i));
                opMemory.remove(i);
                memory2 = null;
            }
        }
    }
}