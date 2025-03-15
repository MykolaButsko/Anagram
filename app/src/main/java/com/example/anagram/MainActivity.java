package com.example.anagram;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public EditText enterText;
    public EditText enterSymbols;
    public TextView yourResult;
    public Button button;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterText = findViewById(R.id.enterTextForAnagram);
        enterSymbols = findViewById(R.id.enterSymbolsToIgnore);
        button = findViewById(R.id.convertButton);
        yourResult = findViewById(R.id.yourAnagram);

        button.setOnClickListener(view -> {
            String inputUser = enterText.getText().toString();
            String ignoreSymbol = enterSymbols.getText().toString();

            if (!inputUser.isEmpty()) {
                String result = ReversWords.anagramOfWords(inputUser, ignoreSymbol);
                yourResult.setText(result);
            } else {
                yourResult.setText(getString(R.string.here_must_be_your_anagram));
            }
        });
    }
}