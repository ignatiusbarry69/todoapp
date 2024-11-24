package com.dicoding.todoapp.utils

import java.text.SimpleDateFormat
import java.util.*

object DateConverter {
    fun convertMillisToString(timeMillis: Long): String {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = timeMillis
        val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        return sdf.format(calendar.time)
    }
    fun String.changeStringWithThisExactPatternToLongAndYesTheNameOfThisFunctionMustBeAtLeastThisLongToCoverItsDegeneracy():Long {
        return if(this=="Due date") System.currentTimeMillis() else{
            val appDateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
            val date = appDateFormat.parse(this) as Date
            date.time
        }
    }
}