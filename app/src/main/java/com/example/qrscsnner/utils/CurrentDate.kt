package com.example.qrscsnner.utils

import java.text.SimpleDateFormat
import java.util.*

class CurrentDate {
    companion object{
        private val date = Date()
        private val formater: SimpleDateFormat = SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
        private val resultDate = formater.format(date)
        var currentDate = resultDate.substring(0, 10)
        var currentTime = resultDate.substring(10)
    }
}