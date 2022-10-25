package com.example.calculator

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*

class TextUtils {
    companion object {


        fun getFormattedAmount(amount: Double?): String {
            if (amount == null) {
                return ""
            }

            val formatSymbols = DecimalFormatSymbols(Locale.ENGLISH)
            formatSymbols.decimalSeparator = '.'
            formatSymbols.groupingSeparator = ' '
            val formatter = DecimalFormat("###,###.##", formatSymbols)
            var result = formatter.format(amount)
            return result
        }
    }

}