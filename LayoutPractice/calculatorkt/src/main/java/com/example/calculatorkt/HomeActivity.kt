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
        val values = (binding.digits2.text.toString()).split(" ").toTypedArray()
        val size = values.size
        if(size > 0){
            var i=0
            var previousValue = values[i].toDouble()
            val operators = arrayOf("X","/","+","-")
            while(i++ < size){
                if(i+1 < size){
                    for(op in operators){
                        if(op == values[i]){
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
            binding.digits.text = (answer.toString())
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
            val newValue = binding.digits2.text.toString() + s
            binding.digits2.text = (newValue)
        }
        if(code != 2){
            val newValue = binding.digits.text.toString() + s
            //if(pressed.equals("X")||pressed.equals("-")||pressed.equals("+")||pressed.equals("/")){
            if(previousCode == 2){
                binding.digits.text = (s)
            }else{
                binding.digits.text = (newValue)
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

        binding.ButtonFive.setOnClickListener{
            val t = binding.ButtonFive.text.toString()
            inputHandler(t,1)
        }

        binding.ButtonSix.setOnClickListener{
            val t = binding.ButtonSix.text.toString()
            inputHandler(t,1)
        }

        binding.ButtonSeven.setOnClickListener{
            val t = binding.ButtonSeven.text.toString()
            inputHandler(t,1)
        }

        binding.ButtonNine.setOnClickListener{
            val t = binding.ButtonNine.text.toString()
            inputHandler(t,1)
        }

        binding.ButtonTen.setOnClickListener{
            val t = binding.ButtonTen.text.toString()
            inputHandler(t,1)
        }

        binding.ButtonEleven.setOnClickListener{
            val t = binding.ButtonEleven.text.toString()
            inputHandler(t,1)
        }

        binding.Button13.setOnClickListener{
            val t = binding.Button13.text.toString()
            inputHandler(t,1)
        }

        binding.Button14.setOnClickListener{
            val t = binding.Button14.text.toString()
            inputHandler(t,1)
        }

        binding.Button15.setOnClickListener{
            val t = binding.Button15.text.toString()
            inputHandler(t,1)
        }

        binding.Button18.setOnClickListener{
            val t = binding.Button18.text.toString()
            inputHandler(t,1)
        }

        //Code 2 Math Functions

        binding.ButtonFour.setOnClickListener{
            val t = binding.ButtonFour.text.toString()
            if(pressed != t && previousCode != 2){
                inputHandler(t,2)
            }
        }

        binding.ButtonEight.setOnClickListener{
            val t = binding.ButtonEight.text.toString()
            if(pressed != t && previousCode != 2){
                inputHandler(t,2)
            }
        }

        binding.ButtonTwelve.setOnClickListener{
            val t = binding.ButtonTwelve.text.toString()
            if(pressed != t && previousCode != 2){
                inputHandler(t,2)
            }
        }

        binding.Button16.setOnClickListener{
            val t = binding.Button16.text.toString()
            if(pressed != t && previousCode != 2){
                inputHandler(t,2)
            }
        }

        //Code  Specials
        binding.Button17.setOnClickListener{
            if(previousCode == 1){
                val t = "-"+binding.digits.text.toString()

                inputHandler("X",2)
                inputHandler("-1",1)
                binding.digits.text = (t)
            }
        }

        binding.Button19.setOnClickListener{
            val t = binding.Button19.text.toString()
            val currentField =  binding.digits.text.toString()
            // !pressed.equals(t)
            if(!currentField.contains(".")){
                inputHandler(t,3)
            }
        }

        binding.ButtonOne.setOnClickListener{
            val t = binding.ButtonOne.text.toString()
            Log.d("Main",t)
            binding.digits.text = ("0")
            binding.digits2.text = ("")
            previousCode = 4
        }

        //No Code

        binding.ButtonTwo.setOnClickListener{
            val t = binding.digits.text.toString()
            memory = t
            // binding.digits3.text = ("M")
            Log.d("Main",t)
        }

        binding.ButtonThree.setOnClickListener{
            binding.digits.text = (memory)
            val newValue = binding.digits2.text.toString() + memory
            binding.digits2.text = (newValue)
            previousCode = 1
        }

        binding.Button20.setOnClickListener{
            if(previousCode != 4){
                calculate()
                val newValue = binding.digits.text.toString() + " Boi!!!"
                binding.digits.text = (newValue)
            }
            Log.d("Main", answer.toString())
        }

    }
}