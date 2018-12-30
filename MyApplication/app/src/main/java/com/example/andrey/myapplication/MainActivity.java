package com.example.andrey.myapplication;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button one;
    private  TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getString(R.string.test);


        // Работа с цветами

        // getColor(R.color.red); // Поддерживается только начиная в 23 API

        // Вариант 1
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            Integer red = getColor(R.color.red);
        }

        // Вариант 2
        ContextCompat.getColor(this, R.color.red);



        // Получение элементов из активити хмл
        one = findViewById(R.id.button1);
        text = findViewById(R.id.tv_hello);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (text.getText() == getString(R.string.cool)) {
                    text.setText(getString(R.string.hello_world));
                }
                else text.setText(getString(R.string.cool));
            }
        });
    }
}
