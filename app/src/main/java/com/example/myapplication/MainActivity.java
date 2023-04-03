package com.example.myapplication;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextClock;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.MissingResourceException;

public class MainActivity extends AppCompatActivity {
    private LinearLayout mainContainer;
    private ArrayList<EditText>editTexts;
    private Button btnAdd, btnRemove, btnSum, btnDifference;
    private TextView txtResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTexts = new ArrayList<EditText>();

        initViews();
        setupListener();


    }
    private void initViews () {
        mainContainer = findViewById(R.id.mainContainer);
        txtResult = findViewById(R.id.txtResult);
        btnAdd = findViewById(R.id.btnAdd);
        btnRemove = findViewById(R.id.btnRemove);
        btnSum = findViewById(R.id.btnSum);
        btnDifference = findViewById(R.id.btnDifference);

    }
    private void setupListener () {
        btnAdd.setOnClickListener(new BtnOnClickListener());
        btnRemove.setOnClickListener(new BtnOnClickListener());
        btnSum.setOnClickListener(new BtnOnClickListener());
        btnDifference.setOnClickListener(new BtnOnClickListener());
    }

    private class BtnOnClickListener implements View.OnClickListener {
        int result = 0;
        @Override
        public void onClick(View view) {
            int count = 0;
            LinearLayout.LayoutParams layoutParams =
                    new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                    );

            EditText edt = new EditText(MainActivity.this);
            edt.setLayoutParams(layoutParams);
            edt.setHint("Enter Number");
            edt.setBackgroundColor(Color.WHITE);
            if (view == btnAdd) {
                editTexts.add(edt);
                mainContainer.addView(edt);
                count++;

            } else if (view == btnRemove) {
                mainContainer.removeView(editTexts.get(count));
                editTexts.remove(count);
                count--;

            } else if (view == btnSum){

                  for (EditText editText : editTexts) {
                      result = result + Integer.parseInt(editText.getText().toString());
                  }

                txtResult.setText(String.valueOf(result));
            } else if (view == btnDifference) {

                for (EditText editText : editTexts) {
                    result = Integer.parseInt(editText.getText().toString()) - result;
                }

                txtResult.setText(String.valueOf(result));
            }

        }
    }

}