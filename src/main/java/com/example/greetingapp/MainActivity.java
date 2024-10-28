package com.example.greetingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText editTextGreeting;
    private Button buttonNext;
    private TextView textViewFullGreeting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextGreeting = findViewById(R.id.editTextGreeting);
        buttonNext = findViewById(R.id.buttonNext);
        textViewFullGreeting = findViewById(R.id.textViewFullGreeting);

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String greeting = editTextGreeting.getText().toString();
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("greeting", greeting);
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            String name = data.getStringExtra("name");
            String greeting = editTextGreeting.getText().toString();
            textViewFullGreeting.setText(greeting + ", " + name + "!");
        }
    }
}
