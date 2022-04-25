package com.example.qrscsnner.domain.models

import com.example.qrscsnner.utils.CurrentDate

data class ScannerResult(
    var uid: Long = 0,
    val result: String,
    val currentDate: String = CurrentDate.currentDate,
    val currentTime: String = CurrentDate.currentTime
)
