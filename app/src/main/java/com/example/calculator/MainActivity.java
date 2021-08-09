package com.example.calculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.calculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    //연산 결과를 저장
    String history = "";
    //피연산자1
    String number1 = "";
    //피연산자2
    String number2 = "";

    //어떤 연산자가 선택되었는지 확인하기 위한 int형 type변수
    int type;

    int ADD = 0;
    int SUB = 1;
    int MUL = 2;
    int DIV = 3;
    double d1;
    double d2;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnAdd.setOnClickListener(mListener);
        binding.btnSub.setOnClickListener(mListener);
        binding.btnMul.setOnClickListener(mListener);
        binding.btnDiv.setOnClickListener(mListener);
        binding.btnResult.setOnClickListener(mListener);

        //초기화
        Button clear = findViewById(R.id.btn_clear);
        binding.btnClear.setOnClickListener(v -> {
            binding.etShow.setText("");
            binding.etResult.setText("");
            d1 = d2 = 0;
            history = number1 = number2 = "";
        });
    }

    Button.OnClickListener mListener = new Button.OnClickListener() {
        @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
        @Override
        public void onClick(View v) {
            binding.etResult.getText().toString();
            switch (v.getId()) {
                case R.id.btn_add :
                    number1 = binding.etResult.getText().toString();
                    history = binding.etResult.getText().toString() + " + ";
                    binding.etShow.setText(history);
                    binding.etResult.setText("");
                    type = ADD;
                    break;
                case R.id.btn_sub :
                    number1 = binding.etResult.getText().toString();
                    history = binding.etResult.getText().toString() + " - ";
                    binding.etShow.setText(history);
                    binding.etResult.setText("");
                    type = SUB;
                    break;
                case R.id.btn_mul :
                    number1 = binding.etResult.getText().toString();
                    history = binding.etResult.getText().toString() + " * ";
                    binding.etShow.setText(history);
                    binding.etResult.setText("");
                    type = MUL;
                    break;
                case R.id.btn_div :
                    number1 = binding.etResult.getText().toString();
                    history = binding.etResult.getText().toString() + " / ";
                    binding.etShow.setText(history);
                    binding.etResult.setText("");
                    type = DIV;
                    break;
                case R.id.btn_result :
                    double result = 0;
                    number2 = binding.etResult.getText().toString();
                    history = history + binding.etResult.getText().toString();
                    binding.etShow.setText(history);

                    d1 = Double.parseDouble(number1);
                    d2 = Double.parseDouble(number2);

                    if(type == ADD) {
                        result = d1 + d2;
                        binding.etResult.setText("" + result);
                    } else if (type == SUB) {
                        result = d1 - d2;
                        binding.etResult.setText("" + result);
                    }else if (type == MUL) {
                        result = d1 * d2;
                        binding.etResult.setText("" + result);
                    }else if (type == DIV) {
                        result = d1 / d2;
                        binding.etResult.setText("" + result);
                    }
                    number1 = binding.etResult.getText().toString();
                    break;
            }
        }
    };

    @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
    public void onClick (View v)
    {
        switch(v.getId()){
            case R.id.btn0 : binding.etResult.setText(binding.etResult.getText().toString() + 0); break;
            case R.id.btn1 : binding.etResult.setText(binding.etResult.getText().toString() + 1); break;
            case R.id.btn2 : binding.etResult.setText(binding.etResult.getText().toString() + 2); break;
            case R.id.btn3 : binding.etResult.setText(binding.etResult.getText().toString() + 3); break;
            case R.id.btn4 : binding.etResult.setText(binding.etResult.getText().toString() + 4); break;
            case R.id.btn5 : binding.etResult.setText(binding.etResult.getText().toString() + 5); break;
            case R.id.btn6 : binding.etResult.setText(binding.etResult.getText().toString() + 6); break;
            case R.id.btn7 : binding.etResult.setText(binding.etResult.getText().toString() + 7); break;
            case R.id.btn8 : binding.etResult.setText(binding.etResult.getText().toString() + 8); break;
            case R.id.btn9 : binding.etResult.setText(binding.etResult.getText().toString() + 9); break;
        }
    }
}