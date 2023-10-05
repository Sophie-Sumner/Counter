package com.example.counter;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class CounterActivity extends AppCompatActivity {
    private int touchCount = 0;
    private static int a = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        TextView v = findViewById(R.id.textview_3);

        Button Add = (Button) findViewById(R.id.add);
        Button Reduce = (Button) findViewById(R.id.reduce);
        Button Clear = (Button) findViewById(R.id.clear);
        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                touchCount+=a;
                v.setText("The current number is: " + Integer.toString(touchCount));
            }
        });

        Reduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                touchCount-=a;
                v.setText("The current number is: " + Integer.toString(touchCount));
            }
        });

        Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                touchCount = 0;
                v.setText("The current number is: " + Integer.toString(touchCount));
            }
        });

        Button Exit = (Button) findViewById(R.id.exit);
        Exit.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent intent = new Intent(CounterActivity.this, MainActivity.class);
                                        startActivity(intent);
                                    }
                                }
        );

        Button Set = (Button) findViewById(R.id.set);
        Set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final EditText editText = new EditText(CounterActivity.this);
                AlertDialog.Builder inputDialog =
                        new AlertDialog.Builder(CounterActivity.this);
                inputDialog.setTitle("Count-by value").setView(editText);
                inputDialog.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String inputText = editText.getText().toString();
                                try {
                                    a = Integer.parseInt(inputText);
                                    Toast.makeText(CounterActivity.this,
                                            "Change to：" + a,
                                            Toast.LENGTH_SHORT).show();
                                } catch (NumberFormatException e) {
                                    Toast.makeText(CounterActivity.this,
                                            "Please enter a valid number!",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        }).show();
        }
        });


    }
}
