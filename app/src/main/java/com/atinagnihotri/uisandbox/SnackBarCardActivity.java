package com.atinagnihotri.uisandbox;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.snackbar.Snackbar;

public class SnackBarCardActivity extends AppCompatActivity {

    ConstraintLayout snackbarParent;
    Button btnShowSnackbar;
    MaterialCardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack_bar_card);

        snackbarParent = findViewById(R.id.snackbar_parent);
        btnShowSnackbar = findViewById(R.id.btnShowSnackbar);
        cardView = findViewById(R.id.cardView);


        btnShowSnackbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSnackBar();
            }
        });

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SnackBarCardActivity.this, "Card Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showSnackBar() {
        Snackbar.make(snackbarParent, "This is a test Snackbar", Snackbar.LENGTH_INDEFINITE)
                .setAction("Dismiss", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(SnackBarCardActivity.this, "Retry Clicked", Toast.LENGTH_SHORT).show();
                    }
                })
//                .setActionTextColor(getColor(R.color.colorBaccent)) // Works for API >= 23
//                .setActionTextColor(getResources().getColor(R.color.colorBaccent)) // This works regardless
                .setActionTextColor(Color.RED) // Using Java Color Classes
                .setTextColor(Color.YELLOW)
                .show();
    }


}