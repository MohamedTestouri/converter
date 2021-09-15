package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout montantTextField;
    private Button convertButton;
    private RadioButton radioButton;
    private RadioGroup radioGroup;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        montantTextField = findViewById(R.id.montant);
        convertButton = findViewById(R.id.convertButton);
        radioGroup = findViewById(R.id.currencyRadioGroup);
        result = findViewById(R.id.result);

        convertButton.setOnClickListener(l -> {
            convert();
        });
    }

    public void convert() {
        double resultCurrency = Float.parseFloat(montantTextField.getEditText().getText().toString());
        radioButton = findViewById(radioGroup.getCheckedRadioButtonId());
        Log.d("RADIO:", radioButton.getText().toString());
        if (radioButton.getText().toString().equals("Euro")) {
            resultCurrency = resultCurrency * 0.3;
            result.setText("Result: " + resultCurrency + "DT");
        } else {
            resultCurrency = resultCurrency * 3;
            result.setText("Result: " + resultCurrency + "€");
        }
    }


}