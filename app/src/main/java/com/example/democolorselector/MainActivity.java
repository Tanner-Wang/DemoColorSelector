package com.example.democolorselector;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements ColorPicker.OnColorSelectedListener {

    private ColorPicker picker;
    private Button button;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        picker = (ColorPicker) findViewById(R.id.picker);
        button = (Button) findViewById(R.id.button1);
        text = (TextView) findViewById(R.id.textView1);

        picker.setOnColorSelectedListener(this);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                text.setTextColor(picker.getColor());
                picker.setOldCenterColor(picker.getColor());
            }
        });
    }

    @Override
    public void onColorSelected(String color) {
        text.setTextColor(picker.getColor());
        text.setText(String.valueOf(color));
    }
}
