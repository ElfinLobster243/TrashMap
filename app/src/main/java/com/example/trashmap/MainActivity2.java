package com.example.trashmap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.trashmap.R;
import com.example.trashmap.MainActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitle(R.string.t);
        Button button = findViewById(R.id.button);
    }

    public void prox(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}