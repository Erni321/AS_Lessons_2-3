package com.example.uicomponentsapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Объявляем переменные для элементов экрана
    private CheckBox cheeseBox;
    private CheckBox baconBox;
    private Button checkButton;
    private RadioGroup sizeRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Связываем переменные с ID из XML
        cheeseBox = findViewById(R.id.cheeseBox);
        baconBox = findViewById(R.id.baconBox);
        checkButton = findViewById(R.id.checkButton);
        sizeRadioGroup = findViewById(R.id.sizeRadioGroup);

        // 2. Обрабатываем нажатие кнопки "Проверить выбор"
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String message = ""; // Сюда будем собирать текст результата

                // --- ШАГ А: Проверяем, какой размер выбран (RadioGroup) ---
                // Получаем ID выбранной радио-кнопки
                int selectedId = sizeRadioGroup.getCheckedRadioButtonId();

                if (selectedId == R.id.smallRadio) {
                    message += "Размер: Маленькая\n";
                } else if (selectedId == R.id.mediumRadio) {
                    message += "Размер: Средняя\n";
                } else if (selectedId == R.id.largeRadio) {
                    message += "Размер: Большая\n";
                }

                // --- ШАГ Б: Проверяем галочки (CheckBox) ---
                message += "Добавки: ";

                if (cheeseBox.isChecked()) {
                    message += "Сыр ";
                }
                if (baconBox.isChecked()) {
                    message += "Бекон ";
                }

                // --- ШАГ В: Выводим результат ---
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
            }
        });
    }
}
