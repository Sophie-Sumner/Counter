package com.example.counter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    protected static boolean flag = false;

    private int touchCount = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        View v = findViewById(R.id.textview_2);

        Button Hid_Sh = (Button) findViewById(R.id.hide_show);
        Hid_Sh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(touchCount%2 == 0)
                {
                    Hid_Sh.setText("Show");
                    v.setVisibility(View.INVISIBLE);

                }
                else {
                    Hid_Sh.setText("Hide");
                    v.setVisibility(View.VISIBLE);
                }
                touchCount++;
            }
            });

        Button Exit = (Button) findViewById(R.id.exit);
        Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = true;
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        }
        );
    }


}
