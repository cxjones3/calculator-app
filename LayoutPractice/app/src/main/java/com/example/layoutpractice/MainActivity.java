package com.example.layoutpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.layoutpractice.databinding.ActivityRelativeBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityRelativeBinding binding;
    private String pressed = "start";
    private String memory;
    private double answer;
    private int previousCode =1;

    private void calculate(){
        String[] values = (binding.digits2.getText().toString()).split(" ");
        int size = values.length;
        if(size > 0){
            int i=0;
            double previousValue = Double.parseDouble(values[i]);
            String[] operators = new String[]{"X","/","+","-"};
            while(i++ < size){
                if(i+1 < size){
                    for(String op: operators){
                        if(op.equals(values[i])){
                            switch(op){
                                case "X":
                                    previousValue *= Double.parseDouble(values[i+1]);
                                    break;
                                case "+":
                                    previousValue += Double.parseDouble(values[i+1]);
                                    break;
                                case "-":
                                    previousValue -= Double.parseDouble(values[i+1]);
                                    break;
                                case "/":
                                    previousValue /= Double.parseDouble(values[i+1]);
                                    break;
                            }

                        }
                    }
                    i++;
                }
            }

            answer = previousValue;
            binding.digits.setText(Double.toString(answer));
        }

    }

    private void inputHandler(String s, int code){
        Log.d("Handler",s);
        Log.d("Handler2",Integer.toString(code));

        if(code >= 0){
            if(code == 2 && previousCode == 1){
                s = " "+s+" ";
                calculate();
            }
            String newValue = binding.digits2.getText().toString() + s;
            binding.digits2.setText(newValue);
        }
        if(code != 2){
            String newValue = binding.digits.getText().toString() + s;
            //if(pressed.equals("X")||pressed.equals("-")||pressed.equals("+")||pressed.equals("/")){
            if(previousCode == 2){
                binding.digits.setText(s);
            }else{
                binding.digits.setText(newValue);
            }

        }
        pressed = s;
        previousCode = code;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRelativeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);




        //Code 1 Number Buttons

        binding.ButtonFive.setOnClickListener(v ->{
            String t = binding.ButtonFive.getText().toString();
            inputHandler(t,1);
        });

        binding.ButtonSix.setOnClickListener(v ->{
            String t = binding.ButtonSix.getText().toString();
            inputHandler(t,1);
        });

        binding.ButtonSeven.setOnClickListener(v ->{
            String t = binding.ButtonSeven.getText().toString();
            inputHandler(t,1);
        });

        binding.ButtonNine.setOnClickListener(v ->{
            String t = binding.ButtonNine.getText().toString();
            inputHandler(t,1);
        });

        binding.ButtonTen.setOnClickListener(v ->{
            String t = binding.ButtonTen.getText().toString();
            inputHandler(t,1);
        });

        binding.ButtonEleven.setOnClickListener(v ->{
            String t = binding.ButtonEleven.getText().toString();
            inputHandler(t,1);
        });

        binding.Button13.setOnClickListener(v ->{
            String t = binding.Button13.getText().toString();
            inputHandler(t,1);
        });

        binding.Button14.setOnClickListener(v ->{
            String t = binding.Button14.getText().toString();
            inputHandler(t,1);
        });

        binding.Button15.setOnClickListener(v ->{
            String t = binding.Button15.getText().toString();
            inputHandler(t,1);
        });

        binding.Button18.setOnClickListener(v ->{
            String t = binding.Button18.getText().toString();
            inputHandler(t,1);
        });

        //Code 2 Math Functions

        binding.ButtonFour.setOnClickListener(v ->{
            String t = binding.ButtonFour.getText().toString();
            if(!pressed.equals(t)){
                inputHandler(t,2);
            }
        });

        binding.ButtonEight.setOnClickListener(v ->{
            String t = binding.ButtonEight.getText().toString();
            if(!pressed.equals(t)){
                inputHandler(t,2);
            }
        });

        binding.ButtonTwelve.setOnClickListener(v ->{
            String t = binding.ButtonTwelve.getText().toString();
            if(!pressed.equals(t)){
                inputHandler(t,2);
            }
        });

        binding.Button16.setOnClickListener(v ->{
            String t = binding.Button16.getText().toString();
            if(!pressed.equals(t)){
                inputHandler(t,2);
            }
        });

        //Code  Specials
        binding.Button17.setOnClickListener(v ->{
            if(previousCode == 1){
                String t = "-"+binding.digits.getText().toString();

                inputHandler("X",2);
                inputHandler("-1",1);
                binding.digits.setText(t);
            }
        });

        binding.Button19.setOnClickListener(v ->{
            String t = binding.Button19.getText().toString();
            String currentField =  binding.digits.getText().toString();
           // !pressed.equals(t)
            if(!currentField.contains(".")){
                inputHandler(t,3);
            }
        });

        binding.ButtonOne.setOnClickListener(v ->{
            String t = binding.ButtonOne.getText().toString();
            Log.d("Main",t);
            binding.digits.setText("0");
            binding.digits2.setText("");
            previousCode = 4;
        });

        //No Code

        binding.ButtonTwo.setOnClickListener(v ->{
            String t = binding.digits.getText().toString();
            memory = t;
           // binding.digits3.setText("M");
            Log.d("Main",t);
        });

        binding.ButtonThree.setOnClickListener(v ->{
            binding.digits.setText(memory);
            String newValue = binding.digits2.getText().toString() + memory;
            binding.digits2.setText(newValue);
            previousCode = 1;
        });

        binding.Button20.setOnClickListener(v ->{
            if(previousCode != 4){
                calculate();
            }
            Log.d("Main", Double.toString(answer));
        });

    }
}