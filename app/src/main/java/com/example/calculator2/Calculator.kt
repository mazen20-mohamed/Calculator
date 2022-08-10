package com.example.calculator2

import java.util.*

class Calculator {
    var result= 0.0
    private var operand = 0.0
    fun cal(args: ArrayList<String>):Double
    {

        var numbers = LinkedList<String>();
        var temp = LinkedList<String>();
        for(i in args)
        {
            temp.addLast(i)
        }
        for(j in 1..2)
        {
            var iter = 0
            var operation = ""
            for(i in temp)
            {
                if(j==1 &&i=="*")
                {
                    iter = 1
                    operation = "*"
                    continue
                }
                else if(j==1 && iter==1 && operation =="*")
                {
                    iter = 0
                    val operand1 = numbers.last.toDouble()
                    val result = operand1 * i.toDouble()
                    numbers.removeLast()
                    numbers.addLast(result.toString())
                    operation=""
                    continue
                }
                else if(j==1 && i =="/")
                {
                    iter = 1
                    operation= "/"
                    continue
                }
                else if(j==1 && iter==1 && operation=="/")
                {
                    iter = 0
                    val operand1 = numbers.last.toDouble()
                    val result = operand1/ i.toDouble()
                    numbers.removeLast()
                    numbers.addLast(result.toString())
                    operation=""
                    continue
                }
                else if(j==2 && i =="+" )
                {
                    iter = 1
                    operation="+"
                    continue
                }
                else if(j==2 && iter==1 && operation=="+")
                {
                    iter = 0
                    val operand1 = numbers.last.toDouble()
                    val result = operand1+ i.toDouble()
                    numbers.removeLast()
                    numbers.addLast(result.toString())
                    operation=""
                    continue
                }
                else if(j==2 && i =="-")
                {
                    iter = 1
                    operation ="-"
                    continue
                }
                else if(j==2 && iter==1 && operation=="-")
                {
                    iter = 0
                    val operand1 = numbers.last.toDouble()
                    val result = operand1- i.toDouble()
                    numbers.removeLast()
                    numbers.addLast(result.toString())
                    operation=""
                    continue
                }
                numbers.addLast(i)
            }
            if(numbers.size ==1)
                break
            temp.clear()
            for(i in numbers)
            {
                temp.addLast(i)
            }
            numbers.clear()
        }
        return numbers.last.toDouble()
    }
}