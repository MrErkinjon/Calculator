package com.example.calculator

import java.util.Stack

class ArithmeticEvaluation {
    private fun notOperator(char: Char):Boolean=when(char)
    {
        '+','-','/','*'->false
        else->true
    }
    fun evaluation(string: String):Double
    {
        var str=""
        var stack= Stack<String>()
        for (ch in string)
        {
            if(notOperator(ch) && ch!=' ')
                str+=ch
            else if(ch==' ' && str !="")
            {
                stack.push(str.replace('n','-').toDouble().toString())
                str=""}
            else if(!notOperator(ch))
            {
                var val1:Double=stack.pop().replace(" ","").toDouble()
                var val2:Double=stack.pop().replace(" ","").toDouble()
                when(ch)
                {
                    '+'-> {
                        stack.push((val2 + val1).formattedAmount().replace(" ",""))
                    }
                    '-'-> {
                        stack.push((val2 - val1).formattedAmount().replace(" ",""))
                    }
                    '/'-> {
                        stack.push((val2 / val1).formattedAmount().replace(" ",""))
                    }
                    '*'-> {

                        stack.push((val2 * val1).formattedAmount().replace(" ",""))
                    }
                }
            }
        }
        return stack.pop().toDouble()
    }

    companion object{
        fun Double?.formattedAmount(): String {
            return TextUtils.getFormattedAmount(this)
        }
    }

}