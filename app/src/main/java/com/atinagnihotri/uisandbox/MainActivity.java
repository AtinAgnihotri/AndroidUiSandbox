package com.atinagnihotri.uisandbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edtTxtName;
    TextView textWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnHello = findViewById(R.id.btnHello);
        edtTxtName = findViewById(R.id.edtTxtName);
        textWelcome = findViewById(R.id.textWelcome);

//        (Way # 3)
        btnHello.setOnClickListener(this);

        // Another way to set onClickListener for the button (Way #2)
//        btnHello.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                System.out.println("Hello");
//            }
//        });
        
        // OnClickListener can be implemented for other Views as well
        // OnClickListener is a type of EventListener among many
        // For Example
        btnHello.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(MainActivity.this, "Long Pressed", Toast.LENGTH_LONG).show();
                return true;
            }
        });
    }

//    (Way # 3)
//    Implement OnClickListener in MainActivity
//    And implement it's methods
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnHello:
//                System.out.println("Hello");
                Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show();
                textWelcome.setText("Hello " + edtTxtName.getText().toString());
                break;
            default:
                break;
        }
    }

//    (Way #1)
//    One way to create a ClickListener
//    Corresponds to onClick in xml
//    public void onHelloBtnClicked(View view){
//        TextView textWelcome = findViewById(R.id.textWelcome);
//        textWelcome.setText("Hello Again!");
//    }
}