package com.example.numbertowords_sarita;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText txtNumber;
    private TextView txtResult;
    private Button btnConvert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initiate();
        setAction();
    }
    private void initiate(){
        txtNumber=findViewById(R.id.etInput);
        txtResult=findViewById(R.id.tvOutput);
        btnConvert=findViewById(R.id.btnConvert);
    }
    private void setAction(){
        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int input = Integer.parseInt(txtNumber.getText().toString());
                Model model = new Model();

                if (input < 20) {
                    txtResult.setText(model.getOnes()[input]);
                } else if (input < 100) {
                    int tensIndex = input / 10;
                    int onesIndex = input % 10;

                    if (onesIndex != 0) {
                        txtResult.setText(model.getTens()[tensIndex] + " " +
                                model.getOnes()[onesIndex]);
                    } else {
                        txtResult.setText(model.getTens()[tensIndex]);
                    }
                } else {
                    int hundredsIndex = input / 100;
                    int remainder = input % 100;
                    int tensIndex = remainder / 10;
                    int onesIndex = remainder % 10;

                    if (onesIndex != 0) {
                        txtResult.setText(model.getOnes()[hundredsIndex] + " Hundred " +
                                model.getTens()[tensIndex] + " " + model.getOnes()[onesIndex]);
                    } else {
                        txtResult.setText(model.getOnes()[hundredsIndex] + " Hundred " +
                                model.getTens()[tensIndex]);
                    }
                }
            }});
        }
    }
