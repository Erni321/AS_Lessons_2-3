package com.example.uicomponentsapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView titleTextView;
    private TextView greetingTextView;
    private EditText nameEditText;
    private Button clickButton;
    private Button greetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleTextView = findViewById(R.id.titleTextView);
        greetingTextView = findViewById(R.id.greetingTextView);
        nameEditText = findViewById(R.id.nameEditText);
        clickButton = findViewById(R.id.clickButton);
        greetButton = findViewById(R.id.greetButton);

        clickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,
                        "Кнопка нажата!", Toast.LENGTH_SHORT).show();
                titleTextView.setText("Вы нажали на кнопку!");
            }
        });

        greetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();

                if (name.isEmpty()) {
                    Toast.makeText(MainActivity.this,
                            "Введите имя!", Toast.LENGTH_SHORT).show();
                } else {
                    greetingTextView.setText("Привет, " + name + "!");
                }
            }
        });
    }
}

