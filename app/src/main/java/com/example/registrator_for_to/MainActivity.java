package com.example.registrator_for_to;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.ColorSpace;
import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
    FrameLayout mainFrame;  // переменная в которой храниться mainFrame
    static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainFrame = findViewById(R.id.mainFrame); // находим переменую
        fragmentManager = getSupportFragmentManager(); // обращаемся к фрагмент менеджеру
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction(); //
        fragmentTransaction.add(R.id.mainFrame, new AuthFragment()).commit();  // у fragmentTransaction, вызываем метод add и добавляем на экран новый фрагмент
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Connector.connect();
            }
        });
        thread.start();
    }
}