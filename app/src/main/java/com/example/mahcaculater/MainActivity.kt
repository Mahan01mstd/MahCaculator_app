package com.example.mahcaculater

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import com.example.mahcaculater.databinding.ActivityMainBinding
import org.mariuszgromada.math.mxparser.Expression
import java.lang.Exception
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(this.layoutInflater)
        setContentView(binding.root)

      binding.buttonClear.setOnClickListener {
          binding.input.text = ""
          binding.output.text = ""
      }
        binding.buttonParenthesesLeft.setOnClickListener {
            binding.input.text = addToInput("(")
        }
        binding.buttonParenthesesRight.setOnClickListener {
            binding.input.text = addToInput(")")
        }
        binding.button1.setOnClickListener {
            binding.input.text = addToInput("1")
        }
        binding.button2.setOnClickListener {
            binding.input.text = addToInput("2")
        }
        binding.button3.setOnClickListener {
            binding.input.text = addToInput("3")
        }
        binding.button4.setOnClickListener {
            binding.input.text = addToInput("4")
        }
        binding.button5.setOnClickListener {
            binding.input.text = addToInput("5")
        }
        binding.button6.setOnClickListener {
            binding.input.text = addToInput("6")
        }
        binding.button7.setOnClickListener {
            binding.input.text = addToInput("7")
        }
        binding.button8.setOnClickListener {
            binding.input.text = addToInput("8")
        }
        binding.button9.setOnClickListener {
            binding.input.text = addToInput("9")
        }
        binding.button0.setOnClickListener {
            binding.input.text = addToInput("0")
        }
        binding.buttonDot.setOnClickListener {
            binding.input.text = addToInput(".")
        }
        binding.buttonAddling.setOnClickListener {
            binding.input.text = addToInput("+")
        }
        binding.buttonDecrease.setOnClickListener {
            binding.input.text = addToInput("-")
        }
        binding.buttonDivision.setOnClickListener {
            binding.input.text = addToInput("÷")
        }
        binding.buttonCross.setOnClickListener {
            binding.input.text = addToInput("×")
        }
        binding.buttonEqual.setOnClickListener {
            showReasult()
        }

    }
    private fun addToInput(buttonValue : String): String{
        return "${binding.input.text}$buttonValue"
    }

    private fun getInputExpression(): String{
        var expression = binding.input.text.replace(Regex("÷"),"/")
        expression = expression.replace(Regex("×"),"*")
        return expression
    }
    private fun showReasult(){
        try {
            val expression = getInputExpression()
            val result = Expression(expression).calculate()
            if (result.isNaN()){
                //Show Error Messsage
                binding.output.text = "Error"
                binding.output.setTextColor(ContextCompat.getColor(this,R.color.red))
            }else{
                binding.output.text =DecimalFormat("0.######").format(result).toString()
                binding.output.setTextColor(ContextCompat.getColor(this,R.color.orange))
            }
        }catch (e:Exception){
            //Show Error Message
            binding.output.text = "Error"
            binding.output.setTextColor(ContextCompat.getColor(this,R.color.green))
        }
    }
}