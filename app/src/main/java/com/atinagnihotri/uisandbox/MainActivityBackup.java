package com.atinagnihotri.uisandbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivityBackup extends AppCompatActivity implements View.OnClickListener {

    EditText edtTxtName;
    TextView textWelcome;
    CheckBox chkBoxHarry, chkBoxMatrix, chkBoxJoker;
    RadioButton rbMarried;
    RadioGroup rgMaritalStatus;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnHello = findViewById(R.id.btnHello);
        edtTxtName = findViewById(R.id.edtTxtName);
        textWelcome = findViewById(R.id.textWelcome);
        chkBoxHarry = findViewById(R.id.chkBoxHarry);
        chkBoxMatrix = findViewById(R.id.chkBoxMatrix);
        chkBoxJoker = findViewById(R.id.chkBoxJoker);
        rbMarried = findViewById(R.id.rbMarried);
        rgMaritalStatus = findViewById(R.id.rgMaritalStatus);
        progressBar = findViewById(R.id.progessBar);

        int checkedRgButton = rgMaritalStatus.getCheckedRadioButtonId();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<10; i++){
                    progressBar.incrementProgressBy(10);
//                    Thread.sleep(500);
                    SystemClock.sleep(500);
                }
            }
        });

        thread.start();

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
                Toast.makeText(MainActivityBackup.this, "Long Pressed", Toast.LENGTH_LONG).show();
                return true;
            }
        });

        if (chkBoxHarry.isChecked()){
            Toast.makeText(MainActivityBackup.this, "You have watched Harry Porter", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivityBackup.this, "You need to watch Harry Porter", Toast.LENGTH_SHORT).show();
        }

        // Similarly can also be implemented on Class level, with overridden methods
        chkBoxHarry.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(MainActivityBackup.this, "You have watched Harry Porter", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivityBackup.this, "You need to watch Harry Porter", Toast.LENGTH_SHORT).show();
                }
            }
        });

        rgMaritalStatus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rbMarried:
                        Toast.makeText(MainActivityBackup.this, "Married", Toast.LENGTH_SHORT).show();
//                        progressBar.setVisibility(View.GONE);
                        break;
                    case R.id.rbSingle:
                        Toast.makeText(MainActivityBackup.this, "Single", Toast.LENGTH_SHORT).show();
//                        progressBar.setVisibility(View.VISIBLE);
                        break;
                    case R.id.rbInRel:
                        Toast.makeText(MainActivityBackup.this, "In Relationship", Toast.LENGTH_SHORT).show();
//                        progressBar.setVisibility(View.GONE);
                        break;
                    default:
                        break;
                }
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
//                Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show();
                textWelcome.setText("Hello " + edtTxtName.getText().toString());
                break;
            case R.id.edtTxtName:
                System.out.println("Edit text was pressed");
                Toast.makeText(this, "Attempting to type something", Toast.LENGTH_LONG).show();
                break;
//            case R.id.textWelcome:
//                System.out.println("TextView was pressed");
//                break;
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