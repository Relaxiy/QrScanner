package com.example.qrscsnner.domain.ext

import com.example.qrscsnner.data.room.entity.ScannerEntity
import com.example.qrscsnner.domain.models.ScannerResult

fun ScannerResult.toScannerEntity() = ScannerEntity(
    result = result,
    date = currentDate,
    time = currentTime
)

fun ScannerEntity.toScannerResult() = ScannerResult(
    uid = uid,
    result = result,
    currentDate = date,
    currentTime = time
)