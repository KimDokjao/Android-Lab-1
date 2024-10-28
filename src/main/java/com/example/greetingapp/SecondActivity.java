package com.example.greetingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private TextView textViewGreeting;
    private EditText editTextName;
    private Button buttonConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textViewGreeting = findViewById(R.id.textViewGreeting);
        editTextName = findViewById(R.id.editTextName);
        buttonConfirm = findViewById(R.id.buttonConfirm);

        String greeting = getIntent().getStringExtra("greeting");
        textViewGreeting.setText(greeting);

        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                Intent returnIntent = new Intent();
                returnIntent.putExtra("name", name);
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });
    }
}
