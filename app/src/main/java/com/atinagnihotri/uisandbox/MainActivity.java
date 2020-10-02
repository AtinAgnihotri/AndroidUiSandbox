package com.atinagnihotri.uisandbox;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity{

    private TextView txtHelloFont;
    private Button btnFont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtHelloFont = findViewById(R.id.txtHelloFont);
        btnFont = findViewById(R.id.btnFont);

//        Typeface typeface = getResources().getFont(R.font.me_font); // Reqs API v26 or Higher, and we've set min target at 19
        final Typeface typeface = ResourcesCompat.getFont(this, R.font.me_font);

        btnFont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtHelloFont.setTypeface(typeface);
            }
        });

    }


}