package com.example.calculator2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    private lateinit var result: TextView
    private lateinit var operation:TextView
    private val calculator = Calculator()
    private var arr = arrayListOf<String>()
    private var operand = ""
    private var sqrtt = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        result = findViewById<TextView>(R.id.result)
        operation = findViewById<TextView>(R.id.operation)

        // button equal
        val btnEqual = findViewById<Button>(R.id.equal)
        btnEqual.setOnClickListener{
            if(arr.size!=0 && operand !="")
            {
                if(sqrtt==true)
                {
                    arr.add(sqrt(operand.toDouble()).toString())
                    sqrtt = false
                }
                else{
                    arr.add(operand)
                }
                operand=""
                if(arr.size ==1)
                {
                    result.text = arr[0]
                }
                else
                    result.text = calculator.cal(arr).toString()
            }
            else
            {
                result.text= "0"
            }
        }
        numberListener()
        val btnSqrt = findViewById<Button>(R.id.sqrt)
        btnSqrt.setOnClickListener{
            sqrtt = true
        }
        val btnAc = findViewById<Button>(R.id.ac)
        btnAc.setOnClickListener{
            result.text=""
            operation.text=""
            operand= ""
            arr.clear()
            sqrtt = false
        }
        val btnPlus = findViewById<Button>(R.id.plus)
        btnPlus.setOnClickListener {
            handleOperation("+")
        }
        val btnMinus = findViewById<Button>(R.id.minus)
        btnMinus.setOnClickListener {
            handleOperation("-")
        }
        val btnMultiply = findViewById<Button>(R.id.multiply)
        btnMultiply.setOnClickListener {
            handleOperation("*")
        }
        val btnDiv = findViewById<Button>(R.id.div)
        btnDiv.setOnClickListener {
            handleOperation("/")
        }
    }
    fun numberListener()
    {
        val btnZero = findViewById<Button>(R.id.zero)
        btnZero.setOnClickListener{
            handleDigit(0)
        }
        val btnOne = findViewById<Button>(R.id.one)
        btnOne.setOnClickListener{
            handleDigit(1)
        }
        val btnTwo = findViewById<Button>(R.id.two)
        btnTwo.setOnClickListener{
            handleDigit(2)
        }
        val btnThree = findViewById<Button>(R.id.three)
        btnThree.setOnClickListener{
            handleDigit(3)
        }
        val btnFour = findViewById<Button>(R.id.four)
        btnFour.setOnClickListener{
            handleDigit(4)
        }
        val btnFive = findViewById<Button>(R.id.five)
        btnFive.setOnClickListener{
            handleDigit(5)
        }
        val btnSix = findViewById<Button>(R.id.six)
        btnSix.setOnClickListener {
            handleDigit(6)
        }
        val btnSeven = findViewById<Button>(R.id.seven)
        btnSeven.setOnClickListener {
            handleDigit(7)
        }
        val btnEight = findViewById<Button>(R.id.eight)
        btnEight.setOnClickListener {
            handleDigit(8)
        }
        val btnNine = findViewById<Button>(R.id.nine)
        btnNine.setOnClickListener {
            handleDigit(9)
        }
    }
    fun handleDigit(digit:Int)
    {
        operation.text = "${operation.text}${digit}"
        operand += digit.toString()
    }
    fun handleOperation(opera:String)
    {
        operation.text ="${operation.text}${opera}"
        if(operand!="")
        {
            if(sqrtt == true)
            {
                arr.add((sqrt(operand.toDouble())).toString())
                sqrtt =false
            }
            else{
                arr.add(operand)
            }
            operand = ""
        }
        arr.add(opera)
    }
}