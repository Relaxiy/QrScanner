package com.example.qrscsnner.domain

import com.example.qrscsnner.domain.models.ScannerResult
import kotlinx.coroutines.flow.Flow

interface ScannerResultInteractor {

    suspend fun getScannerResults(): Flow<List<ScannerResult>>

    suspend fun saveScannerResult(scannerResult: ScannerResult)
}