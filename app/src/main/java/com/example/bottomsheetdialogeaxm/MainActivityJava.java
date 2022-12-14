package com.example.bottomsheetdialogeaxm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivityJava extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_java);

        Button button = findViewById(R.id.showDialogBtn);

        button.setOnClickListener(v -> {
            BottomSheetFragmentJava bottomSheetFragment = new BottomSheetFragmentJava();
            bottomSheetFragment.show(getSupportFragmentManager(), bottomSheetFragment.getTag());
        });
    }
}