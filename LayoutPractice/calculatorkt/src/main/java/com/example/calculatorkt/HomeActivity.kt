package com.example.calculatorkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.calculatorkt.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding : ActivityHomeBinding
    private var pressed = "start"
    private var memory = "0"
    private var answer = 8675309.0
    private var previousCode =1

    //private val binding by lazy {ActivityHomeBinding.inflate(layoutInflater)}

    private fun calculate(){
        val values = (binding.digits2.getText().toString()).split(" ").toTypedArray()
        val size = values.size
        if(size > 0){
            var i=0
            var previousValue = values[i].toDouble()
            val operators = arrayOf("X","/","+","-")
            while(i++ < size){
                if(i+1 < size){
                    for(op in operators){
                        if(op.equals(values[i])){
                            when(op){
                                "X" -> previousValue *= (values[i+1]).toDouble()
                                "+" -> previousValue += (values[i+1]).toDouble()
                                "-" -> previousValue -= (values[i+1]).toDouble()
                                "/" -> previousValue /= (values[i+1]).toDouble()
                            }

                        }
                    }
                    i++
                }
            }

            answer = previousValue
            binding.digits.setText(answer.toString())
        }

    }

    private fun inputHandler(ss: String, code: Int){
        var s = ss
        Log.d("Handler",s)
        Log.d("Handler2",Integer.toString(code))

        if(code >= 0){
            if(code == 2 && previousCode == 1){
                s = " "+s+" "
                calculate()
            }
            val newValue = binding.digits2.getText().toString() + s
            binding.digits2.setText(newValue)
        }
        if(code != 2){
            val newValue = binding.digits.getText().toString() + s
            //if(pressed.equals("X")||pressed.equals("-")||pressed.equals("+")||pressed.equals("/")){
            if(previousCode == 2){
                binding.digits.setText(s)
            }else{
                binding.digits.setText(newValue)
            }

        }
        pressed = s
        previousCode = code
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  binding.DataBindingUtil.setContentView(R.layout.activity_home)



        binding = ActivityHomeBinding.inflate(layoutInflater)
       // View view = binding.getRoot()
      setContentView(binding.root)




        //Code 1 Number Buttons

        binding.ButtonFive.setOnClickListener(){
            val t = binding.ButtonFive.getText().toString()
            inputHandler(t,1)
        }

        binding.ButtonSix.setOnClickListener(){v ->
            val t = binding.ButtonSix.getText().toString()
            inputHandler(t,1)
        }

        binding.ButtonSeven.setOnClickListener(){v ->
            val t = binding.ButtonSeven.getText().toString()
            inputHandler(t,1)
        }

        binding.ButtonNine.setOnClickListener(){v ->
           val t = binding.ButtonNine.getText().toString()
            inputHandler(t,1)
        }

        binding.ButtonTen.setOnClickListener(){v ->
            val t = binding.ButtonTen.getText().toString()
            inputHandler(t,1)
        }

        binding.ButtonEleven.setOnClickListener(){v ->
            val t = binding.ButtonEleven.getText().toString()
            inputHandler(t,1)
        }

        binding.Button13.setOnClickListener(){v ->
            val t = binding.Button13.getText().toString()
            inputHandler(t,1)
        }

        binding.Button14.setOnClickListener(){v ->
            val t = binding.Button14.getText().toString()
            inputHandler(t,1)
        }

        binding.Button15.setOnClickListener(){v ->
            val t = binding.Button15.getText().toString()
            inputHandler(t,1)
        }

        binding.Button18.setOnClickListener(){v ->
            val t = binding.Button18.getText().toString()
            inputHandler(t,1)
        }

        //Code 2 Math Functions

        binding.ButtonFour.setOnClickListener(){v ->
            val t = binding.ButtonFour.getText().toString()
            if(!pressed.equals(t) && previousCode != 2){
                inputHandler(t,2)
            }
        }

        binding.ButtonEight.setOnClickListener(){v ->
            val t = binding.ButtonEight.getText().toString()
            if(!pressed.equals(t) && previousCode != 2){
                inputHandler(t,2)
            }
        }

        binding.ButtonTwelve.setOnClickListener(){v ->
            val t = binding.ButtonTwelve.getText().toString()
            if(!pressed.equals(t) && previousCode != 2){
                inputHandler(t,2)
            }
        }

        binding.Button16.setOnClickListener(){v ->
            val t = binding.Button16.getText().toString()
            if(!pressed.equals(t) && previousCode != 2){
                inputHandler(t,2)
            }
        }

        //Code  Specials
        binding.Button17.setOnClickListener(){v ->
            if(previousCode == 1){
                val t = "-"+binding.digits.getText().toString()

                inputHandler("X",2)
                inputHandler("-1",1)
                binding.digits.setText(t)
            }
        }

        binding.Button19.setOnClickListener(){v ->
            val t = binding.Button19.getText().toString()
            val currentField =  binding.digits.getText().toString()
            // !pressed.equals(t)
            if(!currentField.contains(".")){
                inputHandler(t,3)
            }
        }

        binding.ButtonOne.setOnClickListener(){v ->
            val t = binding.ButtonOne.getText().toString()
            Log.d("Main",t)
            binding.digits.setText("0")
            binding.digits2.setText("")
            previousCode = 4
        }

        //No Code

        binding.ButtonTwo.setOnClickListener(){v ->
            val t = binding.digits.getText().toString()
            memory = t
            // binding.digits3.setText("M")
            Log.d("Main",t)
        }

        binding.ButtonThree.setOnClickListener(){v ->
            binding.digits.setText(memory)
            val newValue = binding.digits2.getText().toString() + memory
            binding.digits2.setText(newValue)
            previousCode = 1
        }

        binding.Button20.setOnClickListener(){v ->
            if(previousCode != 4){
                calculate()
                val newValue = binding.digits.getText().toString() + " Boi!!!"
                binding.digits.setText(newValue)
            }
            Log.d("Main", answer.toString())
        }

    }
}