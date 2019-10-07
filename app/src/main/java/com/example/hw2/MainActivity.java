package com.example.hw2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;


public class MainActivity extends AppCompatActivity {
    private Button button;
    private EditText editText;
    private TextView textView;
    private TextView textView2;
    byte ClickTime = 0;
    float height,weight,bmivalue;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        editText = findViewById(R.id.editText2);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);

    }
    public  void buttonClick(View view){


        //if (Integer.parseInt(editText.getText().toString())<=0||editText.getText().toString().matches("")==true) {
        //    Toast toast = Toast.makeText(MainActivity.this, "不要開玩笑!!", Toast.LENGTH_LONG);
        //   toast.show();
        //}
        //else {
            Toast toast = Toast.makeText(this, "", Toast.LENGTH_SHORT);

            ClickTime++;
            if (ClickTime == 3) {
                ClickTime = 0;
            }


            switch (ClickTime) {
                case 0:
                    editText.setFocusableInTouchMode(true);
                    editText.setFocusable(true);
                    textView2.setText(R.string.BMIText);
                    textView.setText("輸入身高");
                    button.setText(R.string.checkText);


                    break;
                case 1:

                    textView.setText("輸入體重");
                    height = Integer.parseInt(editText.getText().toString());


                    break;
                case 2:
                    textView.setText("完成");
                    weight = Integer.parseInt(editText.getText().toString());
                    bmivalue = weight / ((height * height) / 10000);

                    BigDecimal BD = new BigDecimal(bmivalue);
                    float ValueT2D = BD.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();//取小數末兩位、四捨五入
                    textView2.setText("BMI  " + ValueT2D);
                    if (ValueT2D < 18.5) {
                        toast = Toast.makeText(this, "太輕囉~", Toast.LENGTH_SHORT);
                    } else if (ValueT2D < 24) {
                        toast = Toast.makeText(this, "很健康，繼續保持!!", Toast.LENGTH_SHORT);
                    } else {
                        toast = Toast.makeText(this, "多多運動", Toast.LENGTH_SHORT);
                    }
                    button.setText("再一次");
                    editText.setFocusable(false);
                    editText.setFocusableInTouchMode(false);
                    break;
            }
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
            toast.show();
            editText.setText("");


        //}
    }


}
