package com.example.andrey.myapplication;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button one;
    private  TextView text;


    /////
    // Создание контекстного меню в заголовке
    /////
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
//        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case (R.id.app_bar_search):
                Toast.makeText(this, "Search clicked", Toast.LENGTH_SHORT).show();
                return true;
            case (R.id.item_1):
                Toast.makeText(this, "Item 1 clicked", Toast.LENGTH_SHORT).show();
                return true;
            case (R.id.item_2):
                Toast.makeText(this, "Item 2 clicked", Toast.LENGTH_SHORT).show();
                return true;
            case (R.id.item_3):
                Toast.makeText(this, "Item 3 clicked", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /////
    // Конец создания контекстного меню в заголовке
    /////




    /////
    // Создание контекстного меню при долгом нажатии на поле
    /////

    public static final int GROUP_ID = Menu.NONE;
    public static final int MENU_ITEM_ID = 42;
    public static final int ORDER = Menu.NONE;


    @Override
    public boolean onContextItemSelected(MenuItem item) {
//        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onContextItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if (v.getId() == R.id.tv_hello) {
            menu.add(GROUP_ID,MENU_ITEM_ID, ORDER, "Context menu");
        }
        else super.onCreateContextMenu(menu, v, menuInfo);
    }

    /////
    // Конец создания контекстного меню при долгом нажатии на поле
    /////



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getString(R.string.test);
//        testMenu = findViewById(R.id.tv_hello);


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
//                    Toast.makeText(MainActivity.this, "Это Привет!!!", Toast.LENGTH_SHORT).show();
                }
                else {
                    text.setText(getString(R.string.cool));
                    Toast.makeText(MainActivity.this, "Это Круто!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });


        registerForContextMenu(text);
//        public static final int GROUP_ID = Menu.NONE;



    }
}
